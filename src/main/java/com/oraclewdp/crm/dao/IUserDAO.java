package com.oraclewdp.crm.dao;

import java.util.List;

import com.oraclewdp.crm.entity.*;

public interface IUserDAO {

    public boolean create(User user);

    public int updateByID(User user);

    public int deleteByID(Integer id);

    public List<User> findAll();

    public List<User> findAll(String column, String keyWord);

    public List<User> findAll(int currentPage, int lineSize, String column, String keyWord);

    public int findCount();

    public int findCount(String column, String keyWord);

}