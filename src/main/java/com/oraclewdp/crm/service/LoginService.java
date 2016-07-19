package com.oraclewdp.crm.service;


import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.util.ResultUtil;

import javax.servlet.http.HttpSession;

public interface LoginService {
	

	/**
	 * 用户登陆的方法
	 * @author gui
	 * @time 2016年7月14日 下午9:54:34
	 * @tags @param username
	 * @tags @param password
	 * @tags @param validate
	 * @tags @param session
	 * @tags @return
	 */
public ResultUtil Login(String username,String password,String validate,HttpSession session);

/**
 * 根据用户的权限获得菜单列表
 * @author gui
 * @time 2016年7月15日 上午1:16:29
 * @tags @param user
 * @tags @return
 */
public String getAuthority(User user);		
	
/**
 * 获得User
 * @author gui
 * @time 2016年7月15日 下午12:11:07
 * @tags @param id
 * @tags @return
 */
public User getUser(int id);

/**
 * 获得角色
 * @author gui
 * @time 2016年7月18日 上午2:05:20
 * @tags @param user
 * @tags @return
 */
public UserRole getRole(User user);
}
