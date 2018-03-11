package com.itheima.bos.dao;

import com.itheima.bos.dao.base.IBaseDao;
import com.itheima.bos.domain.Role;

public interface IRoleDao extends IBaseDao<Role>{
     
    public void add(Role model,String functionIds);
}
