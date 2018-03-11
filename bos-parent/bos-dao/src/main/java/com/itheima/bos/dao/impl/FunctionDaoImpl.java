package com.itheima.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima.bos.dao.IFunctionDao;
import com.itheima.bos.dao.base.impl.BaseDaoImpl;
import com.itheima.bos.domain.Function;

@Repository
public class FunctionDaoImpl  extends BaseDaoImpl<Function> implements IFunctionDao{
   /*
   public List<Function> findAll(){
        String hql = "FROM Function  f WHERE f.parentFunction IS NULL";
        List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
        return list;
   }
   */
  public List<Function> findAll(){
    String hql = "FROM Function f WHERE f.parentFunction IS NULL";
    List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
    return list;
  }

  @Override
  //根据用户的id查询相关的权限
  public List<Function> findFunctionListByUserId(String id) {
    // TODO Auto-generated method stub
    String hql = "SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles r LEFT OUTER JOIN r.users u WHERE u.id=?";
    List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql,id);
    return list;
  }

  @Override
  public List<Function> findAllMenu() {
      // TODO Auto-generated method stub
      String hql = "FROM Function f WHERE f.generatemenu=? ORDER BY f.zindex ASC";
      List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql,"1");
      return list;
  }

  @Override
  public List<Function> findMenuByUserId(String id) {
    String hql = "SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles r LEFT OUTER JOIN r.users u WHERE u.id=? AND f.generatemenu=? ORDER BY f.zindex ASC";
    List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql,id,"1");
    return list;
  }
  
}








