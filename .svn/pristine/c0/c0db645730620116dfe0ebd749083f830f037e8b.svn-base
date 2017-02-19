package com.oraclewdp.crm.test;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

import com.oraclewdp.crm.service.serviceimpl.DicAllServiceImpl;
import com.oraclewdp.crm.util.DateUtil;

public class KhCodeTest {

	public  String getKhCode(String khCode){
		String format="yyyyMMdd";
		String dateStr="";
		Calendar cd=Calendar.getInstance();
		Date date=cd.getTime();
		dateStr=DateUtil.getDateTimeStrByFormat(date,format);
		String tmp=khCode.substring(0, 8);
	    if(khCode==""||!tmp.equals(dateStr)){
	    	khCode=dateStr+"0001";
	    }else{
	    	int index=Integer.parseInt(khCode.substring(8, khCode.length()))+1;
	    	DecimalFormat df=new DecimalFormat("0000");
	    	String codeSuff=df.format(index);
	    	khCode=khCode.substring(0, 8)+codeSuff;
	    }
		return khCode;
	}
	
	public static void main(String[] args) {
		System.out.println(new KhCodeTest().getKhCode("201607210014"));
	   
	}
}
