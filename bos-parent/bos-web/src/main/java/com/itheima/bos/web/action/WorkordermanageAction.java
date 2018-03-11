package com.itheima.bos.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Workordermanage;
import com.itheima.bos.service.IWorkordermanageService;
import com.itheima.bos.web.action.base.BaseAction;


@Controller
@Scope("prototype")
public class WorkordermanageAction extends BaseAction<Workordermanage>{

  @Autowired
  private IWorkordermanageService service;
  
   public String add(){
        
       String f = "0";
       try{
         service.add(model);
       }catch(Exception e){
          e.printStackTrace();
          f="1";
       }
      
       ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
       try {
        ServletActionContext.getResponse().getWriter().print(f);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
       return NONE;
   }
}





