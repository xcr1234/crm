package com.oraclewdp.crm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtils {
    private final static String  FTP="ftp.properties";
    private final static String EMAIL="mail.properties";
    private Properties prop;
    
    
	 public PropUtils(String properties) {
		prop=new Properties();
		InputStream in=null;
		if(properties.equals("FTP")){
			in=this.getClass().getClassLoader().getResourceAsStream(FTP);
			try {
				prop.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(properties.equals("EMAIL")){
			in=this.getClass().getClassLoader().getResourceAsStream(EMAIL);
			try {
				prop.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	 
	 


	public PropUtils() {
		super();
		
	}




	public String parse(String name){
		 
		 return null;
		 
	 }
	
	public String getValue(String name){
		String value=prop.getProperty(name);
		return value;
	}


	
	
}
