package sy.service.shared;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import sy.common.exception.AppRuntimeException;
import sy.common.model.QueryContext;
import sy.common.util.NumberUtils;
import sy.common.util.StringUtils;
import sy.common.util.move.Mover;
import sy.common.util.reflect.FieldUtils;
import sy.common.util.validator.ValidatorException;
import sy.common.util.validator.ValidatorMessage;
import sy.common.util.validator.ValidatorRuntimeException;
import sy.common.util.valuesetter.Create;
import sy.common.util.valuesetter.Hierarchy;
import sy.common.util.valuesetter.Update;
import sy.dao.common.BaseDaoI;
import sy.domain.model.shared.PersistentObject;
import sy.domain.vo.shared.BaseVo;
import sy.ext.hibernate.DynamicAliasToBeanResultTransformer;

/**
 * 
 * @author lidongbo
 * 
 */
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {
		RuntimeException.class, UnsupportedOperationException.class,
		SQLException.class, JDBCException.class, AppRuntimeException.class,
		ValidatorException.class })
public class BaseService {

	private static final Logger log = Logger.getLogger(BaseService.class);

	private BaseDaoI baseDao;

	private Validator validator;

	public BaseDaoI getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(BaseDaoI baseDao) {
		this.baseDao = baseDao;
	}

	public Validator getValidator() {
		return validator;
	}

	@Autowired
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public void check(Object source, Class<?>... groups)
			throws ValidatorException {
		ValidatorRuntimeException e = new ValidatorRuntimeException();
		Set<ConstraintViolation<Object>> result = validator.validate(source,
				groups);
		for (ConstraintViolation<Object> constraintViolation : result) {
			ValidatorMessage validatorErrorMessage = new ValidatorMessage(
					constraintViolation.getMessage());
			e.addErrorMessage(validatorErrorMessage);
			log.debug(validatorErrorMessage);
		}
		if (e.messageSize() > 0) {
			throw new ValidatorException(e);
		}
	}

