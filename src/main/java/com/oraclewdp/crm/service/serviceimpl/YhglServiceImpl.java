package com.oraclewdp.crm.service.serviceimpl;

import com.oraclewdp.crm.dao.RoleDao;
import com.oraclewdp.crm.dao.UserDao;
import com.oraclewdp.crm.dao.UserRoleDao;
import com.oraclewdp.crm.dao.impl.RoleDaoImpl;
import com.oraclewdp.crm.dao.impl.UserDaoImpl;
import com.oraclewdp.crm.dao.impl.UserRoleDaoImpl;
import com.oraclewdp.crm.entity.Role;
import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.service.YhglService;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Pages;

import java.sql.Connection;

public class YhglServiceImpl implements YhglService{
  private Connection connection=JdbcUtil.getInstance().getConnection();
  private UserRoleDao userRoleDao=new UserRoleDaoImpl(connection);
  private RoleDao  roleDao=new RoleDaoImpl(connection);
  private UserDao userDao=new UserDaoImpl(connection);
	@Override
	public Pages<UserRole> listUserRole(Role role) {
		Pages<UserRole> page=null;
		String roleName=role.getName();
		int roleId=role.getId();
		//如果是管理员则全部显示
		if(roleName.equals("管理员")){
			page=userRoleDao.findAll(UserRole.class);
		}else{
			//如果是业务经理，只能查出业务员,所以需要先知道业务员的ID
	
			String sql="select * from userrole where roleId=?";
			Object[] params={3};
			page=userRoleDao.findAll(UserRole.class, sql, params);
		}
		return page;
	}
	@Override
	public UserRole getUserRole(int userId) {
		UserRole userRole=userRoleDao.find(userId, UserRole.class);
		return userRole;
	}

	@Override
		public Role getRole(int roleId) {
			Role role=roleDao.find(roleId, Role.class);
			return role;
		}
	
	//保存分配的用户
	@Override
		public boolean saveUserRole(User user, Role role) {
		 boolean flag=false;	
		 int  id=userDao.save(user);
		 if(id>0){
			 flag=true;
		 }
			user.setId(id);
			UserRole userRole=new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);
			int id2=userRoleDao.save(userRole);
			if(id2>0){
				flag=true;
			}
			return flag;
		}
	
	@Override
		public UserRole getUserRoleByUserRoleId(int userRoleId) {
			UserRole userRole=userRoleDao.find(userRoleId, UserRole.class);
			return userRole;
		}
	@Override
	public boolean updateUser(User user){
		boolean flag=userDao.update(user);
		return flag;
	}
}
