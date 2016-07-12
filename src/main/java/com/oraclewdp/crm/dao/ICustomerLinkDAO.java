package com.oraclewdp.crm.dao;

import java.util.List;

import com.oraclewdp.crm.entity.*;

public interface ICustomerLinkDAO {

    public boolean create(CustomerLink customerLink);

    public int updateByID(CustomerLink customerLink);

    public int deleteByID(Integer id);

    public List<CustomerLink> findAll();

    public List<CustomerLink> findAll(String column, String keyWord);

    public List<CustomerLink> findAll(int currentPage, int lineSize, String column, String keyWord);

    public int findCount();

    public int findCount(String column, String keyWord);

}