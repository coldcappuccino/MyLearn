package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.domain.Role;
import com.itheima.bos.utils.PageBean;

public interface IRoleService {
     
     public void add(Role model, String functionIds);

    public void pageQuery(PageBean pagebean);

    public List<Role> findAll();
}
