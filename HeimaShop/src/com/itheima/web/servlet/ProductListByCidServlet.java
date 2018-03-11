package com.itheima.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;

/**
 * Servlet implementation class ProductListByCidServlet
 */
@WebServlet("/productListByCid")
public class ProductListByCidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListByCidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String cid = request.getParameter("cid");
		    String currentPage = (String)request.getParameter("currentPage");
		    
		    if(currentPage == null){
		       currentPage = "1";
		    }
		    int currentCount = 12;
		    ProductService service = new ProductService();
		    
		    PageBean pageBean = service.findProductListByCid(cid,Integer.parseInt(currentPage),currentCount);
		    
		    request.setAttribute("pageBean",pageBean);
		    request.setAttribute("cid",cid);
		    
		    //����һ����¼��Ʒ��ʷ��Ϣ�ļ���
		    List<Product> historyProductList = new ArrayList<Product>();
		    //��ÿͻ������ִ��������ʷpid��cookie
		    Cookie[] cookies = request.getCookies();
		    if(cookies!=null){
		       for(Cookie cookie:cookies){
		           if("pids".equals(cookie.getName())){
		              String pids = cookie.getValue();
		              String split[] = pids.split("-");
		              for(String pid:split){
		                  Product pro = service.findProductByPid(pid);
		                  historyProductList.add(pro);
		              }
		           }
		       }  
		    }
		    request.setAttribute("historyProductList",historyProductList);
		    
		    
		    request.getRequestDispatcher("/product_list.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
