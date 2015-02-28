package com.mac.manager.vo;

/**
 * Created by machao on 2015/2/28.
 */
public class CategoryVo {
    private int categoryId;
    private String categoryName;
    private Integer categoryOrder;

    public CategoryVo(int categoryId, String categoryName, Integer categoryOrder) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryOrder = categoryOrder;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
    }
}
