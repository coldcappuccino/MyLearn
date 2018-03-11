package com.itheima.bos.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IRegionDao;
import com.itheima.bos.domain.Region;
import com.itheima.bos.service.IRegionService;
import com.itheima.bos.utils.PageBean;

@Service
@Transactional
public class RegionServiceImpl implements IRegionService{

  @Autowired
  private IRegionDao regionDao;
  
  //
  public void saveBatch(List<Region> regionList) {
      // TODO Auto-generated method stub
      for(Region temp:regionList){
          regionDao.saveOrUpdate(temp);
      }
  }

  @Override
  public void pageQuery(PageBean pagebean) {
      // TODO Auto-generated method stub
      regionDao.PageQuery(pagebean);
  }

  @Override
  public List<Region> findAll() {
    // TODO Auto-generated method stub
    return regionDao.findAll();
  }
 
  
  //根据用户输入进行模糊查询
  public List<Region> findListbyQ(String q) {
    
    return regionDao.findListbyQ(q);
  }

}








