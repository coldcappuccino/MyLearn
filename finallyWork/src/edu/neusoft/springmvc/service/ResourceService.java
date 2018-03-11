package edu.neusoft.springmvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.neusoft.springmvc.dao.ResourceDao;
import edu.neusoft.springmvc.model.resource;;

@Service
public class ResourceService {
  
  @Resource
  private ResourceDao rd;
  
  public resource selectResource(int sourceID){
      return rd.find(sourceID);
  }
  
}
