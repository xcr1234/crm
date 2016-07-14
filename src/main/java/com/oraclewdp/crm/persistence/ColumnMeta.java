package com.oraclewdp.crm.persistence;



import java.lang.reflect.Field;

public class ColumnMeta {

    private Field field;

    private boolean isBase;

    private String name;

    public String getName() {
        return name;
    }

    public ColumnMeta(Field field, boolean isBase) {
        this.field = field;
        this.isBase = isBase;

        this.name = Meta.getColumnName(field);



    }

    public Field getField() {
        return field;
    }

    public boolean isBase() {
        return isBase;
    }

    public static Object getValue(ColumnMeta columnMeta,Object elem){
        if(columnMeta.isBase()) {
            return FieldInvoker.get(columnMeta.getField(), elem);
        }
        Object obj = FieldInvoker.get(columnMeta.getField(),elem);
        if(obj==null){
           return null;
        }else{
            Class clz = obj.getClass();
            Meta clzMeta = new Meta(clz);
            return  FieldInvoker.get(clzMeta.getIdField(),obj);
        }

    }
}
