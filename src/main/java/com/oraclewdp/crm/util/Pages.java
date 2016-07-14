package com.oraclewdp.crm.util;


import java.util.List;

/**
 * 表示jsp分页查询的对象
 * @param <T>
 */
public interface Pages<T> {
    public void toPage(int page);

    public int getAllCount();
    public List<T> getItems();
    public int getPageCount() ;
    public int getCurrentPage();

    public int getPageSize();
}
