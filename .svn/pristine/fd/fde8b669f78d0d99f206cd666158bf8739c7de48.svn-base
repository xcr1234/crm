package com.oraclewdp.crm.action;

import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.service.YhglService;
import com.oraclewdp.crm.service.serviceimpl.YhglServiceImpl;
import com.oraclewdp.crm.util.ActionSupport;
import com.oraclewdp.crm.util.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/yhgl.do")
public class YhglAction extends ActionSupport{
  private YhglService yhglService=new YhglServiceImpl();
  
  
	/**
	 * 列出所有用
	 * @author gui
	 * @time 2016年7月18日 上午8:11:16
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */

	 public void listUsers(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		Pages<UserRole> pages=yhglService.listUserRole();
		req.setAttribute("page", pages);
		returnView("zhgl", req, resp);
		 
	 }
}
