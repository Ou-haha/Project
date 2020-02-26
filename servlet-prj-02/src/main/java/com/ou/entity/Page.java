package com.ou.entity;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
    /**
     * 封装分页结果集
     */
    //当前页
    private Integer pageIndex;

    //总页数=总记录数/每页显示记录数
    private Integer totalPage;

    //总记录数
    private Integer totalCount;

    //每页显示记录数
    private Integer pageSize;

    //每页显示的数据
    private List<T> beanList;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
