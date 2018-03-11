package edu.neusoft.springmvc.controller;

import java.util.ArrayList;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import edu.neusoft.springmvc.model.Sale;
import edu.neusoft.springmvc.service.SaleService;
import jdk.nashorn.internal.ir.RuntimeNode.Request;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping("sale")
public class SaleCollection {
    
  @Resource
  private SaleService saleservice;
  
  
  @RequestMapping("add")
  public String add(Sale sale){
      saleservice.add(sale);
      return "success";
  }
  
  @RequestMapping("delete")
  public String delete(String UUID){
      saleservice.delete(UUID);
      return "success";
  }
  
  @RequestMapping("update")
  public String update(Sale sale){
      saleservice.update(sale);
      return "success";
  }
  
  @RequestMapping("select")
  public String select(String page,HttpServletRequest req){
      //ÿҳ��ʾ������
      int pageSize = 2;
      
      //��ѯ����
      List<Sale> sales = new ArrayList<Sale>();
      sales = saleservice.getall();
      req.setAttribute("userNum",sales.size());
      
      //����һ������ҳ
      int pageTimes;
      
      if(sales.size()%pageSize == 0)
      {
          pageTimes = sales.size()/pageSize;
      }
      else
      {
          pageTimes = sales.size()/pageSize + 1;
      }
      req.setAttribute("pageTimes",pageTimes);
      
      //ҳ���ʼ��ʱ��pageû��ֵ
      if(null == page)
      {
          page = "1";
      }
      
      int startRow = (Integer.parseInt(page)-1) * pageSize;         //�ӵڼ�����¼��ʼ��ѯ
      sales = saleservice.getbyPage(startRow, pageSize);            //��ѯ��ǰҳ��ʾ����
      
      String data = JSON.toJSONString(sales);
      req.setAttribute("currentPage",page);                         //д�뵱ǰҳ��
      req.setAttribute("sales",data);                          
      
      return "list";
  }
}


















