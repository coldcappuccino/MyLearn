package com.itheima.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;

/**
 * Servlet implementation class AddProductToCartServlet
 */
@WebServlet("/addProductToCart")
public class AddProductToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ProductService service = new ProductService();
	    //获得到 购物车的pid
      String pid = request.getParameter("pid");
      //获得该商品的购买数量
      String buyNum = request.getParameter("buyNum");
      
      //将该商品封装到购物项中
      Product product = service.findProductByPid(pid);
     
      //计算小计
      double subtatol = Integer.parseInt(buyNum)*product.getShop_price();
      
      //封装成一个CartItem
      CartItem item = new CartItem();
      item.setBuyNum(Integer.parseInt(buyNum));
      item.setProduct(product);
      item.setSubtotal(subtatol);
      
      //获得购物车 判断是否在session中已经存在购物车
      HttpSession session = request.getSession();
      Cart cart = (Cart)session.getAttribute("cart");
      if(cart==null){
         cart = new Cart();
      }
      
      if(cart.getCartItems().containsKey(pid)){
          //取出原有的商品的数量，进行相加
          CartItem cartitem = cart.getCartItems().get(pid);
          int oldBuyNum = cartitem.getBuyNum();
          cartitem.setBuyNum(oldBuyNum+Integer.parseInt(buyNum));
          double oldSubTatol = cartitem.getSubtotal();
          cartitem.setSubtotal(oldSubTatol+subtatol);
 

      }else{
         //将购物项放到购物车中----key是商品pid
         cart.getCartItems().put(product.getPid(),item);
      }
      
      
      //计算总计
      double total = cart.getTotal()+subtatol;
      cart.setTotal(total);
      //将车再次放回session
      session.setAttribute("cart",cart);
      
      //直接跳转到购物车页面
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








