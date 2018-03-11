package com.itheima.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;

/**
 * Servlet implementation class ProductInfoServlet
 */
@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     //��õ�ǰҳ����Ʒ��𣬻���ʱʹ��
	       String cid = (String)request.getParameter("cid");
	       String currentPage = (String)request.getParameter("currentPage");
	       //�����Ʒid
		     String pid = (String)request.getParameter("pid");
		     
		     ProductService service = new ProductService();
		     Product product = service.findProductByPid(pid);
		     
		     //��ÿͻ���Я��cookie
		     String pids = pid;
		     Cookie[] cookies = request.getCookies();
		     if(cookies!=null){
		         for(Cookie cookie:cookies){
		             if("pids".equals(cookie.getName())){
		                 pids = cookie.getValue();         //1-2-3 ���η��ʵ���Ʒ
		                 String[] split = pids.split("-");
		                 List<String> asList = Arrays.asList(split);
		                 LinkedList<String> list = new LinkedList<String>(asList);
		                 
		                 //�жϼ������Ƿ���ڵ�ǰpid
		                 if(list.contains(pid)){
		                    //������ǰ��Ʒ��pid
		                    list.remove(pid);
		                    list.addFirst(pid);
		                 }else{
		                    //������ǰ�鿴��Ʒ��pid,ֱ�ӽ���pid�ŵ�ͷ��
		                    list.addFirst(pid);
		                 }
		                 
		                 //��[3,1,2]ת����3-1-2�ַ���
		                 StringBuffer sb = new StringBuffer();
		                 for(int i=0;i<list.size()&&i<7;i++){
		                     sb.append(list.get(i));
		                     sb.append("-");
		                 }
		                 
		                 //ȥ��3-1-2���-
		                 pids = sb.substring(0,sb.length()-1);
		             }
		         }
		     }
		     Cookie cookie_new = new Cookie("pids",pids);
         response.addCookie(cookie_new);
       
		     request.setAttribute("product",product);
		     request.setAttribute("cid",cid);
		     request.setAttribute("currentPage",currentPage);
		     request.getRequestDispatcher("/product_info.jsp").forward(request,response);
		     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
