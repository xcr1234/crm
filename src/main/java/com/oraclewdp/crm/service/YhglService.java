package com.oraclewdp.crm.service;

import java.util.List;

import com.oraclewdp.crm.entity.Role;
import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.util.Pages;

public interface YhglService {

	public Pages<UserRole> listUserRole(Role role);
	
	public UserRole getUserRole(int userId);
	
	public Role getRole(int roleId);
	 
	public boolean saveUserRole(User user,Role role);
	
	public UserRole getUserRoleByUserRoleId(int userRoleId);
    
	public boolean updateUser(User user);
}
