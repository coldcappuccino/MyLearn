package com.itheima.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.domain.Role;
import com.itheima.bos.domain.User;
import com.itheima.bos.service.IUserService;
import com.itheima.bos.utils.MD5Utils;
import com.itheima.bos.utils.PageBean;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserDao userDao;
  //
  public User login(User user) {
      
     return userDao.findUserByUsernameAndPassword(user.getUsername(),MD5Utils.md5(user.getPassword()));
  }
  
  
  //
  public void editPassword(String id, String password) {
       // TODO Auto-generated method stub
       password = MD5Utils.md5(password);
       userDao.executeUpdate("user.editpassword",password,id);
  }


  @Override
  public void save(User model, String[] roleIds) {
      // TODO Auto-generated method stub
      userDao.save(model);
      if(roleIds != null && roleIds.length>0){
           for(String id:roleIds){
               Role role = new Role();
               role.setId(id);
               model.getRoles().add(role);
           }
      }
  }


  @Override
  public void pageQuery(PageBean pagebean) {
    // TODO Auto-generated method stub
    userDao.PageQuery(pagebean);
  }

}







