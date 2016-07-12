package com.oraclewdp.crm.dao;

import java.util.List;

import com.oraclewdp.crm.entity.*;

public interface IDicAllDAO {

    public boolean create(DicAll dicAll);

    public int updateByID(DicAll dicAll);

    public int deleteByID(Integer id);

    public List<DicAll> findAll();

    public List<DicAll> findAll(String column, String keyWord);

    public List<DicAll> findAll(int currentPage, int lineSize, String column, String keyWord);

    public int findCount();

    public int findCount(String column, String keyWord);

}