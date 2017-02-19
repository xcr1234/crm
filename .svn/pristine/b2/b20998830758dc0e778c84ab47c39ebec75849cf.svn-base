package com.oraclewdp.crm.util;

public class StringUtil {
 
	/**
	 * 首字母大写
	 * @author gui
	 * @throws Exception 
	 * @time 2016年7月15日 下午10:47:32
	 * @tags @param str
	 * @tags @return
	 */
  public static String firstToUpper(String str) throws Exception{
	 if(Character.isLetter(str.charAt(0))){
		 if(str.length()==1){
				return str.toUpperCase();
			 }else{
				 return str.substring(0,1).toUpperCase()+str.substring(1,str.length());
			 }
	 }else{
		throw new Exception("非法字符");
	 }
	  
 }
}
