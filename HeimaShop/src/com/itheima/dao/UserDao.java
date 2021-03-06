package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;

public class UserDao {

  public int regist(User user) throws SQLException {
    // TODO Auto-generated method stub
    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
    
    
      int update = runner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail()
                    ,user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode());
    
    
      return update;
  }

  public void active(String activeCode) {
    // TODO Auto-generated method stub
    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "update user set state = ? where code = ?";
    
    try {
      runner.update(sql,1,activeCode);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public Long checkUsername(String username) throws SQLException {
    // TODO Auto-generated method stub
    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select count(*) from user where username =?";
    Long query = (Long)runner.query(sql,new ScalarHandler(),username);
    return query;
  }

  public User login(String username, String password) throws SQLException {
    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select * from user where username=? and password=?";
    return runner.query(sql, new BeanHandler<User>(User.class), username,password);
  }
  
}




