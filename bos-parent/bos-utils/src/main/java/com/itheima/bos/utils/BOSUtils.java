package com.itheima.bos.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.bos.domain.User;

public class BOSUtils {
    //��ȡsession����
    public static HttpSession getSession(){
       return  ServletActionContext.getRequest().getSession();
    }
    
    //��ȡ��¼��user����
    public static User getLoginUser(){
        return (User)ServletActionContext.getRequest().getSession().getAttribute("loginUser");
    } 
}
