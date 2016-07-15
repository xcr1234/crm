package com.oraclewdp.crm.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.crm.dao.RoleAuthorityDao;
import com.oraclewdp.crm.dao.UserRoleDao;
import com.oraclewdp.crm.dao.impl.RoleAuthorityDaoImpl;
import com.oraclewdp.crm.dao.impl.UserRoleDaoImpl;
import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.service.LoginService;
import com.oraclewdp.crm.service.serviceimpl.LoginServiceImpl;
import com.oraclewdp.crm.util.ActionSupport;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Pages;
import com.oraclewdp.crm.util.ResultUtil;

/**
 * 登陆控制器
 * @author gui
 * @time 2016年7月15日 上午1:30:14
 *
 */
@WebServlet("/loginAction.do")
public class LoginAction extends ActionSupport{
  private LoginService loginService=new LoginServiceImpl();
 
  /**
   * 登陆方法
   * @author gui
   * @time 2016年7月15日 上午1:30:14
   * @tags @param req
   * @tags @param resp
   * @tags @throws ServletException
   * @tags @throws IOException
   */
  public void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		  String username=req.getParameter("username");
		  String password=req.getParameter("password");
		  String validate=req.getParameter("validate").toUpperCase();
		  ResultUtil result=null;
		  result=loginService.Login(username, password, validate, session);
		  if(result.isFlag()){
			  //得到权限所属的菜单，返回前台。
			  String menu= loginService.getAuthority((User)result.getO());
			  req.setAttribute("menu", menu);
			  System.out.println("menu:"+menu);
			  //返回登陆的用户
			  session.setAttribute("user", (User)result.getO());
			  req.getRequestDispatcher("main.jsp").forward(req, resp);
		  }
		  else{
			  req.setAttribute("info", result.getInfo());
			  req.getRequestDispatcher("login.jsp").forward(req, resp);	  
		  }
	}
}
