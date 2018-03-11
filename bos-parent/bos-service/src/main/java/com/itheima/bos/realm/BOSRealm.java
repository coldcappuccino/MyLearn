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
  
  //��Ȩ����
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
    // TODO Auto-generated method stub
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
     
    User user = (User)SecurityUtils.getSubject().getPrincipal();
    //���ݵ�ǰ�û���ѯ���ݿ⣬��ȡʵ�ʶ�Ӧ��Ȩ��
    
    List<Function> list = null;
    if(user.getUsername().equals("admin")){     
       //��������Ա�����û���ֱ�Ӳ�ѯ����Ȩ��
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

  //��֤����
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    // TODO Auto-generated method stub
    System.out.println("��֤��¼sss");
    //�����û�����ѯ���ݿ��е�����
    //��ܸ���ȶ����ݿ��е������ҳ������������Ƿ�һ��
    UsernamePasswordToken passwordToken = (UsernamePasswordToken)token;
    //���ҳ��������û���
    String username = passwordToken.getUsername();
    System.out.println("aaaa"+username);
    //�����û�����ѯ���ݿ��е�����
    User user = userDao.findUserByUsername(username);
    System.out.println("bbbbb"+user.getPassword());
   
    if(user == null){
        //ҳ��������û���������
        return null;
    }
    
    //�û������ڣ��ȶ������Ƿ�һ��
    //����֤��Ϣ
    AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
    return info;
    
  }

}





