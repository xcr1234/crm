package com.oraclewdp.crm.util;

import java.security.NoSuchAlgorithmException;

public class MD5Util {

	public static String encode(String characset)
	{
		String hs="";
		String stmp="";
		 java.security.MessageDigest alg;
		try {
			alg = java.security.MessageDigest.getInstance("MD5");
			alg.update(characset.getBytes());
			byte[] digesta=alg.digest();
			 for (int n=0;n<digesta.length;n++)
			  {
			   stmp=Integer.toHexString(digesta[n] & 0XFF);
			   if (stmp.length()==1)
			   { 
				   hs=hs+"0"+stmp;
			   }
			   else
			   { 
			   hs=hs+stmp;
			   }
			  }
			 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hs;
	}
	
	
}
