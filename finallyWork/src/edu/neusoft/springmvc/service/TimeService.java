package edu.neusoft.springmvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.neusoft.springmvc.dao.TimeDao;
import edu.neusoft.springmvc.model.Time;

@Service
public class TimeService {
   
   @Resource
   TimeDao timedao;
   
   public List<Time> selectAllTime(){
        return timedao.selectAllTime();
   }
   
   public int updateTime(Time time){
      return timedao.updateTime(time);
   }
}
