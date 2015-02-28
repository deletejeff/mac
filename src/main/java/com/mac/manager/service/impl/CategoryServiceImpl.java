package com.mac.manager.service.impl;

import com.mac.manager.dao.CategoryDao;
import com.mac.manager.dao.entity.CategoryEntity;
import com.mac.manager.service.CategoryService;
import com.mac.manager.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by machao on 2015/2/28.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    
    @Override
    public List<CategoryVo> findList() {
        String hql = "select new " + CategoryVo.class.getName() + "(" +
                "c.categoryId," +
                "c.categoryName," +
                "c.categoryOrder)" +
                "from CategoryEntity as c where 1=1 order by categoryOrder";
        List<Object> params = new ArrayList<Object>();
        List<CategoryVo> list = this.categoryDao.findList(CategoryVo.class, hql, params);
        return list;
    }

    @Override
    public boolean addCategory(CategoryVo categoryVo) {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(categoryVo, categoryEntity);
        this.categoryDao.save(categoryEntity);
        return true;
    }

    @Override
    public boolean deleteCategory(String categoryId) {
        this.categoryDao.deleteById(categoryId);
        return true;
    }

    @Override
    public boolean updateCategory(CategoryVo categoryVo) {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(categoryVo, categoryEntity);
        this.categoryDao.update(categoryEntity);
        return true;
    }
}
