package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.User;
import com.itheima.service.UserService;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
          String password = request.getParameter("password");
          String autoLogin = request.getParameter("autoLogin");
          HttpSession session = request.getSession();
          
          UserService service = new UserService();
          User user = null;
          
          try {
            user = service.login(username,password);
          } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          
          if(user!=null){
            if("true".equals(autoLogin)){
              //Ҫ�Զ���¼
              //�����洢�û�����cookie
              Cookie cookie_username = new Cookie("cookie_username",user.getUsername());
              cookie_username.setMaxAge(10*60);
              //�����洢�����cookie
              Cookie cookie_password = new Cookie("cookie_password",user.getPassword());
              cookie_password.setMaxAge(10*60);

              response.addCookie(cookie_username);
              response.addCookie(cookie_password);
            }
            
            //��user����浽session��
            session.setAttribute("user", user);

            //�ض�����ҳ
            response.sendRedirect(request.getContextPath()+"/index");
          }else{
            request.setAttribute("loginError", "�û������������");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
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







