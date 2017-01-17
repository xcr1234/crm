package com.oraclewdp.crm.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.crm.dao.CustomerDao;
import com.oraclewdp.crm.entity.CustomerCare;
import com.oraclewdp.crm.entity.CustomerLink;
import com.oraclewdp.crm.entity.DicAll;
import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.service.KhsrcxService;
import com.oraclewdp.crm.service.serviceimpl.KhsrcxServiceImpl;
import com.oraclewdp.crm.util.ActionSupport;
import com.oraclewdp.crm.util.DateUtil;
import com.oraclewdp.crm.util.EmailUtil;
import com.oraclewdp.crm.util.Pages;

@WebServlet("/khsrxc.do")
public class KhsrcxAction extends ActionSupport{
   private KhsrcxService khsrcxService=new KhsrcxServiceImpl();
	
   /**
    * 这里将按月查询和按周查询放到了一起。
    * @author gui
    * @time 2016年7月21日 上午1:07:16
    * @tags @param req
    * @tags @param resp
    * @tags @throws ServletException
    * @tags @throws IOException
    */
	public void kxByWeek(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		Pages<CustomerLink> page=khsrcxService.getLinkByWeek();
		req.setAttribute("page", page);
		
		Pages<CustomerLink> page2=khsrcxService.getLinkByMonth();
	    req.setAttribute("page2", page2);
		
	    returnView("khsrcx", req, resp);
	}
	
	public void kxByMonth(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		Pages<CustomerLink> page=khsrcxService.getLinkByMonth();
	    req.setAttribute("page", page);
	    returnView("khsrcx", req, resp);
	}
	
	/**
	 * 进入发送邮件编辑页面的方法,要查出一个随机邮件内容。
	 * @author gui
	 * @time 2016年7月21日 上午1:44:58
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */
	public void toSendMail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String userIdStr=req.getParameter("userId");
		int userId=Integer.parseInt(userIdStr);
		String cusLinkId=req.getParameter("cusLinkId");
		int linkId=0;
		if(!cusLinkId.isEmpty()){
			linkId=Integer.parseInt(cusLinkId);
		}
		CustomerLink customerLink=khsrcxService.getLink(linkId);
		User user=khsrcxService.getUser(userId);
		//查出随机的邮件内容
		String  content=khsrcxService.getEmailContent().getName();
		String sexName=customerLink.getSex()?"先生":"女士";
		//构造邮件内容
		 content="尊敬的"+customerLink.getName()+sexName+"\r"
				 +"您好！\r"
				 +"     "+content+"\r"
				 +user.getNickName()+"  敬!";
		req.setAttribute("link", customerLink);
		req.setAttribute("content", content);
		returnView("sendEmail", req, resp);
	}
	/**
	 * 发送邮件的方法，发送完毕之后应该将记录存到客户关怀表。
	 * @author gui
	 * @time 2016年7月21日 上午1:06:19
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */
	public void sendMail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String title=req.getParameter("mail_title");
		String to=req.getParameter("mail_to");
		String content=req.getParameter("mail_content");
		
		EmailUtil.getInstance().sendSimpleEmail(title,content, to);
		req.setAttribute("info", "发送成功！");
		
		//发送成功之后，应该存进客户关怀表
		int userId=Integer.parseInt(req.getParameter("userId"));
		int linkId=Integer.parseInt(req.getParameter("linkId"));
		
		User user=khsrcxService.getUser(userId);
		CustomerLink customerLink=khsrcxService.getLink(linkId);
		CustomerCare customerCare=new CustomerCare();
		
		String time=DateUtil.getDateTimeStrByFormat(new Date(), "yyyy-MM-dd");
		customerCare.setCreatdate(time);
		customerCare.setContent("生日祝福");
		customerCare.setCreator(user);
		customerCare.setCustomer(customerLink.getCustomer());
		customerCare.setDate(time);
		customerCare.setPhone(customerLink.getPhone());
		customerCare.setPhone2(customerLink.getPhone2());
		
		//存操作
		int id=khsrcxService.saveCustomerCare(customerCare);
		if(id>0){
			returnView("sendEmail", req, resp); 
		}
		 
	}
}
