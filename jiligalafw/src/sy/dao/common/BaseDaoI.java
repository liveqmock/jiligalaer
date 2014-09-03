package sy.dao.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import sy.domain.model.shared.PersistentObject;

public interface BaseDaoI {

	
	public void save(PersistentObject o);
	public void update(PersistentObject o);
	public void saveOrUpdate(PersistentObject o);
	public void merge(PersistentObject o);
	public void delete(PersistentObject o);

	public <T> T load(Class<T> c, Serializable id);
	public <T> T get(Class<T> c, Serializable id);
	public PersistentObject get(String hql, Object... param);
	public PersistentObject get(String hql, List param);

	public Long count(String hql, Object... param);
	public Long count(String hql, List param);
	
	public List find(String hql, Object... param);
	public List find(String hql, List param);
	public List find(String hql, Integer page, Integer rows, Object... param);
	public List find(String hql, Integer page, Integer rows, List param);

	public Long countBySQL(String sql, Object... param);
	public Long countBySQL(String sql, List param);

	public List<Object[]> findBySQL(String sql, Object... param);
	public List<Object[]> findBySQL(String sql, List param);
	public List<Object[]> findBySQL(String sql, Integer page, Integer rows, Object... param);
	public List<Object[]> findBySQL(String sql, Integer page, Integer rows, List param);
	
	/**  返回值 List<Map>：KEY为查询结果集的列名（大小写一致）  */
	public List<Map> findMapBySQL(String sql, Object... param);
	public List<Map> findMapBySQL(String sql, List param);
	public List<Map> findMapBySQL(String sql, Integer page, Integer rows, Object... param);
	public List<Map> findMapBySQL(String sql, Integer page, Integer rows, List param);
	
	public <T> List<T> findBySQL(String sql, Class<T> clazz, Object... param);
	public <T> List<T> findBySQL(String sql, Class<T> clazz, List param);
	public <T> List<T> findBySQL(String sql, Class<T> clazz, Integer page, Integer rows, Object... param);
	public <T> List<T> findBySQL(String sql, Class<T> clazz, Integer page, Integer rows, List param);

	public Integer excute(String hql);
	public List<Integer> batchExcute(List<String> hqlList);
	public List<Integer> batchExcute(List<String> hqlList, List<List<Object>> param);

	public Integer excuteSQL(String sql);
	public List<Integer> batchExcuteSQL(List<String> sqlList);
	public List<Integer> batchExcuteSQL(List<String> sqlList, List<List<Object>> param);
	
	public Session getSession();
}
