package edu.neusoft.springmvc.dao;

import java.util.List;

import edu.neusoft.springmvc.model.Time;

public interface TimeDao {
   
    public List<Time> selectAllTime();
    
    public int updateTime(Time time);
}
