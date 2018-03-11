package servlet;

import java.io.IOException;
import com.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String user = req.getParameter("name");
	    String password = req.getParameter("password");
	    User_do user_do = new User_do();
	    
		User u = new User();
		u.setUser(user);
		u.setPsw(password);
		
		boolean flag = user_do.checkUser(u);
		resp.sendRedirect("reg_login/loginCheck.jsp?f="+flag+"&name="+user);
	        
}
   
}
