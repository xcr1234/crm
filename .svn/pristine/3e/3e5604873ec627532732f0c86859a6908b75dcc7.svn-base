package com.oraclewdp.crm.util;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;

import com.oraclewdp.crm.dao.DicAllDao;
import com.oraclewdp.crm.dao.impl.DicAllDaoImpl;
import com.oraclewdp.crm.entity.DicAll;
import com.oraclewdp.crm.service.DicAllService;
import com.oraclewdp.crm.service.serviceimpl.DicAllServiceImpl;

public class CodeUtil {
private  static String khCode=new DicAllServiceImpl().getDicAll("kh_code").get(0).getName();  //客户编码201607160001
private  static String glyCode=new DicAllServiceImpl().getDicAll("gly_code").get(0).getName(); //管理员的种子数
private  static String ywjlCode=new DicAllServiceImpl().getDicAll("ywjl_code").get(0).getName(); //业务经理的种子数
private  static String ywyCode=new DicAllServiceImpl().getDicAll("ywjl_code").get(0).getName(); //业务员的种子数

private  static int count=0; //当日新建的第几个客户  

private static Connection connection=JdbcUtil.getInstance().getConnection();
private static DicAllDao dicAllDao=new DicAllDaoImpl(connection);


/**
 * 获取客户编码的方法
 * @author gui
 * @time 2016年7月16日 下午4:06:11
 * @tags @return
 */
public static String getKhCode(){
	String format="yyyyMMdd";
	String dateStr="";
	Calendar cd=Calendar.getInstance();
	Date date=cd.getTime();
	dateStr=DateUtil.getDateTimeStrByFormat(date,format);
    if(khCode==""||khCode.substring(0, 8)!=dateStr){
    	khCode=dateStr+"0001";
    }else{
    	int codeTemp=Integer.parseInt(khCode)+1;
    	khCode=codeTemp+"";
    }
    boolean flag=new DicAllServiceImpl().setKhCode(khCode);
    if(flag==true){
    	return khCode;
    }
    else{
    	return "策略出错，请联系管理员";
    }
	
}

 //生成业务员的账号和密码(默认一致)
  private static String getYwyCode(){
	  String code="YWY";
	  Calendar cd=Calendar.getInstance();
	  Date date=cd.getTime();
	  String dateStr=DateUtil.getDateTimeStrByFormat(date, "yyyyMMdd");
	  int ywyCount=Integer.parseInt(ywyCode);
	  int codeTemp=10000+ywyCount;
	  code=code+dateStr+codeTemp;
	  //生成完账户之后，应该将种子数加1并存回数据库
	   ywyCode=ywyCount+1+"";
	   DicAll dicAll=new DicAllServiceImpl().getDicAll("ywy_code").get(0);
	   dicAll.setName(ywyCode);
	   boolean flag=dicAllDao.update(dicAll);
	   if(flag){
	    	return code;
	    }
	    else{
	    	return "策略出错，请联系管理员";
	    }
  }
  
 //生成业务经理的账号和密码(默认一致)
  private static String getYwjlCode(){
	  String code="YWJL";
	  Calendar cd=Calendar.getInstance();
	  Date date=cd.getTime();
	  String dateStr=DateUtil.getDateTimeStrByFormat(date, "yyyyMMdd");
	  int ywjlCount=Integer.parseInt(ywjlCode);
	  int codeTemp=10000+ywjlCount;
	  code=code+dateStr+codeTemp;
	  //生成完账户之后，应该将种子数加1并存回数据库
	   ywjlCode=ywjlCount+1+"";
	   DicAll dicAll=new DicAllServiceImpl().getDicAll("ywjl_code").get(0);
	   dicAll.setName(ywjlCode);
	   boolean flag=dicAllDao.update(dicAll);
	   if(flag==true){
	    	return code;
	    }
	    else{
	    	return "策略出错，请联系管理员";
	    }
  }
  
  //生成管理员的账号和密码(默认一致)
  private static String getGlyCode(){
	  String code="GLY";
	  Calendar cd=Calendar.getInstance();
	  Date date=cd.getTime();
	  String dateStr=DateUtil.getDateTimeStrByFormat(date, "yyyyMMdd");
	  int glyCount=Integer.parseInt(glyCode);
	  int codeTemp=10000+glyCount;
	  code=code+dateStr+codeTemp;
	  //生成完账户之后，应该将种子数加1并存回数据库
	   glyCode=glyCount+1+"";
	   DicAll dicAll=new DicAllServiceImpl().getDicAll("gly_code").get(0);
	   dicAll.setName(glyCode);
	   boolean flag=dicAllDao.update(dicAll);
	   if(flag==true){
	    	return code;
	    }
	    else{
	    	return "策略出错，请联系管理员";
	    }
  }
  
  public static String getCodeByRoleId(int roleId){
	  String code="";
	  if(roleId>3){
		  code="策略出错，请联系管理员";
	  }else{
		  if(roleId==1){
			  code=getGlyCode();
		  }
		  if(roleId==2){
			  code=getYwjlCode();
		  }
		  if(roleId==3){
			  code=getYwyCode();
		  }
	  }
	  return code;
  }
 
}
