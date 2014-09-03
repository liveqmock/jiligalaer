package sy.service.shared;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import sy.common.exception.AppRuntimeException;
import sy.common.model.QueryContext;
import sy.common.util.generics.GenericsUtils;
import sy.common.util.move.Mover;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.shared.PersistentObject;
import sy.domain.vo.shared.BaseVo;

/**
 * 
 * @author lidongbo
 * 
 */
public class BaseServiceTemplate<PO extends PersistentObject, VO extends BaseVo> extends BaseService
		implements SaveCallback<VO,PO>, DeleteCallback<PO>, Newable<PO> {

	private static final Logger log = Logger
			.getLogger(BaseServiceTemplate.class);

	protected Class<PO> poClass;

	protected Class<VO> voClass;

	@SuppressWarnings("unchecked")
	public BaseServiceTemplate() {
		poClass = GenericsUtils.getSuperClassGenricType(getClass(), 0);
		voClass = GenericsUtils.getSuperClassGenricType(getClass(), 1);
	}

	public List<VO> list(QueryContext context)  throws ValidatorException{
		return list(poClass, voClass, context);
	}

	public List<VO> list(QueryContext context, String queryString,
			Object... params) {
		return list(poClass, voClass, context, queryString, params);
	}
	
	public List<VO> listBySql(QueryContext context, String queryString,
			Object... params) throws ValidatorException {
		return listBySql(voClass, context, queryString, params);
	}
	
	public VO findUniqueBySql(String queryString, Object... params) {
		return findUniqueBySql(voClass, queryString, params);
	}
	
	public VO get(Serializable id) throws ValidatorException {
		return get(poClass, voClass, id ,new InitCallback<VO>(){
			@Override
			public VO newInstance() {
				return newVoInstance();
			}
			@Override
			public void postinit(VO t)  throws ValidatorException{
				BaseServiceTemplate.this.postinit(t);
			}
		});
	}

	@Override
	public void presave(VO vo,PO po) throws ValidatorException{

	}

	@Override
	public void postsave(VO vo,PO t) throws ValidatorException{

	}

	public void save(VO vo) throws ValidatorException {
		save(poClass, vo, this);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void saveAll(Collection<VO> collection) throws ValidatorException {
		for (Iterator it = collection.iterator(); it.hasNext();) {
			save((VO) it.next());
		}
	}
	
	public void delete(Serializable id) throws ValidatorException {
		delete(poClass, id, this);
	}

	@Override
	public PO newInstance() {
		try {
			return poClass.newInstance();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new AppRuntimeException(e);
		}
	}

	@Override
	public void predelete(PO t) throws ValidatorException{
		
	}

	public VO newVoInstance() {
		try {
			return voClass.newInstance();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new AppRuntimeException(e);
		}
	}

	public void postinit(VO t) throws ValidatorException{
		
	}

	@SuppressWarnings("unchecked")
	public List<VO> find(String hql, Object... param){
		return Mover.getInstance().move(getBaseDao().find(hql, param), voClass);
	}
	
	
	public VO findUnique(String hql, Object... params) {
		return Mover.getInstance().move(
				findUnique(poClass, hql, params), voClass);
	}
}
