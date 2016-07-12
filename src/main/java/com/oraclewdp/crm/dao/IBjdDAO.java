package com.oraclewdp.crm.dao;

import java.util.List;

import com.oraclewdp.crm.entity.*;

public interface IBjdDAO {

    public boolean create(Bjd bjd);

    public int updateByID(Bjd bjd);

    public int deleteByID(Integer id);

    public List<Bjd> findAll();

    public List<Bjd> findAll(String column, String keyWord);

    public List<Bjd> findAll(int currentPage, int lineSize, String column, String keyWord);

    public int findCount();

    public int findCount(String column, String keyWord);

}