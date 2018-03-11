package com.itheima.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.User;
import com.itheima.service.ProductService;
import com.itheima.utils.CommonsUtils;

/**
 * Servlet implementation class SubmitServlet
 */
@WebServlet("/submitorder")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	  HttpSession session = request.getSession();
  
      //判断用户是否已经登录 未登录下面代码不执行
      User user = (User) session.getAttribute("user");
       
      //目的：封装好一个Order对象 传递给service层
      Order order = new Order();

      //1、private String oid;//该订单的订单号
      String oid = CommonsUtils.getUUID();
      order.setOid(oid);

      //2、private Date ordertime;//下单时间
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
      String nowtime = df.format(new Date());// new Date()为获取当前系统时间
      Date  Systime= null;
      try {
        Systime = df.parse(nowtime);
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }//将字符串转换成date类型
      order.setOrdertime(Systime);
      
      //3、private double total;//该订单的总金额
      //获得session中的购物车
      Cart cart = (Cart) session.getAttribute("cart");
      double total = cart.getTotal();
      order.setTotal(total);
      
      //4、private int state;//订单支付状态 1代表已付款 0代表未付款
      order.setState(0);

      //5、private String address;//收货地址
      order.setAddress(null);

      //6、private String name;//收货人
      order.setName(null);

      //7、private String telephone;//收货人电话
      order.setTelephone(null);

      //8、private User user;//该订单属于哪个用户
      order.setUser(user);
      
        //9、该订单中有多少订单项List<OrderItem> orderItems = new ArrayList<OrderItem>();
        //获得购物车中的购物项的集合map
        Map<String, CartItem> cartItems = cart.getCartItems();
        for(Map.Entry<String, CartItem> entry : cartItems.entrySet()){
          //取出每一个购物项
          CartItem cartItem = entry.getValue();
          //创建新的订单项
          OrderItem orderItem = new OrderItem();
          //1)private String itemid;//订单项的id
          orderItem.setItemid(CommonsUtils.getUUID());
          //2)private int count;//订单项内商品的购买数量
          orderItem.setCount(cartItem.getBuyNum());
          //3)private double subtotal;//订单项小计
          orderItem.setSubtotal(cartItem.getSubtotal());
          //4)private Product product;//订单项内部的商品
          orderItem.setProduct(cartItem.getProduct());
          //5)private Order order;//该订单项属于哪个订单
          orderItem.setOrder(order);
  
          //将该订单项添加到订单的订单项集合中
          order.getOrderItems().add(orderItem);
        }
        
         //order对象封装完毕
        //传递数据到service层
        ProductService service = new ProductService();
        service.submitOrder(order);
        
        session.setAttribute("order", order);

        //页面跳转
        response.sendRedirect(request.getContextPath()+"/order_info.jsp");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}








