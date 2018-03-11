package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.domain.Subarea;
import com.itheima.bos.utils.PageBean;

public interface ISubareaService {

  void add(Subarea model);

  void pageQuery(PageBean pagebean);

  List<Subarea> findAll();

  List<Subarea> findListNotAssociation();

  List<Subarea> findListbyDecidedZoneId(String decidedzoneId);

  List<Object> findSubareasGroupByProvince();

}
