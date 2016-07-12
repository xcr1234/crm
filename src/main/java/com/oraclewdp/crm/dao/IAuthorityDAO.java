package com.oraclewdp.crm.dao;

import java.util.List;

import com.oraclewdp.crm.entity.*;

public interface IAuthorityDAO {

    public boolean create(Authority authority);

    public int updateByID(Authority authority);

    public int deleteByID(Integer id);

    public List<Authority> findAll();

    public List<Authority> findAll(String column, String keyWord);

    public List<Authority> findAll(int currentPage, int lineSize, String column, String keyWord);

    public int findCount();

    public int findCount(String column, String keyWord);

}