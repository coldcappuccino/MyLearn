package edu.neusoft.springmvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.neusoft.springmvc.dao.UserDao;
import edu.neusoft.springmvc.model.User;

@Service
public class UserService {
    @Resource
    private UserDao userDao;
    
    public User userlogin(String username){
        return userDao.userlogin(username);
    }
    
    public int userRegister(User user){
        return userDao.userRegister(user);
    }
    
    public User SelectAllResource(int uid){
       return userDao.SelectAllResource(uid);
    }
}
