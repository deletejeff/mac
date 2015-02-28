package com.mac.common.bean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yangyan
 * Date: 13-11-18
 * Time: 下午10:56
 * To change this template use File | Settings | File Templates.
 */
public class PageList<T> {


    public PageList(Page page, List<T> list) {
        this.page = page;
        this.list = list;
    }

    private Page page;
    private List<T> list;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }
}
