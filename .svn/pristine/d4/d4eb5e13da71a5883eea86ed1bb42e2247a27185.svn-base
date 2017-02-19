package com.oraclewdp.crm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成项目机会编号.
 */
public class JhCodeUtil {

    private static Integer code = 1;

    public static String getJhCode(){
        StringBuffer stringBuffer = new StringBuffer("JH-");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        stringBuffer.append(simpleDateFormat.format(date));
        stringBuffer.append("-");
        stringBuffer.append(addZeroForNum(code+"",4));

        return stringBuffer.toString();



    }

    private static String addZeroForNum(String str,int strLength) {
        int strLen =str.length();
        if (strLen <strLength) {
            while (strLen< strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);//左补0

                str= sb.toString();
                strLen= str.length();
            }
        }

        return str;
    }
}
