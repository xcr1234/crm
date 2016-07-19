package com.oraclewdp.crm.service.serviceimpl;

import com.oraclewdp.crm.dao.UserRoleDao;
import com.oraclewdp.crm.dao.impl.UserRoleDaoImpl;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.service.YhglService;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.PageUtil;
import com.oraclewdp.crm.util.Pages;

import java.sql.Connection;

public class YhglServiceImpl implements YhglService{
  private Connection connection=JdbcUtil.getInstance().getConnection();
  UserRoleDao userRoleDao=new UserRoleDaoImpl(connection);
	@Override
	public Pages<UserRole> listUserRole() {
		Pages<UserRole> pages=new PageUtil();
        pages=userRoleDao.findAll(UserRole.class, 10, 1);
		return pages;
	}

}
