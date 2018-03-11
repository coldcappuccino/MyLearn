package com.itheima.bos.jobs;
import java.util.Date;

import java.util.List;
import java.util.Properties;
import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.itheima.bos.dao.IWorkbillDao;
import com.itheima.bos.domain.Workbill;
/**
 * 
 * @author zhaoqx
 *
 */
public class MailJob {
	@Autowired
	private IWorkbillDao workbillDao;
	
	private String username;//发件人的邮箱账号
	private String password;//发件人的邮箱密码
	private String smtpServer;//选择的服务器
	
	//在spring中对属性进行注入
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void execute() {
		System.out.println("开始发送邮件了" + new Date());
		try {
			
			List<Workbill> list = workbillDao.findAll();
			if(null != list && list.size() > 0){
				final Properties mailProps = new Properties();
				mailProps.put("mail.smtp.host", this.getSmtpServer());
				mailProps.put("mail.smtp.auth", "true");
				mailProps.put("mail.username", this.getUsername());
				mailProps.put("mail.password", this.getPassword());
				
			  //设置ssl的端口    
				mailProps.setProperty("mail.smtp.port", "465");  
				mailProps.setProperty("mail.smtp.ssl.enable", "true"); 

				//构建授权信息，用于进行SMTP身份验证
				Authenticator authenticator = new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						//用户名、密码
						String userName = mailProps.getProperty("mail.username");
						String password = mailProps.getProperty("mail.password");
						return new PasswordAuthentication(userName, password);
					}
				};
				//环境属性授权信息，创建邮件会话
				Session mailSession = Session.getInstance(mailProps, authenticator);
				for(Workbill workbill : list){
					//创建邮件消息
					MimeMessage message = new MimeMessage(mailSession);
			    //设置发件人地址
					InternetAddress from = new InternetAddress(mailProps.getProperty("mail.username"));
					message.setFrom(from);
					
					// 设置 To: 头部的header字段
					message.setRecipient(RecipientType.TO, new InternetAddress("2538867413@qq.com")); //设置发送方式与接收者
					//设置邮件标题
					message.setSubject("这是一封邮件");
					//设置邮件的内容体
					message.setContent(workbill.toString(), "text/html;charset=UTF-8");
					//发送邮件
					Transport.send(message);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}
}
