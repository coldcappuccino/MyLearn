package com.itheima.bos.dao.base.impl;
import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.itheima.bos.dao.base.IBaseDao;
import com.itheima.bos.utils.PageBean;
/**
 *
 * @author zhaoqx
 * @param <T>
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

	private Class<T> entityClass;
	
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	
	public BaseDaoImpl() {
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}
	
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}
	
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}
	
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	public T findById(Serializable id) {
		return  this.getHibernateTemplate().get(entityClass,id);
	}

	public List<T> findAll() {
		   String hql = "FROM " + entityClass.getSimpleName();
		   return (List<T>) this.getHibernateTemplate().find(hql);
	}

  //
  public void executeUpdate(String queryName, Object... objects) {
    Session session = this.getSessionFactory().getCurrentSession();
    Query query = session.getNamedQuery(queryName);
    int i = 0;
    for (Object object : objects) {
      query.setParameter(i++, object);
    }
    query.executeUpdate();
  }
  
  
  @Override
  public void PageQuery(PageBean pageBean) {
        // TODO Auto-generated method stub
        int currentPage = pageBean.getCurrentPage();
        int PageSize = pageBean.getPageSize();
        DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
                
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> countList = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        Long count = countList.get(0);
        pageBean.setTotal(count.intValue());

        detachedCriteria.setProjection(null);
        //
        detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);
        int firstResult = (currentPage - 1) * PageSize;
        int maxResults = PageSize;
        List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
        pageBean.setRows(rows);
        
  }


  @Override
  public void saveOrUpdate(T entity) {
    // TODO Auto-generated method stub
    this.getHibernateTemplate().saveOrUpdate(entity);
  }

  public List<T> findByCriteria(DetachedCriteria a){
     return (List<T>) this.getHibernateTemplate().findByCriteria(a);
  }
}












