package com.oraclewdp.crm.dao;

import java.util.List;

import com.oraclewdp.crm.entity.*;

public interface IRoleauthorityDAO {

    public boolean create(RoleAuthority roleauthority);

    public int updateByID(RoleAuthority roleauthority);

    public int deleteByID(Integer id);

    public List<RoleAuthority> findAll();

    public List<RoleAuthority> findAll(String column, String keyWord);

    public List<RoleAuthority> findAll(int currentPage, int lineSize, String column, String keyWord);

    public int findCount();

    public int findCount(String column, String keyWord);

}