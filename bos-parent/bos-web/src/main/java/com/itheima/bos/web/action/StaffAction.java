package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;
import com.itheima.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff>{
    
    @Autowired
    private IStaffService staffService;
    
    
    public String add(){
       staffService.save(model);
       return LIST;
    }
    

    public String pageQuery(){
       DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
       pagebean.setDetachedCriteria(detachedCriteria);
       staffService.pageQuery(pagebean);
       javaToJson(pagebean,new String[]{"currentPage","detachedCriteria","pageSize","decidedzones"});
       
       return NONE;
    }
    
    
    private String ids;
    
    
    public String getIds() {
      return ids;
    }

    public void setIds(String ids) {
      this.ids = ids;
    }

    //批量删除
    @RequiresPermissions("staff-delete") //执行这个方法，需要当前用户具有staff-delete权限
    public String deleteBatch(){
         
         staffService.deleteBatch(ids);
         return LIST;
    }
    
    
    //
    public String edit(){
       //
       Staff staff = staffService.findById(model.getId());
       
       staff.setTelephone(model.getTelephone());
       staff.setHaspda(model.getHaspda());
       staff.setStandard(model.getStandard());
       staff.setStation(model.getStation());
       staff.setName(model.getName());
        
       staffService.update(staff);
       return LIST;  
       
    }
    
    
    //
    public String listajax(){
       List<Staff> list = staffService.findListNotDelete();
       this.javaToJson(list,new String[]{"decidedzones"});
       return NONE;
    }
    
    
    
    
}






