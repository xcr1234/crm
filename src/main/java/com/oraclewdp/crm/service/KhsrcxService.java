package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.fabric.xmlrpc.base.Data;
import com.oraclewdp.crm.dao.CustomerDao;
import com.oraclewdp.crm.dao.impl.CustomerDaoImpl;
import com.oraclewdp.crm.entity.Customer;
import com.oraclewdp.crm.entity.CustomerLink;
import com.oraclewdp.crm.util.DateUtil;
import com.oraclewdp.crm.util.JdbcUtil;
import com.oraclewdp.crm.util.Page;

public class KhsrcxService {
	
	private static SimpleDateFormat sdf;	
	private Connection conn=JdbcUtil.getInstance().getConnection();
	private CustomerDao dao=new CustomerDaoImpl(conn);
	
	public Page listByWeek(){
		Page page=new Page();
		Calendar cd=Calendar.getInstance();	
		String sql="select * from customer_link";	    	    
		JdbcUtil jdbcUtil= JdbcUtil.getInstance();
	    Connection conn=jdbcUtil.getConnection();
	    QueryRunner runner=new QueryRunner();
	    List<CustomerLink> customerList;
		
	    try {
	    	
			customerList = runner.query(conn,sql,new BeanListHandler<CustomerLink>(CustomerLink.class));
		
	    } catch (SQLException e) {
		
			e.printStackTrace();
		}
	    
	    List<CustomerLink> customerList02=new ArrayList<CustomerLink>();	   
	    for (CustomerLink customerLink :customerList02) {
			String birthday=customerLink.getBirthday();
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			 Date dbDate = null;
			try {
				
			dbDate = sdf.parse(birthday);
			
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			 Calendar c=Calendar.getInstance();
			 Date now=new Date();
			 c.setTime(now);
			 int i = c.get(Calendar.WEEK_OF_YEAR);		 
			 Calendar c2=Calendar.getInstance();			
			 dbDate.setYear(now.getYear());
			 c2.setTime(dbDate);
			 int j = c.get(Calendar.WEEK_OF_YEAR);
			 
			 if(i==j){
				 customerList02.add(customerLink);
			 }	
		}
	    
	    for (CustomerLink customerLink : customerList02) {
	    	//发送邮件 提示
		}
	    
	    PreparedStatement ppmt = null;
		try {
			ppmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    ResultSet rs = null;
		try {
			
			rs = ppmt.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    List<String> dayList=new ArrayList<String>();
	    try {
			while(rs.next()){
				String birthday=rs.getString(0);
				dayList.add(birthday);
				System.out.println(birthday);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
   
		return page;	    
	}
		
	public Page listByMouth(){
		Page page=new Page();
		Calendar cd=Calendar.getInstance();
		  
				String sql="select * from customer_link";	    			    
				JdbcUtil jdbcUtil= JdbcUtil.getInstance();
			    Connection conn=jdbcUtil.getConnection();
			    QueryRunner runner=new QueryRunner();
			    List<CustomerLink> customerList;
				try {
					customerList = runner.query(conn,sql,new BeanListHandler<CustomerLink>(CustomerLink.class));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}			    			  
			    List<CustomerLink> customerList03=new ArrayList<CustomerLink>();
			    for (CustomerLink customerLink :customerList03) {
					String birthday=customerLink.getBirthday();
					 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					 Date dbDate = null;
					try {
						dbDate = sdf.parse(birthday);
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
					 Calendar c=Calendar.getInstance();
					 Date now=new Date();					
					 c.setTime(now);				 
					 int i2=now.getMonth();					 
					 Calendar c2=Calendar.getInstance();
					 dbDate.setYear(now.getYear());
					 c2.setTime(dbDate);
					
					 int j2=dbDate.getMonth();
					 			 
					 if(i2==j2){
						 customerList03.add(customerLink);
					 }
				}
			    
			    for (CustomerLink customerLink : customerList03) {
					//发送邮件 提示
				}
			    
			    PreparedStatement ppmt = null;
				try {
					ppmt = conn.prepareStatement(sql);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			    ResultSet rs = null;
				try {
					rs = ppmt.executeQuery();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			    List<String> dayList=new ArrayList<String>();
			    try {
					while(rs.next()){
						String birthday=rs.getString(0);
						dayList.add(birthday);
						System.out.println(birthday);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		
		       return page;		
	}
	
}
