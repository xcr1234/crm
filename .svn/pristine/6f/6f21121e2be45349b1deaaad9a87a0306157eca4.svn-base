package com.oraclewdp.crm.util;

import com.oraclewdp.crm.dao.impl.DaoImpl;
import com.oraclewdp.crm.entity.DicAll;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成项目机会编号.
 */
public class JhCodeUtil {



    public static String getJhCode(){
        StringBuffer stringBuffer = new StringBuffer("JH-");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        stringBuffer.append(simpleDateFormat.format(date));
        stringBuffer.append("-");


        //从dic_all中取出最新的code
        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        Connection connection = jdbcUtil.getConnection();
        DaoImpl<DicAll> dicAllDao = new DaoImpl<>(connection);
        DicAll codeDic = dicAllDao.find("select * from dic_all where type = 'jh_code'",DicAll.class);
        if(codeDic==null){
            stringBuffer.append(addZeroForNum(1+"",4));
            codeDic = new DicAll();
            codeDic.setName(1+"");
            codeDic.setType("jh_code");
            dicAllDao.save(codeDic);
        }else{
            Integer value = Integer.valueOf(codeDic.getName());
            stringBuffer.append(addZeroForNum((value+1)+"",4));
            codeDic.setName(value+1+"");
            dicAllDao.update(codeDic);
        }



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
