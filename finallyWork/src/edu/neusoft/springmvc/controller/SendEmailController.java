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
      // �ռ��˵ĵ����ʼ�
      String to = "2538867413@qq.com";

      // �����˵ĵ����ʼ�
      String from = "2538867413@qq.com";

      // �������Ǵӱ����������͵����ʼ�

      Properties props = new Properties();  
      props.setProperty("mail.smtp.host", "smtp.qq.com");  
      props.setProperty("mail.transport.protocol", "smtp");  
      props.setProperty("mail.smtp.auth", "true");  

      //����ssl�Ķ˿�    
      props.setProperty("mail.smtp.port", "465");  
      props.setProperty("mail.smtp.ssl.enable", "true"); 

      // ��ȡĬ�ϵ�Session����
      Session mailSession = Session.getInstance(props,authenticator);

      try{
         // ����һ��Ĭ�ϵ�MimeMessage����
         MimeMessage message = new MimeMessage(mailSession);
         // ���� From: ͷ����header�ֶ�
         message.setFrom(new InternetAddress(from));
         // ���� To: ͷ����header�ֶ�
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
         // ���� Subject: header�ֶ�
         message.setSubject("This is the Subject Line!");
         // �������õ�ʵ����Ϣ
         message.setText("This is actual message");
         // ������Ϣ
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
