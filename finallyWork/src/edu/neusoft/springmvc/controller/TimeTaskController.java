package edu.neusoft.springmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.neusoft.springmvc.model.Time;
import edu.neusoft.springmvc.model.resource;
import edu.neusoft.springmvc.service.TimeService;

@Service  
public class TimeTaskController {
   
   @Resource 
   TimeService timeservice;
   
   public void job1(){
       List <Time>timelist = null;
       timelist = timeservice.selectAllTime();
       
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
       String nowtime = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
       Date  Systime= null;
       try {
         Systime = df.parse(nowtime);
       } catch (ParseException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }//���ַ���ת����date����
   
       Date mysqltime = null;
       for(Time temp: timelist){
           try {
             mysqltime = df.parse(temp.getEndDate());
          } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          
          int i = mysqltime.compareTo(Systime);
          System.out.println(i);
          if(i<=0){
             System.out.println("aaa");
             temp.setNumber(0);
             timeservice.updateTime(temp);
          }
       }
       
   }
   
}













