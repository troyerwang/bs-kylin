package com.kylinteam.base.controller.resp;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageBean<T> {

    private int current;
    private int rowCount;
    private List<T> rows;
    private long total;

    public PageBean() {
    }

    public PageBean(Page<T> pageInfo) {
        this.current = pageInfo.getNumber() + 1;
        this.rowCount = pageInfo.getSize();
        this.rows = pageInfo.getContent();
        this.total = pageInfo.getTotalElements();
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
