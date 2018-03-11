package edu.neusoft.springmvc.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("email")
public class SendEmailController {
    
    @RequestMapping("send")
    public String send(){
     javax.mail.Authenticator authenticator = new MyAuthenticator("2538867413@qq.com","cfiqczwczemsebcj");
      String result;
      // 收件人的电子邮件
      String to = "2538867413@qq.com";

      // 发件人的电子邮件
      String from = "2538867413@qq.com";

      // 假设你是从本地主机发送电子邮件

      Properties props = new Properties();  
      props.setProperty("mail.smtp.host", "smtp.qq.com");  
      props.setProperty("mail.transport.protocol", "smtp");  
      props.setProperty("mail.smtp.auth", "true");  

      //设置ssl的端口    
      props.setProperty("mail.smtp.port", "465");  
      props.setProperty("mail.smtp.ssl.enable", "true"); 

      // 获取默认的Session对象。
      Session mailSession = Session.getInstance(props,authenticator);

      try{
         // 创建一个默认的MimeMessage对象。
         MimeMessage message = new MimeMessage(mailSession);
         // 设置 From: 头部的header字段
         message.setFrom(new InternetAddress(from));
         // 设置 To: 头部的header字段
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
         // 设置 Subject: header字段
         message.setSubject("This is the Subject Line!");
         // 现在设置的实际消息
         message.setText("This is actual message");
         // 发送消息
         Transport.send(message);
         result = "Sent message successfully....";
      }catch (MessagingException mex) {
         mex.printStackTrace();
         result = "Error: unable to send message....";
      }
        return null;
    }
}


class MyAuthenticator extends Authenticator{  
  String userName=null;  
  String password=null;  
     
  
  public MyAuthenticator(){  
  }  
  
  public MyAuthenticator(String username, String password) {   
      this.userName = username;   
      this.password = password;
  }
  
  protected PasswordAuthentication getPasswordAuthentication(){  
      return new PasswordAuthentication(userName, password);  
  }  
}  
