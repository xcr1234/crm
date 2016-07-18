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
import com.oraclewdp.crm.entity.UserRole;
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
  private ResultUtil result=null;
  private User user=null;
  private String menu=null;
 
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
		  result=loginService.Login(username, password, validate, session);
		  if(result.isFlag()){
			  user=(User)result.getO();
			  //根据用户查出权限
			  UserRole userRole=loginService.getRole(user);
			  //返回登陆的用户
			  session.setAttribute("userRole", userRole);
			  req.getRequestDispatcher("main.jsp").forward(req, resp);
		  }
		  else{
			  req.setAttribute("info", result.getInfo());
			  req.getRequestDispatcher("login.jsp").forward(req, resp); 
		  }
	}
  
  /**
   * left.jsp框架取值的请求方法
   * @author gui
   * @time 2016年7月15日 上午11:33:51
   * @tags @param req
   * @tags @param resp
   * @tags @throws ServletException
   * @tags @throws IOException
   */
  public void getLeftAttr(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
	  /* int id=Integer.parseInt(req.getParameter("userid"));
	   user=loginService.getUser(id);
	   //得到权限所属的菜单，返回前台。
	    menu= loginService.getAuthority(user);
		System.out.println("menu:"+menu);
	   req.setAttribute("menu", menu);*/
	   req.getRequestDispatcher("left.jsp").forward(req, resp);
  }
  
  /**
   * 退出系统
   * @author gui
   * @time 2016年7月18日 上午2:18:45
   * @tags @param req
   * @tags @param resp
   * @tags @throws ServletException
   * @tags @throws IOException
   */
  public void loginout(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
	   session.invalidate();
	   request.getRequestDispatcher("login.jsp").forward(req, resp);
  }
}
