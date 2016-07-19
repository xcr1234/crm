package com.oraclewdp.crm.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 提供一个临时的bean对象，也就是没有在entity中声明的对象
 */
public class BeanObject {

    private Map<String,Object> beanMap = new ConcurrentHashMap<>();

    public Object get(String name){
        return beanMap.get(name);
    }

    public void set(String name,Object value){
        beanMap.put(name,value);
    }


    public static List<BeanObject> list(String sql, Connection connection,Object ... params){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                preparedStatement.setObject(i+1,params[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<BeanObject> list = new ArrayList<>();
            while (resultSet.next()){
                BeanObject beanObject = new BeanObject();
                ResultSetMetaData metaData = resultSet.getMetaData();
                for(int i=0;i<metaData.getColumnCount();i++){
                    beanObject.set(metaData.getColumnName(i+1),resultSet.getObject(i+1));
                }
                list.add(beanObject);

            }

            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {}
            }
        }
        return null;

    }

    public static BeanObject find(String sql,Connection connection,Object ... params){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                preparedStatement.setObject(i+1,params[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                BeanObject beanObject = new BeanObject();
                ResultSetMetaData metaData = resultSet.getMetaData();
                for(int i=0;i<metaData.getColumnCount();i++){
                    beanObject.set(metaData.getColumnName(i+1),resultSet.getObject(i+1));
                }
                return beanObject;
            }else{
                return null;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {}
            }
        }

    }





}
