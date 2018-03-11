package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Region;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.domain.Subarea;
import com.itheima.bos.service.ISubareaService;
import com.itheima.bos.utils.FileUtils;
import com.itheima.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea>{
    
    @Autowired
    private ISubareaService SubareaService;
    
    public String add(){
       SubareaService.add(model);
       return LIST;
    }
    
    
    public String pageQuery(){
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
        String addresskey = model.getAddresskey();
        
        if(StringUtils.isNotBlank(addresskey)){
           //
           detachedCriteria.add(Restrictions.like("addresskey","%"+addresskey+"%"));
        }
        
        Region region = model.getRegion();
        if(region != null){
           String province = region.getProvince();
      
           String city = region.getCity();
     
           String district = region.getDistrict();
   
           detachedCriteria.createAlias("region","r");
           if(StringUtils.isNotBlank(province)){
            
              detachedCriteria.add(Restrictions.like("r.province","%"+province+"%"));
           }
           if(StringUtils.isNotBlank(city)){
            
             detachedCriteria.add(Restrictions.like("r.city","%"+city+"%"));
          }
           if(StringUtils.isNotBlank(district)){
          
             detachedCriteria.add(Restrictions.like("r.district","%"+district+"%"));
          }
        }
        pagebean.setDetachedCriteria(detachedCriteria);
 
        SubareaService.pageQuery(pagebean);
        javaToJson(pagebean,new String[]{"currentPage","detachedCriteria","decidedzone","subareas"});
        return NONE;
    }
    
    public String exportXls(){
    
        List<Subarea> list = SubareaService.findAll();
     
        HSSFWorkbook workbook = new HSSFWorkbook();
      
        HSSFSheet sheet = workbook.createSheet("分区数据");
      
        HSSFRow headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("分区编号");
        headRow.createCell(1).setCellValue("开始编号");
        headRow.createCell(2).setCellValue("结束编号");
        headRow.createCell(3).setCellValue("位置信息");
        headRow.createCell(4).setCellValue("省市区");
        
       
        for(Subarea subarea: list){
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(subarea.getId());
            dataRow.createCell(1).setCellValue(subarea.getStartnum());
            dataRow.createCell(2).setCellValue(subarea.getEndnum());
            dataRow.createCell(3).setCellValue(subarea.getPosition());
            dataRow.createCell(4).setCellValue(subarea.getRegion().getName());
        }
        
    
        ServletOutputStream out= null;
        String filename = "分区数据.xls";
        String contentType = ServletActionContext.getServletContext().getMimeType(filename);
        ServletActionContext.getResponse().setContentType(contentType);
        
        try {
          out = ServletActionContext.getResponse().getOutputStream();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
       
        String agent = ServletActionContext.getRequest().getHeader("User-Agent");  
        try {
         
          filename = FileUtils.encodeDownloadFilename(filename, agent);
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        
        ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename="+filename);
        try {
          workbook.write(out);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
        return null; 
    }
    
    public String listajax(){
       List<Subarea> list = SubareaService.findListNotAssociation();
       this.javaToJson(list,new String[]{"decidedzone","region"});
       return NONE;
    }
    
    
    private String decidedzoneId;
    

    public void setDecidedzoneId(String decidedzoneId) {
      this.decidedzoneId = decidedzoneId;
    }


    //根据定区的id查询关联的分区
    public void findListbyDecidedZoneId(){
        List<Subarea> list = SubareaService.findListbyDecidedZoneId(decidedzoneId);
        this.javaToJson(list,new String[]{"decidedzone","subareas"});
    }
    
    
    //查询区域分区分布图数据
    public String findSubareasGroupByProvince(){
       List<Object> list = SubareaService.findSubareasGroupByProvince();
       this.javaToJson(list,new String[]{});
       return NONE;
    }
}












