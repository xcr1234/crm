package com.oraclewdp.crm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.crm.entity.CustomerCare;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.service.KhghService;
import com.oraclewdp.crm.service.serviceimpl.KhghServiceImpl;
import com.oraclewdp.crm.util.ActionSupport;
import com.oraclewdp.crm.util.Pages;

@WebServlet("/khgh.do")
public class KhghAction extends ActionSupport{
	private KhghService khghService=new KhghServiceImpl();

	public void listKhgh(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		//该请求必须获得的参数:获取userRoleId
		int userRoleId=Integer.parseInt(req.getParameter("userRoleId"));
		UserRole userRole=khghService.getUserRole(userRoleId);
		Pages<CustomerCare> page=khghService.listCustomerCare(userRole);
	   //下面判断是否是分页标签的操作
		String pages=req.getParameter("page");
		if(pages!=null&&!pages.equals("")){
			int pageIndex=Integer.parseInt(pages);
			page.toPage(pageIndex);
		}else{
			page.toPage(1);
		}
		req.setAttribute("page", page);
		returnView("khgh", req, resp);
	}
}
