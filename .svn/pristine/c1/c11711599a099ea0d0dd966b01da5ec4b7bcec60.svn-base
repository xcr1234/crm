package com.oraclewdp.crm.persistence;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 把属性值注入到field当中去，或者从field中提取属性值
 */
public class FieldInvoker {

    public static void set(Field field,Object object,Object value){
        //通过set方法注入
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(),field.getDeclaringClass());
            Method method = propertyDescriptor.getWriteMethod();
            method.invoke(object,value);
        } catch (Exception e) {
            throw new PersistenceException("反射出错",e);
        }


    }

    public static Object get(Field field,Object object){

        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(),field.getDeclaringClass());
            Method method = propertyDescriptor.getReadMethod();
            return method.invoke(object);
        }catch (Exception e){
            throw new PersistenceException("反射出错",e);
        }
    }

}
