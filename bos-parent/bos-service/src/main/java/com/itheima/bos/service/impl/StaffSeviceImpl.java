package com.itheima.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IStaffDao;
import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;


@Service
@Transactional
public class StaffSeviceImpl implements IStaffService{

  @Autowired
  private IStaffDao dao;
  public void save(Staff model) {
      // TODO Auto-generated method stub
      dao.save(model);
  }
  
  @Override
  public void pageQuery(PageBean pagebean) {
    // TODO Auto-generated method stub
    dao.PageQuery(pagebean);
  }

  @Override
  public void deleteBatch(String ids) {
       // TODO Auto-generated method stub
       if(StringUtils.isNotBlank(ids)){
           String[] staffIds = ids.split(",");
           for(String id : staffIds){
                 dao.executeUpdate("staff.delete",id);
           }
       }
  }

  @Override
  public void update(Staff model) {
    // TODO Auto-generated method stub
    dao.update(model);
  }
    
  
  public Staff findById(String id){
     return dao.findById(id);
  }

  @Override
  public List<Staff> findListNotDelete() {
     // TODO Auto-generated method stub
     DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
     
     detachedCriteria.add(Restrictions.eq("deltag","0"));
     return dao.findByCriteria(detachedCriteria);
  }
}