	public Query createQuery(String queryString, Object... values) {
		Query query = baseDao.getSession().createQuery(queryString);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	
	public Query createsSqlQuery(String queryString, Object... values) {
		Query query = baseDao.getSession().createSQLQuery(queryString);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> list(Class<T> clzz, QueryContext context,
			String queryString, Object... params) {
		return (List<T>) list(context, queryString, params);
	}
	
	private List<?> list(QueryContext context,
			String queryString, Object... params) {
		int pageNo = context.getPageNo();
		int pageSize = context.getPageSize();
		Query query = createQuery(queryString, params);
		if (context.isPaging()) {

			ScrollableResults scrollableResults = query
					.scroll(ScrollMode.SCROLL_SENSITIVE);
			scrollableResults.last();
			context.setTotalRowCount(scrollableResults.getRowNumber() + 1);
			context.compute();

			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		} else {
			context.setTotalRowCount(Integer.MAX_VALUE);
		}
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> listBySql(Class<T> clzz, QueryContext context,
			String queryString, Object... params) {
		int pageNo = context.getPageNo();
		int pageSize = context.getPageSize();
		
		Query query = createsSqlQuery(queryString, params);
		
		query.setResultTransformer( new DynamicAliasToBeanResultTransformer(clzz)   /*Transformers.aliasToBean(clzz)*/);
		
		if (context.isPaging()) {

			ScrollableResults scrollableResults = query
					.scroll(ScrollMode.SCROLL_SENSITIVE);
			scrollableResults.last();
			context.setTotalRowCount(scrollableResults.getRowNumber() + 1);
			context.compute();

			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}else{
			context.setTotalRowCount(Integer.MAX_VALUE);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public <T> T findUniqueBySql(Class<T> clzz,String queryString, Object... params) {
		T object = null;
		try {
			Query query = createsSqlQuery(queryString, params);
			query.setResultTransformer( new DynamicAliasToBeanResultTransformer(clzz));
			
			object = (T) query.setMaxResults(1)
					.uniqueResult();
		} catch (Exception e) {
			throw new AppRuntimeException(e.getMessage() + ":" + queryString,e);
		}
		return object;
	}
	
	public <T> List<T> list(Class<T> clzz, QueryContext context) {
		String queryString = new StringBuilder("from ")
				.append(clzz.getSimpleName()).append(" ").append("this")
				.append(" where 1=1 ").append(context.buildHqlConditions("this"))
				.append(context.buildSort("this"))
				.toString();
		return list(clzz, context, queryString);
	}

	public <T, VO extends BaseVo> List<VO> list(Class<T> clzz,
			Class<VO> voClzz, QueryContext context) {
		return Mover.getInstance().move(list(clzz, context), voClzz);
	}

	public <T, VO extends BaseVo> List<VO> list(Class<T> clzz,
			Class<VO> voClzz, QueryContext context, String queryString,
			Object... params) {
		return Mover.getInstance().move(list(context, queryString), voClzz);
	}

	public <T, VO extends BaseVo> VO get(Class<T> clzz, Class<VO> voClzz,
			Serializable id,InitCallback<VO> icb) throws ValidatorException {

		VO result = null;
		if (id != null && StringUtils.isNotBlank(String.valueOf(id))) {
			result = Mover.getInstance().move(baseDao.get(clzz, id), voClzz);
		} else {
			result = icb.newInstance();
		}
		
		icb.postinit(result);
		return result;
	}

	private <VO extends BaseVo> void initAutoValues(VO vo,Class<? extends Annotation> clzz){
		Field[] fields = vo.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(clzz)
					&& Date.class.isAssignableFrom(field.getType())) {
				field.setAccessible(true);
				try {
					field.set(vo, new Date());
				} catch (Exception e) {
					throw new AppRuntimeException(e);
				}
			} else if (field.isAnnotationPresent(clzz)
					&& String.class.isAssignableFrom(field.getType())) {
				field.setAccessible(true);
				try {
					field.set(vo, vo.getExecutorName());
				} catch (Exception e) {
					throw new AppRuntimeException(e);
				}
			}
		}
	}

	public <PO extends PersistentObject, VO extends BaseVo, Callback extends SaveCallback<VO,PO> & Newable<PO>> void save(
			Class<PO> poClzz, VO vo, Callback cb) throws ValidatorException {
		if (vo == null) {
			return;
		}
		boolean isUpdate = true;
		String idName = getIdName(poClzz);
		Field voIdField = null;
		Field poIdField = null;
		try {
			voIdField = FieldUtils.getFieldFromHierarchy(vo.getClass(), idName);
			poIdField = FieldUtils.getFieldFromHierarchy(poClzz, idName);
		} catch (Exception e) {
			throw new ValidatorException("对象标识获取时发生错误!",e);
		}
		
		if(voIdField == null
				|| poIdField == null){
			throw new ValidatorException("对象标识不存在，请调整类属性定义!");
		}
		
		voIdField.setAccessible(true);
		
		Serializable id;
		try {
			id = (Serializable) voIdField.get(vo);
		} catch (Exception e) {
			throw new ValidatorException("vo中的标识定义不正确!",e);
		}

		PO po = null;
		if (id != null && StringUtils.isNotBlank(String.valueOf(id))) {
			po = getBaseDao().get(poClzz, id);
		} else {
			try {
				voIdField.set(vo, null);
			} catch (IllegalArgumentException e) {
				//ignore
			} catch (IllegalAccessException e) {
				//ignore
			}
		}

		if (po == null) {
			isUpdate = false;
			po = cb.newInstance();
		}
		
		if (isUpdate) {
			initAutoValues(vo,Update.class);
		} else {
			initAutoValues(vo,Create.class);
		}

		Mover.getInstance().move(vo, po);
		
		Field[] poFiedls = poClzz.getDeclaredFields();
		evictFields(po,poFiedls);
		cb.presave(vo,po);
		getBaseDao().saveOrUpdate(po);
		if(!isUpdate){
			poIdField.setAccessible(true);
			try {
				voIdField.set(vo, poIdField.get(po));
			} catch (IllegalArgumentException e) {
				throw new ValidatorException("po与vo的标识类型不一致!",e);
			} catch (IllegalAccessException e) {
				//ignore
			}
		}
		cb.postsave(vo,po);
	}

	private <PO> void evictFields(PO obj,Field[] poFiedls) {
		for (Field poField : poFiedls) {
			Class<?> fieldType = poField.getType();
			if(String.class.isAssignableFrom(fieldType)
					|| fieldType.isPrimitive()
					|| Integer.class.isAssignableFrom(fieldType)
					|| Double.class.isAssignableFrom(fieldType)
					|| Long.class.isAssignableFrom(fieldType)
					|| Date.class.isAssignableFrom(fieldType)){
				continue;
			}
			poField.setAccessible(true);
			Object val = null;
			Class<? extends Object> valClzz = null;
			try {
				val = poField.get(obj);
				if (val == null) {
					continue;
				}
				getBaseDao().getSession().evict(val);
				valClzz = val.getClass();
				String idName = getIdName(valClzz);
				if (StringUtils.isNotBlank(idName)) {
					Field valIdField = FieldUtils.getFieldFromHierarchy(valClzz, idName);
					if(String.class.isAssignableFrom(valIdField.getType())){
						valIdField.setAccessible(true);
						Object idVal = valIdField.get(val);
						if(idVal == null
								|| StringUtils.isBlank(idVal.toString())){
							poField.set(obj, null);
						}
					}
				}
			} catch (Exception e) {
				log.error((valClzz == null ? "" : valClzz+",") + e.getMessage(), e);
			}
		}
	}

	public <T extends PersistentObject> void delete(Class<T> clzz, Serializable id,DeleteCallback<T> dcb) throws ValidatorException {
		if (id == null) {
			return;
		}
		T obj = getBaseDao().get(clzz, id);
		dcb.predelete(obj);
		getBaseDao().delete(obj);
	}
	
	public Class<?> getTrueClass(Object object) {
		Class<?> clazz = object.getClass();
		String className = clazz.getName();
		int index = className.indexOf("$");
		if (index != -1) {
			className = className.substring(0, index);
			try {
				clazz = Class.forName(className);
			}
			catch(ClassNotFoundException ex) {
				ReflectionUtils.handleReflectionException(ex);
			}
		}
		return clazz;
	}
	
	public Criteria createCriteria(Class<?> entityClass, Criterion... criterions) {
		Criteria criteria = getBaseDao().getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}
	
	public Serializable getId(Class<?> entityClass, Object entity)
			throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		return (Serializable) PropertyUtils.getProperty(entity,
				getIdName(entityClass));
	}

	public String getIdName(Class<?> entityClass) {
		ClassMetadata meta = getBaseDao().getSession().getSessionFactory()
				.getClassMetadata(entityClass);
		if(meta == null){
			return null;
		}
		return meta.getIdentifierPropertyName();
	}
	
	public boolean isUnique(Object entity, String propertyNames) {
		Class<?> clazz = getTrueClass(entity);
		Criteria criteria = createCriteria(clazz).setProjection(
				Projections.rowCount());
		String[] nameList = StringUtils.split(propertyNames, ",");
		try {
			boolean isQuery = false;
			for (String name : nameList) {
				Object obj = PropertyUtils.getProperty(entity, name);
				if (obj != null) {
					criteria.add(Restrictions.eq(name, obj));
					isQuery = true;
				} else {
					criteria.add(Restrictions.isNull(name));
				}
			}
			if (!isQuery) {
				return true;
			}
			String idName = getIdName(clazz);
			Serializable id = getId(clazz, entity);
			if (id != null) {
				criteria.add(Restrictions.not(Restrictions.eq(idName, id)));
			}
		} catch (Exception e) {
			ReflectionUtils.handleReflectionException(e);
		}
		return ((Number)criteria.uniqueResult()).intValue() == 0;
	}
	
	@SuppressWarnings("unchecked")
	public <VO> List<VO> find(Class<VO> vo,String hql, Object... param){
		return Mover.getInstance().move(getBaseDao().find(hql, param), vo);
	}
	
	public int update(String hql,Object ... param){
		Query query = getBaseDao().getSession().createQuery(hql);  
		
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				query.setParameter(i, param[i]);
			}
		}
		
		return query.executeUpdate();
	}
	
