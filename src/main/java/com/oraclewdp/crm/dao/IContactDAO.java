package com.oraclewdp.crm.dao;

import java.util.List;

import com.oraclewdp.crm.entity.*;

public interface IContactDAO {

    public boolean create(Contact contact);

    public int updateByID(Contact contact);

    public int deleteByID(Integer id);

    public List<Contact> findAll();

    public List<Contact> findAll(String column, String keyWord);

    public List<Contact> findAll(int currentPage, int lineSize, String column, String keyWord);

    public int findCount();

    public int findCount(String column, String keyWord);

}