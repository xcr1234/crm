package com.oraclewdp.crm.util;

import java.util.ArrayList;
import java.util.List;

/**
 * jdbc中关于page接口的实现。
 */
public class JdbcPage<T> implements Pages<T> {

    private List<T> list;

    private int count;

    private int pageCount;

    public JdbcPage(List<T> list,int size){

        this.list = list;
        this.pageSize = size;
        count  = list.size();

        if(count%size==0){
            pageCount = count / size;
        }else {
            pageCount = count/size+1;
        }
    }

    private List<T> items;

    private int pageSize;

    private int current;

    @Override
    public void toPage(int page) {
        this.current = page;
        if(page<1||page>pageCount){
            items = new ArrayList<>();
        }else{
            int begin = (page-1)*pageSize;
            int end = begin+pageSize;
            if(end>=count){
                end = count;
            }
            items = list.subList(begin,end);
        }

    }

    @Override
    public int getAllCount() {
        return count;
    }

    @Override
    public List<T> getItems() {
        return items;
    }

    @Override
    public int getPageCount() {
        return pageCount;
    }

    @Override
    public int getCurrentPage() {
        return current;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
