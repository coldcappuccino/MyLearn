package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {
    
    public boolean regist(User user){
       UserDao userdao = new UserDao();
       int row = 0;
       try {
         row = userdao.regist(user);
       } catch (SQLException e) {
        // TODO Auto-generated catch block
         e.printStackTrace();
       }
       
        return row>0?true:false;
    }

    public void active(String activeCode) {
      // TODO Auto-generated method stub
      UserDao userdao = new UserDao();
      userdao.active(activeCode);
    }

    //校验用户名是否存在
    public boolean checkUserName(String username) {
      // TODO Auto-generated method stub
       UserDao dao = new UserDao();
       Long isExist = 0L;
       try {
         isExist= dao.checkUsername(username);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return isExist>0?false:true;
    }

    public User login(String username, String password) throws SQLException {
      UserDao dao = new UserDao();
      return dao.login(username,password);
    }
}
