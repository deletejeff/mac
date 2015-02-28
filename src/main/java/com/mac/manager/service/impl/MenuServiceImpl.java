package com.mac.manager.service.impl;

import com.mac.common.bean.Page;
import com.mac.common.bean.PageList;
import com.mac.manager.dao.MenuDao;
import com.mac.manager.dao.entity.MenuEntity;
import com.mac.manager.service.MenuService;
import com.mac.manager.vo.MenuVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by machao on 2015/2/12.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public PageList<MenuVo> findByPage(Page.Offset page, Integer categoryId) {
        String hql = "select new " + MenuVo.class.getName() +" (" +
                "m.dishId," +
                "m.dishName," +
                "m.dishEnglishName," +
                "m.dishPrice," +
                "m.dishDescription," +
                "m.spicyLevel," +
                "m.hotLevel," +
                "m.dishImgurl," +
                "m.dishPrice2," +
                "m.dishOrigin," +
                "m.dishCapacity," +
                "m.dishUnit," +
                "m.dishGroup," +
                "m.dishOrder," +
                "c.categoryId," +
                "c.categoryName," +
                "c.categoryOrder) " +
                "from MenuEntity as m " +
                "left join m.categoryByCategoryId c " +
                "where 1=1 ";
        List<Object> params = new ArrayList<Object>();
        if(categoryId != null){
            params.add(categoryId);
            hql += " and m.categoryByCategoryId.categoryId = ? ";
        }
        hql += " order by m.categoryByCategoryId.categoryOrder";
        PageList<MenuVo> pageList = this.menuDao.findPageList(page, MenuVo.class, hql, params);
        return pageList;
    }

    @Override
    public boolean addDish(MenuVo menuVo) {
        MenuEntity menuEntity = new MenuEntity();
        BeanUtils.copyProperties(menuVo, menuEntity);
        this.menuDao.save(menuEntity);
        return true;
    }

    @Override
    public boolean deleteDish(String dishId) {
        this.menuDao.deleteById(dishId);
        return true;
    }

    @Override
    public boolean updateDish(MenuVo menuVo) {
        MenuEntity menuEntity = new MenuEntity();
        BeanUtils.copyProperties(menuVo, menuEntity);
        this.menuDao.update(menuEntity);
        return true;
    }
}
