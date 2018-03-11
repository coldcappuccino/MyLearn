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
    	  
        //�ж��û��Ƿ��Ѿ���¼ δ��¼������벻ִ��
        User user = (User) session.getAttribute("user");
        
        ProductService service = new ProductService();
        //��ѯ���û������ж���
        List<Order> orderList = service.findAllOrders(user.getUid());
        
        System.out.println(orderList.size());
        
        //ѭ�����ж�����Ϊÿ�������ṩ��䶩��������Ϣ
        if(orderList!=null){
             for(Order order:orderList){
                 //���ÿһ��������oid
                 String oid = order.getOid();
                 //��ѯ�ö��������ж�����
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
        
        //�����Ѿ���װ���
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











