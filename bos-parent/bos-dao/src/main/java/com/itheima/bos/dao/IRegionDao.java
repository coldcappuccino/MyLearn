package com.itheima.bos.dao;

import java.util.List;

import com.itheima.bos.dao.base.IBaseDao;
import com.itheima.bos.domain.Region;
import com.itheima.bos.domain.Staff;

public interface IRegionDao extends IBaseDao<Region>{

  List<Region> findListbyQ(String q);
       
}
