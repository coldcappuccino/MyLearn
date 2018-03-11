package com.itheima.web.servlet;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.utils.JedisPoolUtils;

import redis.clients.jedis.Jedis;

/**
 * Servlet implementation class CategoryListServlet
 */
@WebServlet("/categoryList")
public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      CategoryService cag_service = new CategoryService();
	      
	      //先从缓存中查询，没有再查数据库
	      Jedis jedis = JedisPoolUtils.getJedis();
	      String categoryJedisJson = jedis.get("categoryJedisJson");

	      if(categoryJedisJson == null){    
	         List<Category> categoryList = cag_service.findAllCategory();
	         String data = JSON.toJSONString(categoryList);
	         jedis.set("categoryJedisJson",data);
	         categoryJedisJson = data;
	      }
	      
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(categoryJedisJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
