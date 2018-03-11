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
  
      //�ж��û��Ƿ��Ѿ���¼ δ��¼������벻ִ��
      User user = (User) session.getAttribute("user");
       
      //Ŀ�ģ���װ��һ��Order���� ���ݸ�service��
      Order order = new Order();

      //1��private String oid;//�ö����Ķ�����
      String oid = CommonsUtils.getUUID();
      order.setOid(oid);

      //2��private Date ordertime;//�µ�ʱ��
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
      String nowtime = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
      Date  Systime= null;
      try {
        Systime = df.parse(nowtime);
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }//���ַ���ת����date����
      order.setOrdertime(Systime);
      
      //3��private double total;//�ö������ܽ��
      //���session�еĹ��ﳵ
      Cart cart = (Cart) session.getAttribute("cart");
      double total = cart.getTotal();
      order.setTotal(total);
      
      //4��private int state;//����֧��״̬ 1�����Ѹ��� 0����δ����
      order.setState(0);

      //5��private String address;//�ջ���ַ
      order.setAddress(null);

      //6��private String name;//�ջ���
      order.setName(null);

      //7��private String telephone;//�ջ��˵绰
      order.setTelephone(null);

      //8��private User user;//�ö��������ĸ��û�
      order.setUser(user);
      
        //9���ö������ж��ٶ�����List<OrderItem> orderItems = new ArrayList<OrderItem>();
        //��ù��ﳵ�еĹ�����ļ���map
        Map<String, CartItem> cartItems = cart.getCartItems();
        for(Map.Entry<String, CartItem> entry : cartItems.entrySet()){
          //ȡ��ÿһ��������
          CartItem cartItem = entry.getValue();
          //�����µĶ�����
          OrderItem orderItem = new OrderItem();
          //1)private String itemid;//�������id
          orderItem.setItemid(CommonsUtils.getUUID());
          //2)private int count;//����������Ʒ�Ĺ�������
          orderItem.setCount(cartItem.getBuyNum());
          //3)private double subtotal;//������С��
          orderItem.setSubtotal(cartItem.getSubtotal());
          //4)private Product product;//�������ڲ�����Ʒ
          orderItem.setProduct(cartItem.getProduct());
          //5)private Order order;//�ö����������ĸ�����
          orderItem.setOrder(order);
  
          //���ö�������ӵ������Ķ��������
          order.getOrderItems().add(orderItem);
        }
        
         //order�����װ���
        //�������ݵ�service��
        ProductService service = new ProductService();
        service.submitOrder(order);
        
        session.setAttribute("order", order);

        //ҳ����ת
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








