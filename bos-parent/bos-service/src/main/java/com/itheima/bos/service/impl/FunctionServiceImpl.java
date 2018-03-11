package com.itheima.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IFunctionDao;
import com.itheima.bos.domain.Function;
import com.itheima.bos.domain.User;
import com.itheima.bos.service.IFunctionService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.bos.utils.PageBean;

@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService {

  @Autowired
  private IFunctionDao dao;
  
  @Override
  public List<Function> findAll() {
    // TODO Auto-generated method stub
    return dao.findAll();
  }

  @Override
  public void add(Function model) {
    //TODO Auto-generated method stub
    Function parent = model.getParentFunction();
    if(parent!=null && parent.getId().equals("")){
         model.setParentFunction(null);
    }
    dao.save(model);
  }

  @Override
  public void PageQuery(PageBean pagebean) {
    // TODO Auto-generated method stub
    dao.PageQuery(pagebean);
  }

  @Override
  public List<Function> findMenu() {
    User user = BOSUtils.getLoginUser();
    List<Function> list = null;
    if("admin".equals(user.getUsername())){
        list = dao.findAllMenu();
    }else{
        list = dao.findMenuByUserId(user.getId()); 
    }
    return list;
  }

}

