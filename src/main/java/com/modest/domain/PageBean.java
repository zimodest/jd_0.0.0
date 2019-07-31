package com.modest.domain;

import java.util.List;

/**
 * 用于分页显示的数据
 *
 * @author modest
 * @date 2019/07/24
 */
public class PageBean<T> {
    /**
     *
     * 总记录数
     */
    private Integer totalCount;



    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     *当前页码
     */
    private Integer currentPage;

    /**
     *每页显示条数
     */
    private Integer pageSize;

    /**
     *当前页面中的集合数据
     */
    private List<T> list;

    public PageBean(int totalCount, int currentPage, int pageSize, List<T> list) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.list = list;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
