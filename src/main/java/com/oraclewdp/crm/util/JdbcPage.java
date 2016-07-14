package com.oraclewdp.crm.util;

import java.util.List;

/**
 * Created by user on 2016/7/14.
 */
public class JdbcPage<T> implements Pages<T> {
    @Override
    public void toPage(int page) {

    }

    @Override
    public int getAllCount() {
        return 0;
    }

    @Override
    public List<T> getItems() {
        return null;
    }

    @Override
    public int getPageCount() {
        return 0;
    }

    @Override
    public int getCurrentPage() {
        return 0;
    }

    @Override
    public int getPageSize() {
        return 0;
    }
}
