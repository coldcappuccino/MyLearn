package com.itheima.bos.web.action;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Region;
import com.itheima.bos.domain.User;
import com.itheima.bos.service.IRegionService;
import com.itheima.bos.utils.PageBean;
import com.itheima.bos.utils.PinYin4jUtils;
import com.itheima.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/*
 *   
 * */
@Controller
public class RegionAction extends BaseAction<Region>{
    
       private File regionFile;
       
  
       @Autowired
       private IRegionService regionService;

       public void setRegionFile(File regionFile) {
          this.regionFile = regionFile;
       }
       
  
      public String importXLs() throws FileNotFoundException, IOException{
       
         List<Region> RegionList = new ArrayList();
         HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionFile));
         
         HSSFSheet hssfSheet = workbook.getSheet("Sheet1");
         for(Row row: hssfSheet){
              int number = row.getRowNum();
              if(number == 0){
                continue;
              }
               
              String id = row.getCell(0).getStringCellValue();
              String province = row.getCell(1).getStringCellValue();
              String city = row.getCell(2).getStringCellValue();
              String district = row.getCell(3).getStringCellValue();
              String postcode = row.getCell(4).getStringCellValue();
               
             
              Region region = new Region(id,province,city,district,postcode,null,null,null);
              
              province = province.substring(0, province.length() - 1);
              city = city.substring(0, city.length() - 1);
              district = district.substring(0, district.length() - 1);
              String info = province + city + district;
              String[] headByString = PinYin4jUtils.getHeadByString(info);
              String shortcode = StringUtils.join(headByString);
             
              String citycode = PinYin4jUtils.hanziToPinyin(city, "");
              
              region.setShortcode(shortcode);
              region.setCitycode(citycode);
              RegionList.add(region);
         }
         
    
         regionService.saveBatch(RegionList);
         return NONE;
      }
      
      
      public String pageQuery(){
         DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Region.class);
         pagebean.setDetachedCriteria(detachedCriteria);
         regionService.pageQuery(pagebean);
         javaToJson(pagebean,new String[]{"currentPage","detachedCriteria","pageSize","subareas"});
         
         return NONE;
      }
      
      private String q;

      
      public void setQ(String q) {
        this.q = q;
      }


      public String listajax(){
        
        List<Region> list = null;
        if(StringUtils.isNotBlank(q)){
          list = regionService.findListbyQ(q);
        }else{
          list = regionService.findAll();
        }
        this.javaToJson(list, new String[]{"subareas"});
        return NONE;
        
      }
      
}











