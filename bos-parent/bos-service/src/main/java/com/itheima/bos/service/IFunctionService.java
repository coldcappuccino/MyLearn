package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.domain.Function;
import com.itheima.bos.utils.PageBean;

public interface IFunctionService {

  List<Function> findAll();

  void add(Function model);

  void PageQuery(PageBean pagebean);

  List<Function> findMenu();

}
