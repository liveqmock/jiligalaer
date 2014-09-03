package sy.dao.common;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sy.domain.model.shared.PersistentObject;



@Repository("baseDao")
public class BaseDaoImpl implements BaseDaoI {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(PersistentObject o) {
		this.getCurrentSession().save(o);
	}

	@Override
	public void update(PersistentObject o) {
		this.getCurrentSession().update(o);
	}

	@Override
	public void saveOrUpdate(PersistentObject o) {
		this.getCurrentSession().saveOrUpdate(o);
	}

	@Override
	public void merge(PersistentObject o) {
		this.getCurrentSession().merge(o);
	}

	@Override
	public void delete(PersistentObject o) {
		this.getCurrentSession().delete(o);
	}
	
	@Override
	public <T> T load(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().load(c, id);
	}

	@Override
	public <T> T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}
	
	@Override
	public PersistentObject get(String hql, Object... param) {
		List<PersistentObject> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public PersistentObject get(String hql, List param) {
		List<PersistentObject> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public Long count(String hql, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public Long count(String hql, List param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public List find(String hql, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}
	
	@Override
	public List find(String hql, List param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	@Override
	public List find(String hql, Integer page, Integer rows, Object... param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List find(String hql, Integer page, Integer rows, List param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	

	@Override
	public Long countBySQL(String sql, Object... param) {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		
		return ((BigInteger) q.uniqueResult()).longValue();
	}

	@Override
	public Long countBySQL(String sql, List param) {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return ((BigInteger) q.uniqueResult()).longValue();
	}

	@Override
	public List<Object[]> findBySQL(String sql, Object... param) {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}
	
	@Override
	public List<Object[]> findBySQL(String sql, List param) {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	@Override
	public List<Object[]> findBySQL(String sql, Integer page, Integer rows, Object... param) {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<Object[]> findBySQL(String sql, Integer page, Integer rows, List param) {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<Map> findMapBySQL(String sql, Object... param) {
		Query q = this.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}
	
	@Override
	public List<Map> findMapBySQL(String sql, List param) {
		Query q = this.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	@Override
	public List<Map> findMapBySQL(String sql, Integer page, Integer rows, Object... param) {
		Query q = this.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<Map> findMapBySQL(String sql, Integer page, Integer rows, List param) {
		Query q = this.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public <T> List<T> findBySQL(String sql, Class<T> clazz, Object... param) {
		Query q = this.getCurrentSession().createSQLQuery(sql).addEntity(clazz);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}
	
	@Override
	public <T> List<T> findBySQL(String sql, Class<T> clazz, List param) {
		Query q = this.getCurrentSession().createSQLQuery(sql).addEntity(clazz);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	@Override
	public <T> List<T> findBySQL(String sql, Class<T> clazz, Integer page, Integer rows, Object... param) {
		Query q = this.getCurrentSession().createSQLQuery(sql).addEntity(clazz);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public <T> List<T> findBySQL(String sql, Class<T> clazz, Integer page, Integer rows, List param) {
		Query q = this.getCurrentSession().createSQLQuery(sql).addEntity(clazz);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	


	@Override
	public Integer excute(String hql) {
		return this.getCurrentSession().createQuery(hql).executeUpdate();
	}
	
	@Override
	public List<Integer> batchExcute(List<String> hqlList) {

		Session session = this.getCurrentSession();
		
		List<Integer> returnList = new ArrayList<Integer>();
		String hql;
		Query q;
		
		if (hqlList != null && hqlList.size() > 0) {
			for (int i = 0; i < hqlList.size(); i++) {
				
				hql = hqlList.get(i);
				q = session.createQuery(hql);
				returnList.add(q.executeUpdate());
			}
		}
		
		return returnList;
	}
	
	@Override
	public List<Integer> batchExcute(List<String> hqlList, List<List<Object>> paramList) {

		Session session = this.getCurrentSession();
		
		List<Integer> returnList = new ArrayList<Integer>();
		String hql;
		Query q;
		List<Object> param;
		
		if (hqlList != null && hqlList.size() > 0 && paramList != null && paramList.size() > 0) {
			for (int i = 0; i < hqlList.size(); i++) {
				
				hql = hqlList.get(i);
				param = paramList.get(i);
				
				q = session.createQuery(hql);
				
				if (param != null && param.size() > 0) {
					for (int j = 0; j < param.size(); j++) {
						q.setParameter(j, param.get(j));
					}
				}
				returnList.add(q.executeUpdate());
			}
		}
		
		return returnList;
	}

	@Override
	public Integer excuteSQL(String sql) {
		return this.getCurrentSession().createSQLQuery(sql).executeUpdate();
	}
	
	@Override
	public List<Integer> batchExcuteSQL(List<String> sqlList) {

		Session session = this.getCurrentSession();
		
		List<Integer> returnList = new ArrayList<Integer>();
		String sql;
		Query q;
		
		if (sqlList != null && sqlList.size() > 0) {
			for (int i = 0; i < sqlList.size(); i++) {
				
				sql = sqlList.get(i);
				q = session.createSQLQuery(sql);
				returnList.add(q.executeUpdate());
			}
		}
		
		return returnList;
	}
	
	@Override
	public List<Integer> batchExcuteSQL(List<String> sqlList, List<List<Object>> paramList) {

		Session session = this.getCurrentSession();
		
		List<Integer> returnList = new ArrayList<Integer>();
		String sql;
		Query q;
		List<Object> param;
		
		if (sqlList != null && sqlList.size() > 0 && paramList != null && paramList.size() > 0) {
			for (int i = 0; i < sqlList.size(); i++) {
				
				sql = sqlList.get(i);
				param = paramList.get(i);
				
				q = session.createSQLQuery(sql);
				
				if (param != null && param.size() > 0) {
					for (int j = 0; j < param.size(); j++) {
						q.setParameter(j, param.get(j));
					}
				}
				returnList.add(q.executeUpdate());
			}
		}
		
		return returnList;
	}

	@Override
	public Session getSession() {
		return this.getCurrentSession();
	}
}
