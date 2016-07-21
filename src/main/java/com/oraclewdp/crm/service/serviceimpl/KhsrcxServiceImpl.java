package com.oraclewdp.crm.service.serviceimpl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.oraclewdp.crm.dao.CustomerCareDao;
import com.oraclewdp.crm.dao.CustomerLinkDao;
import com.oraclewdp.crm.dao.DicAllDao;
import com.oraclewdp.crm.dao.UserDao;
import com.oraclewdp.crm.dao.impl.CustomerCareDaoImpl;
import com.oraclewdp.crm.dao.impl.CustomerDaoImpl;
import com.oraclewdp.crm.dao.impl.CustomerLinkDaoImpl;
import com.oraclewdp.crm.dao.impl.DicAllDaoImpl;
import com.oraclewdp.crm.dao.impl.UserDaoImpl;
import com.oraclewdp.crm.entity.CustomerCare;
import com.oraclewdp.crm.entity.CustomerLink;
import com.oraclewdp.crm.entity.DicAll;
import com.oraclewdp.crm.entity.User;
import com.oraclewdp.crm.service.KhsrcxService;
import com.oraclewdp.crm.util.DateUtil;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Pages;

public class KhsrcxServiceImpl implements KhsrcxService{
    private Connection connection=JdbcUtil.getInstance().getConnection();
	private CustomerLinkDao customerLinkDao=new CustomerLinkDaoImpl(connection);
	private DicAllDao dicAllDao=new DicAllDaoImpl(connection);
	private UserDao userDao=new UserDaoImpl(connection);
	private CustomerCareDao customerCareDao=new CustomerCareDaoImpl(connection);
	@Override
	public Pages<CustomerLink> getLinkByWeek() {
		String  sql="select *,abs(TO_DAYS(STR_TO_DATE(birthdate,'%Y-%m-%d'))-TO_DAYS(NOW())) as days"
				     +" from customer_link where  (abs(TO_DAYS(STR_TO_DATE(birthdate,'%Y-%m-%d'))-TO_DAYS(NOW())) < ?)";
		Object[] params={7};
		Pages<CustomerLink> page=customerLinkDao.findAll(CustomerLink.class, sql,params);
		return page;
	}

	@Override
	public Pages<CustomerLink> getLinkByMonth() {
		String  sql="select *,abs(TO_DAYS(STR_TO_DATE(birthdate,'%Y-%m-%d'))-TO_DAYS(NOW())) as days"
			     +" from customer_link where  (abs(TO_DAYS(STR_TO_DATE(birthdate,'%Y-%m-%d'))-TO_DAYS(NOW())) < ?)";
		Object[] params={30};
		Pages<CustomerLink> page=customerLinkDao.findAll(CustomerLink.class, sql, params);
		return page;
	}
	
	@Override
	public CustomerLink getLink(int linkId) {
		CustomerLink customerLink=customerLinkDao.find(linkId, CustomerLink.class);
		return customerLink;
	}
	
	@Override
	public DicAll getEmailContent() {
		String sql="select * from dic_all where type=?";
		Object[] params={"srzf"};
		List<DicAll> list=dicAllDao.listAll(DicAll.class, sql, params);
		Random random=new Random();
		int rand=random.nextInt(list.size())+1;
		return list.get(rand);
	}

	@Override
	public User getUser(int id) {
		User user=userDao.find(id, User.class);
		return user;
	}
	
	@Override
	public int saveCustomerCare(CustomerCare customerCare) {
		int  flag=customerCareDao.save(customerCare);
		return flag;
	}
}
