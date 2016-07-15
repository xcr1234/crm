package com.oraclewdp.crm.util;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="validateCode",value="/validateCode.do")
public class ValidateCode extends HttpServlet {
   private static  String validatecode=""; 
	
	public ValidateCode() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
		
	}

	public void init() throws ServletException {
		
	}


	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 resp.setHeader("Content-Type","image/jpeg; charset=UTF-8");
		 resp.setHeader("Pragma","no-cache");
		 resp.setHeader("Cache-Control","no-cache");
		 resp.setDateHeader("Expires",-1);
		 OutputStream outputStream=resp.getOutputStream();
		 BufferedImage image=new BufferedImage(83, 35, BufferedImage.TYPE_INT_BGR);
		 Graphics g=image.getGraphics();
		 Color color=g.getColor(); 
		 g.fillRect(0, 0,83,35); 
		 char[]ch="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		 int length=ch.length;
		 Random random=new Random();
		 Font[]font=new Font[5];
		 font[0]=new Font("Ravie",Font.PLAIN,25);
		 font[1]=new Font("Autique Olive Compact",Font.PLAIN,30);
		 font[2]=new Font("Forte",Font.PLAIN,24);
		 font[3]=new Font("Wide Latin",Font.PLAIN,24);
		 font[4]=new Font("Gill Sans Ultra Bold",Font.PLAIN,30);
		 Font nowFont=font[random.nextInt(5)];
		 String sRand="";
		 for(int i=0;i<4;i++)
		 {
			//设置字体的样式
			 g.setFont(nowFont);
			String rand=new Character(ch[random.nextInt(length)]).toString();
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			g.drawString(rand,20*i+6,25);
		     sRand+=rand;
		 }
		 //干扰线
		 for(int i=0;i<1;i++)
		 {
			 int x1=random.nextInt(83);
			 int y1=random.nextInt(35);
			 g.drawOval(x1,y1,2,2);
		 }
		 g.setColor(color);
		 g.dispose();
		 HttpSession session=req.getSession();
		 session.setAttribute("validateCode",sRand.toUpperCase());
		 ImageIO.write(image,"JPEG", outputStream);
	
	}
	
	

}
