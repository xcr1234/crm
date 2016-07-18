package com.oraclewdp.crm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    //获取时间字符串的方法
    public static String  getTimeStr(Date date){
        String str=null;
        DateFormat df=null;
        df=DateFormat.getTimeInstance();
        str=df.format(date);
        return str;
    }

    //获取日期字符串的方法
    public static String  getDateTimeStr(Date date){
        String str=null;
        DateFormat df=DateFormat.getDateTimeInstance();
        str=df.format(date);
        return str;
    }

    //获取中文的日期字符串方法
    public static String getCNDateStr(Date date){
        String str=null;
        DateFormat df=DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        str=df.format(date);
        return str;
    }
    //获取中文的时间字符串方法
    public static String getCnTimeStr(Date date){
        String str=null;
        DateFormat df=DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL,Locale.CHINA);
        str=df.format(date);
        return str;
    }

    //获取自定义日期时间字符串方法

    public static String getDateTimeStrByFormat(Date date,String format){
        String str=null;
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        str=sdf.format(date);
        return str;

    }

    /******************下面是通过指定格式字符串获取时间的方法************/
    //通过指定日期格式的字符串获取日期
    public static Date getDate(String str){
        Date date=null;
        DateFormat df=DateFormat.getDateInstance();
        try {
            date=df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("@@格式化日期异常@@");
        }
        return date;
    }

    //自定义格式获取日期的方法
    public static Date getDateByFormat(String str){
        Date date=null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date=sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("@@获取自定义格式日期异常@@");
        }
        return date;
    }

}