package com.mac.manager.vo;

/**
 * Created by machao on 2015/2/28.
 */
public class CategoryVo {
    private String categoryId;
    private String categoryName;
    private Integer categoryOrder;

    public CategoryVo() {
    }

    public CategoryVo(String categoryId, String categoryName, Integer categoryOrder) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryOrder = categoryOrder;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
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
