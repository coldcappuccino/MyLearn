package com.itheima.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IRoleDao;
import com.itheima.bos.domain.Function;
import com.itheima.bos.domain.Role;
import com.itheima.bos.service.IRoleService;
import com.itheima.bos.utils.PageBean;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{

  @Autowired
  private IRoleDao dao;
  
  @Override
  public void add(Role model,String functionIds) {
     // TODO Auto-generated method stub
     dao.save(model);
     if(StringUtils.isNotBlank(functionIds)){
         String[]split = functionIds.split(",");
         for(String temp:split){
             //角色关联权限
             Function function = new Function(temp);
             model.getFunctions().add(function);
         }
     }
     
  }

  @Override
  public void pageQuery(PageBean pagebean) {
    // TODO Auto-generated method stub
    dao.PageQuery(pagebean);
  }

  @Override
  public List<Role> findAll() {
   
    return dao.findAll();
  }

}
