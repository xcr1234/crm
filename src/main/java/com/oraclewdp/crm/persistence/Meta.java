package com.oraclewdp.crm.persistence;




import java.io.NotSerializableException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Meta {

    private Field idField;

    private Class clazz;

    private String tableName;

    private List<ColumnMeta> columnMetas;

    public List<ColumnMeta> getColumnMetas() {
        return columnMetas;
    }

    public String getTableName() {
        return tableName;
    }

    private static HashMap<Class,Meta> map = new HashMap<>();

    public Meta(Class clazz) throws PersistenceException{
        Meta meta = map.get(clazz);
        if(meta==null){
            instance(clazz);
            map.put(clazz,this);
        }else{
            this.idField = meta.idField;
            this.clazz = meta.clazz;
            this.tableName = meta.tableName;
            this.columnMetas = meta.columnMetas;
        }



    }
    private void instance(Class clazz){

         /*if(!Serializable.class.isAssignableFrom(clazz)){
            throw new PersistenceException("not Serializable :"+clazz.toString());
        }*/

        this.clazz = clazz;

        if(isSimpleType(clazz)){
            throw new PersistenceException("can not write :"+clazz);
        }





        Table table = (Table) clazz.getAnnotation(Table.class);
        if(table==null||table.value().isEmpty()){
            tableName = clazz.getSimpleName().toLowerCase();

        }else{
            tableName = table.value();
        }

        columnMetas = new ArrayList<>();



        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            Class type = field.getType();
            if(field.isAnnotationPresent(Id.class)){
                if(idField!=null){
                    throw new PersistenceException("multipart @Id field.");
                }
                idField = field;
                continue;
            }


            if(isSimpleType(type)||java.util.Date.class.isAssignableFrom(type)||java.sql.Date.class.isAssignableFrom(type)||type.equals(String.class)){


                columnMetas.add(new ColumnMeta(field,true));





            }else{
                if(!field.isAnnotationPresent(Column.class)){
                    throw new PersistenceException("not foreign key @column field:"+field.getName());
                }
                columnMetas.add(new ColumnMeta(field,false));

            }




        }

        if(idField==null){
            throw new PersistenceException("cannot find @Id field of "+clazz);
        }

    }

    public Class getClazz() {
        return clazz;
    }

    public Field getIdField() {
        return idField;
    }

    /**
     * 判断一个类型是否是基本类型
     * @param clazz
     * @return
     */
    public static boolean isSimpleType(Class clazz){
        return clazz.isPrimitive()||isWrapClass(clazz);

    }

    private static boolean isWrapClass(Class clz) {
        try {
            return ((Class) clz.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }

    public static String getColumnName(Field f){
        if(f.isAnnotationPresent(Column.class)){
            Column column = f.getAnnotation(Column.class);
            if(column.value().isEmpty()){
                return f.getName().toLowerCase();
            }else{
                return column.value();
            }

        }else{
            return  f.getName().toLowerCase();
        }
    }
}
