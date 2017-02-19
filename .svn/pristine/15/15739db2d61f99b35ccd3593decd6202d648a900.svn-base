package com.oraclewdp.crm.dao;

import java.util.List;

import com.oraclewdp.crm.entity.*;

public interface ICustomerDAO {

    public boolean create(Customer customer);

    public int updateByID(Customer customer);

    public int deleteByID(Integer id);

    public List<Customer> findAll();

    public List<Customer> findAll(String column, String keyWord);

    public List<Customer> findAll(int currentPage, int lineSize, String column, String keyWord);

    public int findCount();

    public int findCount(String column, String keyWord);

}