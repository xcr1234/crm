package com.oraclewdp.crm.dao;

import java.util.List;

import com.oraclewdp.crm.entity.*;

public interface ICustomChanceDAO {

    public boolean create(CustomChance customChance);

    public int updateByID(CustomChance customChance);

    public int deleteByID(Integer id);

    public List<CustomChance> findAll();

    public List<CustomChance> findAll(String column, String keyWord);

    public List<CustomChance> findAll(int currentPage, int lineSize, String column, String keyWord);

    public int findCount();

    public int findCount(String column, String keyWord);

}