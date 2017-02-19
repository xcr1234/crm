package com.oraclewdp.crm.service.serviceimpl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.CustomerCareDao;
import com.oraclewdp.crm.dao.UserRoleDao;
import com.oraclewdp.crm.dao.impl.CustomerCareDaoImpl;
import com.oraclewdp.crm.dao.impl.UserRoleDaoImpl;
import com.oraclewdp.crm.entity.CustomerCare;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.service.KhghService;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Pages;

public class KhghServiceImpl implements KhghService{
 private Connection connection=JdbcUtil.getInstance().getConnection();
 private CustomerCareDao customerCareDao=new CustomerCareDaoImpl(connection);
 private UserRoleDao userRoleDao=new UserRoleDaoImpl(connection);
	@Override
	public Pages<CustomerCare> listCustomerCare(UserRole userRole) {
		Pages<CustomerCare> page=null;
		if(userRole.getRole().getName().equals("管理员")){
		  page=customerCareDao.findAll(CustomerCare.class);
		}else{
			String sql="select * from customer_care where creator=?";
			Object[] params={userRole.getUser().getId()};
			page=customerCareDao.findAll(CustomerCare.class, sql, params);
		}
		return page;
	}

	@Override
		public UserRole getUserRole(int userRoleId) {
			UserRole userRole=userRoleDao.find(userRoleId, UserRole.class);
			return userRole;
		}
}
