package com.itheima.bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.itheima.bos.dao.IRoleDao;
import com.itheima.bos.dao.base.impl.BaseDaoImpl;
import com.itheima.bos.domain.Role;
import com.itheima.bos.utils.PageBean;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements IRoleDao {

  @Override
  public void add(Role model, String functionIds) {
    // TODO Auto-generated method stub
    
  }  

}
