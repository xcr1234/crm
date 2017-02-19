package com.oraclewdp.crm.service.serviceimpl;

import com.oraclewdp.crm.dao.UserDao;
import com.oraclewdp.crm.dao.impl.UserDaoImpl;
import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.service.UserService;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Pages;

import java.sql.Connection;

public class UserServiceImpl implements UserService{
    private Connection connection=JdbcUtil.getInstance().getConnection();
	private UserDao userDao=new UserDaoImpl(connection);
	Pages<User> page=null;
	@Override
	public Pages<User> listUser() {
		page=userDao.findAll(User.class);
		return page;
	}
	

}