	private static final String HIERARCHY_BASE = "000";
	
	private <Obj> Field getField(Class<?> objclzz, Class<? extends Annotation> clzz) {
		Field[] fields = objclzz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(clzz)) {
				return field;
			}
		}
		return null;
	}
	
	private <PO> String getValidHierarchyCode(Class<PO> entityClass,
			String parentHierarchyCode) {

		Field field = getField(entityClass, Hierarchy.class);
		String column = field.getName();

		String queryString = "select distinct " + column + " from "
				+ entityClass.getSimpleName() + " where " + column + " like '"
				+ parentHierarchyCode + "___' " + " order by " + column;
		@SuppressWarnings("unchecked")
		Iterator<PO> hierarchyCodes = getBaseDao().find(queryString).iterator();
		String code = null;
		for (int index = 0; index < 999; index++) {
			if (hierarchyCodes.hasNext()) {
				String c = ((String) hierarchyCodes.next());
				c = c.substring(c.length() - 3);

				if (index != Integer.parseInt(c)) {
					code = NumberUtils.format(index, HIERARCHY_BASE);
					break;
				}
			} else {
				code = NumberUtils.format(index, HIERARCHY_BASE);
				break;
			}
		}
		return parentHierarchyCode + code;
	}
	
	public <T extends Hierarchical<T> & PersistentObject>
		void makeHierarchyCode(final T po) {
		
		Class<?> poClass = getTrueClass(po);
		
		String parentHierarchyCode = "";
		Integer parentLevelCode = 0;

		try {
			T parent = po.getParent();
			if (parent != null) {
				getBaseDao().getSession().refresh(parent);
				parentHierarchyCode = parent.getHierarchyCode();
				
				if (StringUtils.isBlank(parentHierarchyCode)) {
					return;
				}
				
				parentLevelCode = parent.getHierarchyLevel();
			}

			Object id = PropertyUtils.getProperty(po,
					getIdName(poClass));
			if (id == null) {
				po.setHierarchyCode(getValidHierarchyCode(poClass, parentHierarchyCode));
				po.setHierarchyLevel(parentLevelCode + 1);
			} else {
				
				String hierarchyCode = po.getHierarchyCode();
				
				Integer levelCode = po.getHierarchyLevel();
				
				if (hierarchyCode != null && !parentHierarchyCode.equals("")
						&& parentHierarchyCode.indexOf(hierarchyCode) == 0) {
					throw new Exception("不能把自己或自已的下级改变为自己的上级");
				}
				if (hierarchyCode == null || levelCode == null || "".equals(hierarchyCode)
						|| levelCode == 0
						|| hierarchyCode.indexOf(parentHierarchyCode) != 0
						|| hierarchyCode.length() - parentHierarchyCode.length() != 3
						|| levelCode != (parentLevelCode + 1)) {
					updateHierarchyCode(
							po,
							parentLevelCode + 1,
							getValidHierarchyCode(poClass,
									parentHierarchyCode));
				}
			}
		} catch (Exception e) {
			throw new AppRuntimeException(e);
		}

	}

	public <T extends Hierarchical<T> & PersistentObject> 
		void updateHierarchyCode(final T po, Integer levelCode,
			String hierarchyCode) throws ValidatorException {
		try {
			po.setHierarchyCode(hierarchyCode);
			po.setHierarchyLevel(levelCode);
			getBaseDao().saveOrUpdate(po);

			Iterator<T> childrenItor = po.getChildren().iterator();
			for (int i = 0; childrenItor.hasNext(); i++) {
				updateHierarchyCode(childrenItor.next(), levelCode + 1, hierarchyCode
						+ NumberUtils.format(i, HIERARCHY_BASE));
			}
		} catch (Exception e) {
			throw new AppRuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends PersistentObject> T findUnique(Class<T> clzz,String hql, Object... params) {
		T object = null;
		try {
			object = (T) createQuery(hql, params).setMaxResults(1)
					.uniqueResult();
		} catch (Exception e) {
			throw new AppRuntimeException(e.getMessage() + ":" + hql,e);
		}
		return object;
	}
}
