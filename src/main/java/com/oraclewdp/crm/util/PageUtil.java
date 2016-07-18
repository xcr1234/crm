package com.oraclewdp.crm.util;

import java.util.List;


public class PageUtil implements Pages {
    private int current = 1;
    private int count;
    private List list;
    private int pageCount;

    @Override
    public void toPage(int page) {
        this.current = page;
    }


    @Override
    public int getAllCount() {
        return count;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    

    public int getCurrent() {
		return current;
	}


	public int getCount() {
		return count;
	}


	public List getList() {
		return list;
	}


	@Override
    public List getItems() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public int getCurrentPage() {
        return current;
    }

    @Override
    public int getPageSize() {
        return 10;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "current=" + current +
                ", count=" + count +
                ", list=" + list +
                ", pageCount=" + pageCount +
                '}';
    }
}
