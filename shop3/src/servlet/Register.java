package servlet;
import com.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           String username = req.getParameter("username");
           String password = req.getParameter("password");
           String email = req.getParameter("email");
           
           User user = new User();
           user.setUser(username);
           user.setPsw(password);
           user.setEmail(email);
           
           int n = 0;
           User_do user_do = new User_do();
           n = user_do.addUser(user);
           resp.sendRedirect("reg_login/regCheck.jsp?num="+n);
    }
}







