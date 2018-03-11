package com.itheima.bos.realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.itheima.bos.dao.IFunctionDao;
import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.domain.Function;
import com.itheima.bos.domain.User;

public class BOSRealm extends AuthorizingRealm{

  @Autowired
  private IUserDao userDao;
  
  @Autowired
  private IFunctionDao functiondao;
  
  //授权方法
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
    // TODO Auto-generated method stub
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
     
    User user = (User)SecurityUtils.getSubject().getPrincipal();
    //根据当前用户查询数据库，获取实际对应的权限
    
    List<Function> list = null;
    if(user.getUsername().equals("admin")){     
       //超级管理员内置用户，直接查询所有权限
       DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
       list = functiondao.findByCriteria(detachedCriteria);
    }else{
       list = functiondao.findFunctionListByUserId(user.getId());
    }
    
    for(Function function:list){
       info.addStringPermission(function.getCode());
    }
    return info;
  }

  //认证方法
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    // TODO Auto-generated method stub
    System.out.println("认证登录sss");
    //根据用户名查询数据库中的密码
    //框架负责比对数据库中的密码和页面输入的密码是否一致
    UsernamePasswordToken passwordToken = (UsernamePasswordToken)token;
    //获得页面输入的用户名
    String username = passwordToken.getUsername();
    System.out.println("aaaa"+username);
    //根据用户名查询数据库中的密码
    User user = userDao.findUserByUsername(username);
    System.out.println("bbbbb"+user.getPassword());
   
    if(user == null){
        //页面输入的用户名不存在
        return null;
    }
    
    //用户名存在，比对密码是否一致
    //简单认证信息
    AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
    return info;
    
  }

}





