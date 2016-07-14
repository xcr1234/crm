package com.oraclewdp.crm.persistence;


import java.lang.reflect.Field;
import java.util.HashMap;

public class SQLBuilder {

    private static HashMap<Class,String> insertMap = new HashMap<>();

    public static String insert(Meta meta){
        String sql = insertMap.get(meta.getClazz());
        if(sql == null){
            sql = insert0(meta);
            insertMap.put(meta.getClazz(),sql);
        }
        return sql;
    }

    private static String insert0(Meta meta){
        StringBuilder stringBuilder = new StringBuilder("insert into ");
        stringBuilder.append(meta.getTableName()).append('(');

        for(int i=0;i<meta.getColumnMetas().size();i++){

            ColumnMeta columnMeta = meta.getColumnMetas().get(i);
            Column column = null;
            if(columnMeta.getField().isAnnotationPresent(Column.class)){
                column = columnMeta.getField().getAnnotation(Column.class);
            }

            if(columnMeta.getField().isAnnotationPresent(Id.class)){

                continue;
            }

            if(column==null||column.value().isEmpty()){
                stringBuilder.append(columnMeta.getField().getName().toLowerCase());
            }else{
                stringBuilder.append(column.value());
            }


            if(i<meta.getColumnMetas().size()-1){
            stringBuilder.append(',');
            }

        }
        stringBuilder.append(") values(");
        for(int j=0;j<meta.getColumnMetas().size();j++){
            stringBuilder.append('?');
            if(j<meta.getColumnMetas().size()-1){
                stringBuilder.append(',');
            }

        }
        stringBuilder.append(")");


        return stringBuilder.toString();


    }

    private static HashMap<Class,String> deleteMap = new HashMap<>();

    public static String delete(Meta meta){
        String sql = deleteMap.get(meta.getClazz());
        if(sql == null){
            sql = delete0(meta);
            deleteMap.put(meta.getClazz(),sql);
        }
        return sql;
    }

    private static String delete0(Meta meta){

        StringBuilder stringBuilder = new StringBuilder("delete from ");
        stringBuilder.append(meta.getTableName());
        stringBuilder.append(" where ");

        Field idField = meta.getIdField();
        stringBuilder.append(Meta.getColumnName(idField));
        stringBuilder.append(" = ?");

        return stringBuilder.toString();


    }



    private static HashMap<Class,String> updateMap = new HashMap<>();

    public static String update(Meta meta) {
        String sql = updateMap.get(meta.getClazz());
        if(sql == null){
            sql = update0(meta);
            updateMap.put(meta.getClazz(),sql);
        }
        return sql;

    }

    private static String update0(Meta meta){
        StringBuilder stringBuilder = new StringBuilder("update ");
        stringBuilder.append(meta.getTableName());
        stringBuilder.append(" SET ");
        for(int i=0;i<meta.getColumnMetas().size();i++){
            ColumnMeta columnMeta = meta.getColumnMetas().get(i);

            stringBuilder.append(columnMeta.getName());
            stringBuilder.append(" = ?");

            if(i<meta.getColumnMetas().size()-1){
                stringBuilder.append(",");
            }

        }
        stringBuilder.append(" where ");
        stringBuilder.append(Meta.getColumnName(meta.getIdField()));
        stringBuilder.append(" = ?");
        return stringBuilder.toString();
    }

    private static HashMap<Class,String> selectMap = new HashMap();

    public static String select(Meta meta){
        String sql = selectMap.get(meta.getClazz());
        if(sql==null){
            sql = select0(meta);
            selectMap.put(meta.getClazz(),sql);
        }
        return sql;

    }

    private static String select0(Meta meta){
        StringBuilder stringBuilder = new StringBuilder("select ");
        for(int i=0;i<meta.getColumnMetas().size();i++){
            ColumnMeta columnMeta = meta.getColumnMetas().get(i);
            stringBuilder.append(columnMeta.getName());
            if(i<meta.getColumnMetas().size()-1){
                stringBuilder.append(",");
            }

        }
        stringBuilder.append(" from ");
        stringBuilder.append(meta.getTableName());
        stringBuilder.append(" where ");
        stringBuilder.append(Meta.getColumnName(meta.getIdField()));
        stringBuilder.append(" = ?");
        return stringBuilder.toString();


    }


}
