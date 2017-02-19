package com.oraclewdp.crm.dao.impl;

import com.oraclewdp.crm.dao.Dao;
import com.oraclewdp.crm.persistence.*;
import com.oraclewdp.crm.util.Pages;
import javafx.beans.binding.ObjectExpression;

import java.lang.reflect.Field;
import java.sql.*;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by user on 2016/7/13.
 */
public class DaoImpl<E> implements Dao<E> {

    private Connection connection;

    public DaoImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * insert-如果增加成功返回生成的Id,失败返回null.
     *
     * @param elem 要插入的对象
     * @return
     */
    @Override
    public Integer save(E elem) {

        if (elem == null) {
            throw new NullPointerException("cannot save null!");
        }

        Class<?> clazz = elem.getClass();

        Meta meta = new Meta(clazz);

        String sql = SQLBuilder.insert(meta);

        System.out.println(sql);

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for (int i = 0; i < meta.getColumnMetas().size(); i++) {
                ColumnMeta columnMeta = meta.getColumnMetas().get(i);

                preparedStatement.setObject(i + 1, ColumnMeta.getValue(columnMeta, elem));
            }

            int a = preparedStatement.executeUpdate();
            if (a <= 0) {
                return null;
            }
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {

                return resultSet.getInt(1);
            } else {
                return null;
            }


        } catch (SQLException e) {
            throw new PersistenceException("执行SQL语句失败", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
            }
        }


    }

    @Override
    public boolean delete(E e) {

        if (e == null) {
            throw new NullPointerException("cannot delete null!");
        }

        Meta meta = new Meta(e.getClass());

        String sql = SQLBuilder.delete(meta);
        System.out.println(sql);

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, FieldInvoker.get(meta.getIdField(), e));
            int i = preparedStatement.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            throw new PersistenceException("执行SQL语句失败", ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
        }


    }

    @Override
    public boolean update(E e) {
        if (e == null) {
            throw new NullPointerException("cannot delete null!");
        }

        Meta meta = new Meta(e.getClass());

        String sql = SQLBuilder.update(meta);
        System.out.println(sql);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int i = 0;
            for (; i < meta.getColumnMetas().size(); i++) {
                ColumnMeta columnMeta = meta.getColumnMetas().get(i);
                preparedStatement.setObject(i + 1, ColumnMeta.getValue(columnMeta, e));
            }
            preparedStatement.setObject(i + 1, FieldInvoker.get(meta.getIdField(), e));
            int r = preparedStatement.executeUpdate();
            return r > 0;

        } catch (SQLException ex) {
            throw new PersistenceException("执行SQL语句失败", ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
        }

    }
    public int maxRecursion = 10; //最大递归级别

    /**
     *
     *
     *
     * @param id
     * @param clazz
     * @return
     */
    @Override
    public E find(Integer id, Class<E> clazz) {
        if (id == null || clazz == null) {
            throw new NullPointerException("cannot find null!");
        }
        return (E) find0(id,clazz,0);
    }


    private Object find0(Integer id, Class<?> clazz,int m) {
        if(id==null||clazz==null){
            return null;
        }
        Meta meta = new Meta(clazz);
        String sql = SQLBuilder.select(meta);
        System.out.println(sql);

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                return null;
            }

            Object e = clazz.newInstance();
            for(int i=0;i<meta.getColumnMetas().size();i++){
                ColumnMeta columnMeta = meta.getColumnMetas().get(i);
                String name = Meta.getColumnName(columnMeta.getField());
                Object objId = resultSet.getObject(name);
                if(columnMeta.isBase()){
                    FieldInvoker.set(columnMeta.getField(),e,objId);
                }else{
                    //递归查询
                    if(m>=maxRecursion){
                        FieldInvoker.set(columnMeta.getField(),e,null);
                    }else{
                        Object obj = find0((Integer) objId,columnMeta.getField().getType(),1);
                        FieldInvoker.set(columnMeta.getField(),e,obj);
                    }


                }

            }

            FieldInvoker.set(meta.getIdField(),e,id);
            return e;
        } catch (SQLException ex) {
            throw new PersistenceException("执行SQL语句失败", ex);
        } catch (ReflectiveOperationException e) {
            throw new PersistenceException("反射创建对象失败", e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException ex) {
            }

        }


    }


    @Override
    public E find(String sql, Class<E> clazz) {
        if (sql == null || clazz == null) {
            throw new NullPointerException("cannot find null!");
        }
        Meta meta = new Meta(clazz);

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                return null;
            }

            E e = clazz.newInstance();
            for(int i=0;i<meta.getColumnMetas().size();i++){
                ColumnMeta columnMeta = meta.getColumnMetas().get(i);
                String name = Meta.getColumnName(columnMeta.getField());
                Object objId = resultSet.getObject(name);
                if(columnMeta.isBase()){
                    FieldInvoker.set(columnMeta.getField(),e,objId);
                }else{

                    Object obj = find0((Integer) objId,columnMeta.getField().getType(),1);
                    FieldInvoker.set(columnMeta.getField(),e,obj);
                }

            }


            return e;
        } catch (SQLException ex) {
            throw new PersistenceException("执行SQL语句失败", ex);
        } catch (ReflectiveOperationException e) {
            throw new PersistenceException("反射创建对象失败", e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public Pages<E> findAll(Class<E> clazz, int size, int offset) {
        return null;
    }

    @Override
    public Pages<E> findAll(Class<E> clazz, String sql, int size, int offset) {
        return null;
    }
}
