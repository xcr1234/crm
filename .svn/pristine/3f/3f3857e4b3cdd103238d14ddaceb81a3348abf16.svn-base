package com.oraclewdp.crm.action;

import com.oraclewdp.crm.dao.impl.DicAllDaoImpl;
import com.oraclewdp.crm.entity.Role;
import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.service.DicAllService;
import com.oraclewdp.crm.service.YhglService;
import com.oraclewdp.crm.service.serviceimpl.DicAllServiceImpl;
import com.oraclewdp.crm.service.serviceimpl.YhglServiceImpl;
import com.oraclewdp.crm.util.ActionSupport;
import com.oraclewdp.crm.util.CodeUtil;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.MD5Util;
import com.oraclewdp.crm.util.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/yhgl.do")
public class YhglAction extends ActionSupport{
  private YhglService yhglService=new YhglServiceImpl();
  private DicAllService dicAllService=new DicAllServiceImpl();
	/**
	 * 列出所有用户
	 * @author gui
	 * @time 2016年7月18日 上午8:11:16
	 * @tags @param req
	 * @tags @param resp
	 * @tags @throws ServletException
	 * @tags @throws IOException
	 */

	 public void listUsers(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		Pages<UserRole> page=null;
		//首先要查出下拉框的数据字典
		 //根据用户的不同角色，返回不同的信息
		 //得到角色名
		 String userStr=req.getParameter("userId");
		 int userId=Integer.parseInt(userStr);
		 UserRole userRole=yhglService.getUserRole(userId);
		 Role role=userRole.getRole();
	     //根据不同的角色查询出不同的结果
		 page=yhglService.listUserRole(role);
		
		 //判断是否分页
		String pages=req.getParameter("page");
		if(pages!=null&&!pages.equals("")){
			int pageIndex=Integer.parseInt(pages);
			page.toPage(pageIndex);
		}else{
			page.toPage(1);
		}
		
		req.setAttribute("page", page);
		returnView("yhgl", req, resp);
		 
	 }
	 
	 /**
	  * 用户添加，我们要根据用户的角色返回给不同的可选分配权限。
	  * @author gui
	  * @time 2016年7月20日 上午1:36:10
	  * @tags @param req
	  * @tags @param resp
	  * @tags @throws ServletException
	  * @tags @throws IOException
	  */
	 public void user_add(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
	    System.out.println("我进来啦");
		 //这里得到用户的ID是为了保存后，返回列表页时按照权限显示。
		int userId=Integer.parseInt(req.getParameter("userId"));
		int roleId=0;
		String roleStr=req.getParameter("role_name");
		String  user_nickName=req.getParameter("user_nickName");
	    String user_userName=req.getParameter("user_userName");
	    String user_password=req.getParameter("user_password");
	    if(!roleStr.isEmpty()){
	      roleId=Integer.parseInt(roleStr);
	    }
		
	    
	    User user=new User();
	    user.setNickName(user_nickName);
	    user.setPassword(user_password);
	    user.setUserName(user_userName);
	    
	    Role role=new Role();
	    role=yhglService.getRole(roleId);
	    
	    UserRole userRole=new UserRole();
	    userRole.setUser(user);
	    userRole.setRole(role);
	    
	    //下面保存user表和userRole表
	   boolean flag=yhglService.saveUserRole(user, role);
	   if(flag){
		   req.getRequestDispatcher("yhgl.do?method=listUsers&userId="+userId).forward(req, resp);
	   }
	 }
	 
	 /**
	  * 获取用户名,密码,姓名的ajax请求
	  * @author gui
	  * @time 2016年7月20日 上午3:12:06
	  * @tags
	  */
	 public void getCode(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		 int roleId=Integer.parseInt(req.getParameter("roleId"));
		 String code=CodeUtil.getCodeByRoleId(roleId);
		 renderJSON(code, resp);
	 }
	 
	 /**
	  * 重置密码
	  * @author gui
	  * @time 2016年7月20日 下午12:04:25
	  * @tags @param req
	  * @tags @param resp
	  * @tags @throws ServletException
	  * @tags @throws IOException
	  */
	 public void reset(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		 int userRoleId=Integer.parseInt(req.getParameter("userRoleId"));
		 UserRole userRole=yhglService.getUserRoleByUserRoleId(userRoleId);
		 User user=userRole.getUser();
		 user.setPassword(MD5Util.encode(user.getUserName()));
		 boolean flag=yhglService.updateUser(user);
	     if(flag){
	    	 String info="重置成功，重置后的密码为您的用户名！";
	    	 System.out.println("重置成功，重置后的密码为您的用户名！");
	    	 renderJSON(info, resp);
	     }
	     else{
	    	 String info="重置失败，请联系管理员";
	    	 System.out.println("重置失败，请联系管理员");
	    	 renderJSON(info, resp);
	     }
	 }
}
