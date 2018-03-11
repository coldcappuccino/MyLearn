package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.Product;
import com.itheima.domain.User;
import com.itheima.service.ProductService;

/**
 * Servlet implementation class MyOrderServlet
 */
@WebServlet("/myOrders")
public class MyOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyOrderServlet() {
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
        
        ProductService service = new ProductService();
        //查询该用户的所有订单
        List<Order> orderList = service.findAllOrders(user.getUid());
        
        System.out.println(orderList.size());
        
        //循环所有订单，为每个订单提供填充订单集合信息
        if(orderList!=null){
             for(Order order:orderList){
                 //获得每一个订单的oid
                 String oid = order.getOid();
                 //查询该订单的所有订单项
                 List<Map<String,Object>> mapList = service.findOrderItems(oid);
                 for(Map<String,Object> map: mapList){
                    OrderItem item = new OrderItem();
                    try {
                      BeanUtils.populate(item,map);
                      Product product = new Product();
                      BeanUtils.populate(product,map);
                      item.setProduct(product);
                    } catch (IllegalAccessException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
                    } catch (InvocationTargetException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
                    }      
                    order.getOrderItems().add(item);
                 }
             }
        }
        
        //数据已经封装完成
        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("/order_list.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}











