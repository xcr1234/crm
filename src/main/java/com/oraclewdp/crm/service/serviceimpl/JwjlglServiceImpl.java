package com.oraclewdp.crm.service.serviceimpl;

import java.sql.Connection;

import com.oraclewdp.crm.dao.ContactDao;
import com.oraclewdp.crm.dao.CustomerLinkDao;
import com.oraclewdp.crm.dao.UserRoleDao;
import com.oraclewdp.crm.dao.impl.ContactDaoImpl;
import com.oraclewdp.crm.dao.impl.CustomerLinkDaoImpl;
import com.oraclewdp.crm.dao.impl.UserRoleDaoImpl;
import com.oraclewdp.crm.entity.Contact;
import com.oraclewdp.crm.entity.CustomerLink;
import com.oraclewdp.crm.entity.UserRole;
import com.oraclewdp.crm.service.JwjlglService;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Pages;

public class JwjlglServiceImpl implements JwjlglService{
	private Connection connection=JdbcUtil.getInstance().getConnection();
    private ContactDao contactDao=new ContactDaoImpl(connection);
	private UserRoleDao useRoleDao=new UserRoleDaoImpl(connection);
    private CustomerLinkDao customerLinkDao=new CustomerLinkDaoImpl(connection);
    @Override
	public Pages<Contact> listJwjl(UserRole userRole) {
		int userId=userRole.getUser().getId();
		String sql="select * from contact where creator=?";
		Object[] params={userId};
		Pages<Contact> page=contactDao.findAll(Contact.class, sql, params);
		return page;
	}
    
    @Override
    public UserRole getUserRole(int userRoleId) {
    	UserRole userRole=useRoleDao.find(userRoleId, UserRole.class);
    	return userRole;
    }

    @Override
    public Pages<CustomerLink> getAllCustomerLink() {
    	Pages<CustomerLink> page=customerLinkDao.findAll(CustomerLink.class);
    	return page;
    }
    
    @Override
    public CustomerLink getCustomerLink(int linkId) {
    	CustomerLink customerLink=customerLinkDao.find(linkId, CustomerLink.class);
    	return customerLink;
    }
    
    @Override
    public int saveContact(Contact contact) {
    	int id=contactDao.save(contact);
    	return id;
    }
}
