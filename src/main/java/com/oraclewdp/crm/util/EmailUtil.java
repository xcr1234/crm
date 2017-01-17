package com.oraclewdp.crm.util;

import java.io.File;
import java.util.List;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public  class EmailUtil {
  private static EmailUtil emailUtil=new EmailUtil();
  private static PropUtils prop=new PropUtils("EMAIL");
  private static String SMTP=prop.getValue("smtp");
  private static String  USERNAME=prop.getValue("username");
  private static String  PWD=prop.getValue("password");
  private static String  PORT=prop.getValue("port");
  private static String  FROM=prop.getValue("frommail");
  
 
  private  EmailUtil() {
		}

  //获取单例的实例对象
  public static EmailUtil getInstance(){
	  if(emailUtil==null){
		  emailUtil=new EmailUtil();
	  }
	  return emailUtil;
  }
  
  /**
   * 简单的发送邮件方法
   * @author gui
   * @time 2016年6月15日 下午6:35:39
   * @tags @param subject 主题
   * @tags @param msg  内容
   * @tags @param to   发送对象的邮箱
   */
  public void sendSimpleEmail(String subject,String msg,String to){
	  SimpleEmail email=new SimpleEmail();
	  try {
	  email.setCharset("UTF-8");
	  email.setAuthentication(USERNAME, PWD); //这种方式更安全，用户名密码被加密传输
	  if(PORT.equals("465")){
		  email.setSSLOnConnect(true);
		  email.setSmtpPort(Integer.parseInt(PORT));
	  }else{
		  email.setSmtpPort(Integer.parseInt(PORT));
	  }
	  
	  email.setHostName(SMTP);
	  email.setFrom(FROM);
	  email.setSubject(subject); //主题
	  email.setMsg(msg);
	  email.addTo(to);
	  email.send();
	} catch (EmailException e) {
		e.printStackTrace();
	}
	  
 }
  
  /**
   * @author gui
   * @time 2016年6月15日 下午6:39:33
   * @tags @param subject
   * @tags @param html
   * @tags @param to
   */
  public void sendHTMLEmail(String subject,String html,String to,List<EmailAttachment> atts,List<File>files){
	  HtmlEmail email=new HtmlEmail(); 
	  try {
		  email.setCharset("UTF-8");
		  email.setAuthentication(USERNAME, PWD); //这种方式更安全，用户名密码被加密传输
		  if(PORT.equals("465")){
			  email.setSSLOnConnect(true);
			  email.setSmtpPort(Integer.parseInt(PORT));
		  }else{
			  email.setSmtpPort(Integer.parseInt(PORT));
		  }
		  email.setHostName(SMTP);
		  email.setFrom(FROM);
		  email.setSubject(subject); //主题
		  email.setHtmlMsg(html);
		  email.addTo(to);
		  //如果有附件（参数以附件来传递）
		  if(null!=atts&&atts.size()>0){
			  for(EmailAttachment att:atts){
				  email.attach(att);
			  }	  
		  }
		  //如果有文件（通过文件来传参）
		  if(null!=files&&files.size()>0){
			  for(File f:files){
				  email.attach(f);
			  }
		  }
		  email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
  }
  
  public void sendMultEmail(String subject,String msg,String to,List<EmailAttachment> atts,List<File> files){
	  MultiPartEmail email=new MultiPartEmail();
	  try {
		  email.setCharset("UTF-8");
		  email.setAuthentication(USERNAME, PWD); //这种方式更安全，用户名密码被加密传输
		  if(PORT.equals("465")){
			  email.setSSLOnConnect(true);
			  email.setSmtpPort(Integer.parseInt(PORT));
		  }else{
			  email.setSmtpPort(Integer.parseInt(PORT));
		  }
		  email.setHostName(SMTP);
		  email.setFrom(FROM);
		  email.setSubject(subject); //主题
		  email.setMsg(msg);
		  email.addTo(to);
		  //如果有附件（参数以附件来传递）
		  if(null!=atts&&atts.size()>0){
			  for(EmailAttachment att:atts){
				  email.attach(att);
			  }	  
		  }
		  //如果有文件（通过文件来传参）
		  if(null!=files&&files.size()>0){
			  for(File f:files){
				  email.attach(f);
			  }
		  }
		  email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
  }
  
}
