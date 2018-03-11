package com.itheima.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IDecidedzoneDao;
import com.itheima.bos.dao.ISubareaDao;
import com.itheima.bos.domain.Decidedzone;
import com.itheima.bos.domain.Subarea;
import com.itheima.bos.service.IDecidedzoneService;
import com.itheima.bos.utils.PageBean;

@Service
@Transactional
public class IDecidedzoneImpl implements IDecidedzoneService{
  
  @Autowired
  private IDecidedzoneDao decidedzonedao;
  
  @Autowired
  private ISubareaDao subareadao;
  
  //
  public void save(Decidedzone model, String[] subareaid) {
       // TODO Auto-generated method stub
       decidedzonedao.save(model);
       for(String id: subareaid){
          Subarea subarea = subareadao.findById(id);
          subarea.setDecidedzone(model);//分区关联定区
          
       }
  }

  @Override
  public void pageQuery(PageBean pagebean) {
      // TODO Auto-generated method stub
      decidedzonedao.PageQuery(pagebean);
  }
    
   
}
