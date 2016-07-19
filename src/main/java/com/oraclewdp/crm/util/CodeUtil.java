package com.oraclewdp.crm.util;

import java.util.Calendar;
import java.util.Date;

import com.oraclewdp.crm.service.DicAllService;
import com.oraclewdp.crm.service.serviceimpl.DicAllServiceImpl;

public class CodeUtil {
private  static String khCode=new DicAllServiceImpl().getDicAll("kh_code").get(0).getName();  //客户编码201607160001
private  static int count=0; //当日新建的第几个客户  



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
}
