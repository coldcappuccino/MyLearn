package com.itheima.bos.service.impl;

import java.util.List;

import org.apache.poi.ddf.EscherTertiaryOptRecord;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.ISubareaDao;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.domain.Subarea;
import com.itheima.bos.service.ISubareaService;
import com.itheima.bos.utils.PageBean;

@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService{

     @Autowired
     private ISubareaDao dao;

    @Override
    public void add(Subarea model) {
      // TODO Auto-generated method stub
       dao.save(model);
    }

    @Override
    public void pageQuery(PageBean pagebean) {
      // TODO Auto-generated method stub
      dao.PageQuery(pagebean);
    }

    @Override
    public List<Subarea> findAll() {
       
       //TODO Auto-generated method stub
       return dao.findAll();
    }

    @Override
    public List<Subarea> findListNotAssociation() {
      // TODO Auto-generated method stub
      DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
      //添加过滤条件
      detachedCriteria.add(Restrictions.isNull("decidedzone"));
      return dao.findByCriteria(detachedCriteria);
    }

    @Override
    public List<Subarea> findListbyDecidedZoneId(String decidedzoneId) {
      DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
      detachedCriteria.add(Restrictions.eq("decidedzone.id",decidedzoneId));
      return dao.findByCriteria(detachedCriteria);
    }

    @Override
    public List<Object> findSubareasGroupByProvince() {
      List<Object> list = dao.findSubareasGroupByProvince();
      return list;
    }
}







