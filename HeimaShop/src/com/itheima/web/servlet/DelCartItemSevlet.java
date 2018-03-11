package com.itheima.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;

/**
 * Servlet implementation class DelCartItemSevlet
 */
@WebServlet("/delCartItem")
public class DelCartItemSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCartItemSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String pid = request.getParameter("pid");
		   HttpSession session = request.getSession();
		   Cart cart = (Cart)session.getAttribute("cart");
		   if(cart!=null){
		      Map<String,CartItem> cartItems = cart.getCartItems();
		      double total = cart.getTotal();
		      CartItem cartitem = cartItems.get(pid);
		      cart.setTotal(total-cartitem.getSubtotal());
		      cartItems.remove(pid);
		      
		   }
		   
		   session.setAttribute("cart",cart);
		   response.sendRedirect(request.getContextPath()+"/cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




