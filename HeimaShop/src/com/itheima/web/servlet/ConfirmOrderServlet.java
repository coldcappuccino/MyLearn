package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Order;
import com.itheima.service.ProductService;
import com.itheima.utils.PaymentUtil;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/confirmOrder")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    System.out.println("aaaaa");
		    //1�������ջ�����Ϣ
		    Map<String, String[]> properties = request.getParameterMap();
		    Order order = new Order();
		    
		    try {
          BeanUtils.populate(order, properties);
        } catch (IllegalAccessException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (InvocationTargetException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
		  

		    ProductService service = new ProductService();  
		    service.updateOrderAdrr(order);
		    
		    
		  //2������֧��
		    /*if(pd_FrpId.equals("ABC-NET-B2C")){
		      //����ũ�еĽӿ�
		    }else if(pd_FrpId.equals("ICBC-NET-B2C")){
		      //���빤�еĽӿ�
		    }*/
		    //.......

		    //ֻ����һ���ӿڣ�����ӿ��Ѿ��������е����нӿ���  ������ӿ��ǵ�����֧��ƽ̨�ṩ��
		    //��������ױ�֧��
		    // ��� ֧�������������
		    String orderid = request.getParameter("oid");
		    //String money = order.getTotal()+"";//֧�����
		    String money = "0.01";//֧�����
		    // ����
		    String pd_FrpId = request.getParameter("pd_FrpId");

		    // ����֧����˾��Ҫ��Щ����
		    String p0_Cmd = "Buy";
		    String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
		    String p2_Order = orderid;
		    String p3_Amt = money;
		    String p4_Cur = "CNY";
		    String p5_Pid = "";
		    String p6_Pcat = "";
		    String p7_Pdesc = "";
		    // ֧���ɹ��ص���ַ ---- ������֧����˾����ʡ��û�����
		    // ������֧�����Է�����ַ
		    String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("callback");
		    String p9_SAF = "";
		    String pa_MP = "";
		    String pr_NeedResponse = "1";
		    // ����hmac ��Ҫ��Կ
		    String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
		        "keyValue");
		    String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
		        p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
		        pd_FrpId, pr_NeedResponse, keyValue);


		    String url = "https://www.yeepay.com/app-merchant-proxy/node?pd_FrpId="+pd_FrpId+
		        "&p0_Cmd="+p0_Cmd+
		        "&p1_MerId="+p1_MerId+
		        "&p2_Order="+p2_Order+
		        "&p3_Amt="+p3_Amt+
		        "&p4_Cur="+p4_Cur+
		        "&p5_Pid="+p5_Pid+
		        "&p6_Pcat="+p6_Pcat+
		        "&p7_Pdesc="+p7_Pdesc+
		        "&p8_Url="+p8_Url+
		        "&p9_SAF="+p9_SAF+
		        "&pa_MP="+pa_MP+
		        "&pr_NeedResponse="+pr_NeedResponse+
		        "&hmac="+hmac;

		    //�ض��򵽵�����֧��ƽ̨
		    response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}














