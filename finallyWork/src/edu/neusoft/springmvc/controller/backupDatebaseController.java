package edu.neusoft.springmvc.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mysql")
public class backupDatebaseController {
    
    @RequestMapping("backup")
    public String backup(){
       String strCommand = "mysqldump -hlocalhost -uroot -proot finalwork > d:/db1.sql";
       String result = exeCmd(strCommand);
       return null;
    }
    
    public String exeCmd(String cmd){
       StringBuffer sb = new StringBuffer("");  
       StringBuffer str = new StringBuffer();
       
       str.append("cmd.exe /c \"").append(cmd).append("\"");
       System.out.println(str);
       
       Process ls_proc;
       try {
            ls_proc = Runtime.getRuntime().exec(str.toString());
       } catch (IOException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
       }
       return null;
    }
}






