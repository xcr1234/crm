package com.oraclewdp.crm.dao;

import java.util.List;

import com.oraclewdp.crm.entity.*;

public interface IRoleauthorityDAO {

    public boolean create(Roleauthority roleauthority);

    public int updateByID(Roleauthority roleauthority);

    public int deleteByID(Integer id);

    public List<Roleauthority> findAll();

    public List<Roleauthority> findAll(String column, String keyWord);

    public List<Roleauthority> findAll(int currentPage, int lineSize, String column, String keyWord);

    public int findCount();

    public int findCount(String column, String keyWord);

}