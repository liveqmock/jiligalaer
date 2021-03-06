package sy.service.product;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Table;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import sy.common.model.QueryContext;
import sy.common.util.cloudstack.AbstractServiceSupport;
import sy.common.util.cloudstack.CSQuqeyContext;
import sy.common.util.cloudstack.CloudBean;
import sy.common.util.cloudstack.Param;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.RepositoryFactory;
import sy.common.util.move.Mover;
import sy.common.util.reflect.FieldUtils;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.shared.CloudPersistentObject;
import sy.domain.vo.product.CloudDataSyncBuilder;
import sy.service.shared.BaseServiceTemplate;

/**
 * 
 * @author lidongbo
 * 
 */
public class SynchronizeDataService<PO extends CloudPersistentObject, VO extends CloudDataSyncBuilder<?>>
		extends BaseServiceTemplate<PO, VO> {

	private static final Logger log = Logger
			.getLogger(SynchronizeDataService.class);
	
	@SuppressWarnings("unchecked")
	public <T extends CloudBean> VO createVo(T cloudBean){
		CloudDataSyncBuilder<T> builder = (CloudDataSyncBuilder<T>) newVoInstance();
		return (VO) builder.build(cloudBean);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends CloudBean> List<VO> getDatesFromInterface(Param ... params) throws ValidatorException {

		List<VO> result = new ArrayList<VO>();

		List<Param> paramters = new ArrayList<Param>();
		paramters.add(new Param("listall", "true"));
		if (params != null && params.length > 0) {
			for (Param param : params) {
				paramters.add(param);
			}
		}
		
		ProviderContext context = new ProviderContext();
		CSQuqeyContext qc = new CSQuqeyContext(paramters.toArray(new Param[] {}));

		VO vo = newVoInstance();

		AbstractServiceSupport<T> repository = (AbstractServiceSupport<T>) RepositoryFactory
				.getRepository(vo.getCloudBeanClass(), context);

		List<T> cloudBeans = repository.list(qc);
		
		for (T cloudBean : cloudBeans) {
			result.add(createVo(cloudBean));
		}
		
		return result;

	}
	
	protected boolean voEqualsPoCondition(VO vo,PO po){
		String pifId = po.getInterfaceId();
		String vifId = vo.getInterfaceId();
		return pifId.equals(vifId);
	}
	
	protected boolean voExistInPos(VO vo, List<PO> pos,Field poIdField) throws ValidatorException{
		boolean exists = false;
		
		for (PO po : pos) {
			if(po==null){
				continue;
			}
			
			//如果接口ID 已存在于库中则更新
			if(voEqualsPoCondition(vo,po)){
				exists = true;
				try {
					Object idValue = poIdField.get(po);
					Mover.getInstance().move(vo, po);
					poIdField.set(po, idValue);
				} catch (Exception e) {
					throw new ValidatorException("对象标识获取时发生错误!",e);
				}
			}
		}
		return exists;
	}
	
	protected boolean poExistInVos(PO po, List<VO> vos) throws ValidatorException{
		boolean exists = false;

		for (VO vo : vos) {
			if(vo == null){
				continue;
			}
			
			if(voEqualsPoCondition(vo, po)){
				exists = true;
			}
		}
		
		return exists;
	}
	
	protected void sync(List<VO> vos)
			throws ValidatorException {
		
		QueryContext context = new QueryContext();
		context.setPaging(false);
		context.equals("dataState", "1");
		List<PO> pos = list(poClass, context);
		
		String idName = getIdName(poClass);
		Field poIdField = null;
		try {
			poIdField = FieldUtils.getFieldFromHierarchy(poClass, idName);
			poIdField.setAccessible(true);
		} catch (Exception e) {
			throw new ValidatorException("对象标识获取时发生错误!",e);
		}
		
		for (VO vo : vos) {
			boolean exists = voExistInPos(vo, pos, poIdField);
			
			//如果接口中存在 不存在于库中则写入
			if(!exists){
				vo.setSyncCreatedTime(new Date());
				save(vo);
			}
		}
		
		//如果接口中不存在 而 库中存在，则库中的置为无效即可
		for (PO po : pos) {
			
			if(po == null){
				continue;
			}
			
			boolean exists = poExistInVos(po, vos);
			
			if (!exists) {
				po.setDataState(0);
				po.setSyncTime(new Date());
				invalid(po);
			}
		}
	}
	
	public void sync() throws ValidatorException {
		log.info("同步数据[开始]."+this.getClass().getSimpleName());
		Table table = poClass.getAnnotation(Table.class);
		getBaseDao().findBySQL("Select * from "+table.name()+" for update;");
		List<VO> vos = getDatesFromInterface();
		sync(vos);
		afterSync(vos);
		log.info("同步数据[结束]."+this.getClass().getSimpleName());
	}

	/**
	 * 同步更新已存在的一个实体的逻辑
	 * @param id
	 * @param context
	 * @throws ValidatorException
	 */
	public void sync(String id, ProviderContext context)
			throws ValidatorException {
		CSQuqeyContext qc = new CSQuqeyContext(new Param("listall", "true"));
		qc.addParameter(new Param("id", id));

		VO vo = newVoInstance();
		AbstractServiceSupport<? extends CloudBean> service = RepositoryFactory
				.getRepository(vo.getCloudBeanClass(), context);
		List<? extends CloudBean> beans = service.list(qc);

		String idName = getIdName(poClass);
		Field poIdField = null;
		try {
			poIdField = FieldUtils.getFieldFromHierarchy(poClass, idName);
			poIdField.setAccessible(true);
		} catch (Exception e) {
			throw new ValidatorException("对象标识获取时发生错误!", e);
		}

		if (CollectionUtils.isNotEmpty(beans)) {
			CloudBean bean = beans.get(0);
			vo = createVo(bean);
			PO po = findUnique(poClass, "From " + poClass.getSimpleName()
					+ " Where interfaceId = ? And dataState = 1", id);
			try {
				Object idValue = poIdField.get(po);
				Mover.getInstance().move(vo, po);
				poIdField.set(po, idValue);
			} catch (Exception e) {
				throw new ValidatorException("对象标识获取时发生错误!", e);
			}
		}
	}
	
	protected void invalid(PO po) throws ValidatorException{
		invalid(po.getInterfaceId());
	}
	
	protected void invalid(String interfaceId) throws ValidatorException{
		
	}
	
	protected void afterSync(List<VO> vos) throws ValidatorException{
		
	}
}
