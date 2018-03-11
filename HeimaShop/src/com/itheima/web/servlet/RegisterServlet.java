package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.CommonsUtils;
import com.itheima.utils.MailUtils;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.util.Date;
import java.util.Map;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    // TODO Auto-generated method stub
	      request.setCharacterEncoding("utf-8");
	      //获得表单数据
	      Map<String,String[]> parameterMap =  request.getParameterMap();
	      User user = new User();
	      
	    //自己指定一个类型转换器（将String转成Date）
	     try{
	      ConvertUtils.register(new Converter() {
    	        @Override
    	        public Object convert(Class clazz, Object value) {
    	          //将string转成date
    	          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	          Date parse = null;
    	            try {
                    parse = format.parse(value.toString());
                  } catch (java.text.ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                  }
    	          return parse;
    	        }
    	      }, Date.class);
    	      //映射封装
    	      BeanUtils.populate(user,parameterMap);
	     }catch(IllegalAccessException | InvocationTargetException e){
	       
	     }
	     
	      user.setUid(CommonsUtils.getUUID());
	      user.setTelephone(null);
	      user.setState(0);
	      String activeCode = CommonsUtils.getUUID();
	      user.setCode(activeCode);
	      
	      UserService service = new UserService();
	      boolean isRegisterSuccess =  service.regist(user);
	      
	      if(isRegisterSuccess){
	         //发送邮件
	        String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活<a href='http://localhost:8080/HeimaShop/active?activeCode="+activeCode+"'>http://localhost:8080/HeimaShop/active</a>";
	       
	        try {
            MailUtils.sendMail(user.getEmail(),emailMsg);
          } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          
          }
	         response.sendRedirect(request.getContextPath()+"/registerSuccess.jsp");
	      }else{
	        response.sendRedirect(request.getContextPath()+"/registerFail.jsp");
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}





