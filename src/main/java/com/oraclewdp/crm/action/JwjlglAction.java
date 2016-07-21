package com.oraclewdp.crm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.crm.entity.Contact;
import com.oraclewdp.crm.entity.CustomerLink;
import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.service.JwjlglService;
import com.oraclewdp.crm.service.serviceimpl.JwjlglServiceImpl;
import com.oraclewdp.crm.util.ActionSupport;
import com.oraclewdp.crm.util.Pages;

@WebServlet("/jwjlgl.do")
public class JwjlglAction extends ActionSupport{

	private JwjlglService jwjlglService=new JwjlglServiceImpl();
	/**
	 * 每一个请求必须的参数必须包含userRoleId
	 * 同样的这里根据用户的权限，管理员可以列出所有的，用户只能列出自己的
	 * 还要判断是否是从分页标签过来的，分页传过来一个page参数，即pageIndex
	 * @author gui
	 * @time 2016年7月20日 下午3:43:38
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */
	public void listJwjl(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		Pages<Contact> page=null;
		
		int userRoleId=Integer.parseInt(req.getParameter("userRoleId"));
		UserRole userRole=jwjlglService.getUserRole(userRoleId);
		System.out.println(userRole);
		System.out.println(userRoleId);
		page=jwjlglService.listJwjl(userRole);
		//是否分页操作
		String pages=req.getParameter("page");
		if(pages!=null&&!pages.equals("")){
		    int pageIndex=Integer.parseInt(pages);
			page.toPage(pageIndex);
		}else{
			    page.toPage(1);
			}
		req.setAttribute("page", page);
		returnView("jwjlgl", req, resp);
	}
	
	/**
	 * 进入添加页面的请求，需要先把客户联系人全部查出来。
	 * @author gui
	 * @time 2016年7月21日 上午7:26:37
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */
	public void toJwjl_add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		Pages<CustomerLink> page=jwjlglService.getAllCustomerLink();
	    req.setAttribute("page", page);
	    returnView("jwxx_add", req, resp);
	}
	
	/**
	 * 保存交往记录
	 * @author gui
	 * @time 2016年7月21日 上午8:21:21
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */
	public void jwjl_add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		  Contact contact=new Contact();
		  int linkId=Integer.parseInt(req.getParameter("contactor"));
		  int userRoleId=Integer.parseInt(req.getParameter("userRoleId"));
	      String createdate=req.getParameter("createdate");
	      String phone=req.getParameter("phone");
	      String startTime=req.getParameter("startTime");
	      String endTime=req.getParameter("endTime");
	      String context=req.getParameter("context");
	      String content=req.getParameter("content");
	      
	      CustomerLink customerLink=jwjlglService.getCustomerLink(linkId);
	      User user=jwjlglService.getUserRole(userRoleId).getUser();
	     
	      contact.setContactor(customerLink);
	      contact.setContent(content);
	      contact.setContext(context);
	      contact.setCreatedate(createdate);
	      contact.setCreator(user);
	      contact.setCustomer(customerLink.getCustomer());
	      contact.setEndTime(endTime);
	      contact.setPhone(phone);
	      contact.setStartTime(startTime);
	      
	      int id=jwjlglService.saveContact(contact);
	      if(id>0){
	    	  req.getRequestDispatcher("jwjlgl.do?method=listJwjl").forward(req, resp);
	      }
	}
}
