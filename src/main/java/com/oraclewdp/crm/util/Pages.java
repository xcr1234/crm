package com.oraclewdp.crm.util;


import java.util.List;

/**
 * 表示jsp分页查询的对象
 * @param <T>
 */
public interface Pages<T> {
    public void toPage(int page);  //

    public int getAllCount(); //总页数
    public List<T> getItems(); 
    public int getPageCount() ;  //总条数
    public int getCurrentPage(); //当前页面

    public int getPageSize(); // 当前页面数
}
