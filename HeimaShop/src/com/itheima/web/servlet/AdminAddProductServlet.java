package com.itheima.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.service.AdminService;
import com.itheima.utils.CommonsUtils;

/**
 * Servlet implementation class AdminAddProductServlet
 */
@WebServlet("/saveProduct")
public class AdminAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //收集表单的数据 封装成product实体
	    Product product = new Product();
	    Map<String,Object> map = new HashMap<String,Object>();
	    //创建磁盘文件项工厂
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    //创建文件上传的核心对象
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    //解析request获得文件对象集合
	    List<FileItem> parseRequest = null;
	    try {
         parseRequest = upload.parseRequest(request);
      } catch (FileUploadException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
	    
	    for(FileItem item:parseRequest){
	          //判断是否是普通表单相
	       if(item.isFormField()){
	          //获得表单数据，封装到是实体中
	          String fieldName = item.getFieldName();
	          String filedValue = item.getString("UTF-8");
	          map.put(fieldName,filedValue);
	       }else{
	         //是文件上传项 
	         String FileName = item.getName();
	         String path = this.getServletContext().getRealPath("upload");
	         InputStream in = item.getInputStream();
	         OutputStream out = new FileOutputStream(path+"/"+FileName);
	         IOUtils.copy(in,out);
	         in.close();
	         out.close();
	         item.delete();
	         
	         map.put("pimage","upload/"+FileName);
	       }
	    }
	    
	    try {
        BeanUtils.populate(product,map);
      } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
	    
	    //product对象是否封装完全
	    product.setPid(CommonsUtils.getUUID());
	    
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
      String nowtime = df.format(new Date());// new Date()为获取当前系统时间
      Date  Systime= null;
      try {
        Systime = df.parse(nowtime);
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }//将字符串转换成date类型
      
      product.setPdate(Systime);
      product.setPflag(0);
      Category category = new Category();
      category.setCid((String)map.get("cid"));
      product.setCategory(category);
      
      //将product传递给service层
      AdminService service = new AdminService();
      service.saveProduct(product);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}










