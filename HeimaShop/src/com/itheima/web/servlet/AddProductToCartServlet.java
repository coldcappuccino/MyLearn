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
	    //��õ� ���ﳵ��pid
      String pid = request.getParameter("pid");
      //��ø���Ʒ�Ĺ�������
      String buyNum = request.getParameter("buyNum");
      
      //������Ʒ��װ����������
      Product product = service.findProductByPid(pid);
     
      //����С��
      double subtatol = Integer.parseInt(buyNum)*product.getShop_price();
      
      //��װ��һ��CartItem
      CartItem item = new CartItem();
      item.setBuyNum(Integer.parseInt(buyNum));
      item.setProduct(product);
      item.setSubtotal(subtatol);
      
      //��ù��ﳵ �ж��Ƿ���session���Ѿ����ڹ��ﳵ
      HttpSession session = request.getSession();
      Cart cart = (Cart)session.getAttribute("cart");
      if(cart==null){
         cart = new Cart();
      }
      
      if(cart.getCartItems().containsKey(pid)){
          //ȡ��ԭ�е���Ʒ���������������
          CartItem cartitem = cart.getCartItems().get(pid);
          int oldBuyNum = cartitem.getBuyNum();
          cartitem.setBuyNum(oldBuyNum+Integer.parseInt(buyNum));
          double oldSubTatol = cartitem.getSubtotal();
          cartitem.setSubtotal(oldSubTatol+subtatol);
 

      }else{
         //��������ŵ����ﳵ��----key����Ʒpid
         cart.getCartItems().put(product.getPid(),item);
      }
      
      
      //�����ܼ�
      double total = cart.getTotal()+subtatol;
      cart.setTotal(total);
      //�����ٴηŻ�session
      session.setAttribute("cart",cart);
      
      //ֱ����ת�����ﳵҳ��
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








