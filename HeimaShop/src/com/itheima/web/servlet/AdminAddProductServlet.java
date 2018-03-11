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
		  //�ռ��������� ��װ��productʵ��
	    Product product = new Product();
	    Map<String,Object> map = new HashMap<String,Object>();
	    //���������ļ����
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    //�����ļ��ϴ��ĺ��Ķ���
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    //����request����ļ����󼯺�
	    List<FileItem> parseRequest = null;
	    try {
         parseRequest = upload.parseRequest(request);
      } catch (FileUploadException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
	    
	    for(FileItem item:parseRequest){
	          //�ж��Ƿ�����ͨ����
	       if(item.isFormField()){
	          //��ñ����ݣ���װ����ʵ����
	          String fieldName = item.getFieldName();
	          String filedValue = item.getString("UTF-8");
	          map.put(fieldName,filedValue);
	       }else{
	         //���ļ��ϴ��� 
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
	    
	    //product�����Ƿ��װ��ȫ
	    product.setPid(CommonsUtils.getUUID());
	    
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
      String nowtime = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
      Date  Systime= null;
      try {
        Systime = df.parse(nowtime);
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }//���ַ���ת����date����
      
      product.setPdate(Systime);
      product.setPflag(0);
      Category category = new Category();
      category.setCid((String)map.get("cid"));
      product.setCategory(category);
      
      //��product���ݸ�service��
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










