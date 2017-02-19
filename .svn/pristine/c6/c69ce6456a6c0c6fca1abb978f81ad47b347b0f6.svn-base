package com.oraclewdp.crm.dao;


import com.oraclewdp.crm.util.Pages;

import java.util.List;

/**
 * 数据库的基本dao
 * @param <E>
 */
public interface Dao<E> {
    /**
     * insert-如果增加成功返回生成的Id,失败返回null.
     * 在插入之前如果有外键，需要把外键的那个对象先插入.
     *
     * @param e
     * @return
     */
    public Integer save(E e);

    public boolean delete(E e);

    public boolean update(E e);

    public E find(Integer id,Class<E> clazz);

    public E find(String sql,Class<E> clazz);


    public Pages<E> findAll(Class<E> clazz,int size, int offset);

    public Pages<E> findAll(Class<E> clazz,String sql,int size, int offset);


}
