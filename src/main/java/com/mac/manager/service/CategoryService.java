package com.mac.manager.service;

import com.mac.manager.vo.CategoryVo;

import java.util.List;

/**
 * Created by machao on 2015/2/28.
 */
public interface CategoryService {
    
    public List<CategoryVo> findList();
    
    public boolean addCategory(CategoryVo categoryVo);
    
    public boolean deleteCategory(String categoryId);
    
    public boolean updateCategory(CategoryVo categoryVo);

    public CategoryVo getById(String categoryId);
}
