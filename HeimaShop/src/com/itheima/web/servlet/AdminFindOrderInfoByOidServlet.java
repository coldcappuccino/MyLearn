package com.itheima.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.itheima.service.AdminService;

/**
 * Servlet implementation class AdminFindOrderInfoByOidServlet
 */
@WebServlet("/findOrderInfoByOid")
public class AdminFindOrderInfoByOidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFindOrderInfoByOidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    //»ñµÃoid
	      String oid = request.getParameter("oid");
	      AdminService service = new AdminService();
	      List<Map<String,Object>> mapList = service.findOrderInfoByOid(oid);
	      
	      String data = JSON.toJSONString(mapList);
	      response.setContentType("text/html;charset=UTF-8");
	      
	      response.getWriter().write(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
