package com.mac.manager.service;

import com.mac.common.bean.Page;
import com.mac.common.bean.PageList;
import com.mac.manager.vo.MenuVo;

/**
 * Created by machao on 2015/2/12.
 */
public interface MenuService {

    /**
     * 分页查询菜单
     *
     * @param page
     * @return
     */
    public PageList<MenuVo> findByPage(Page.Offset page, Integer categoryId);

    /**
     * 添加菜品
     * @param menuVo
     * @return
     */
    public boolean addDish(MenuVo menuVo);

    /**
     * 删除菜品
     * @param dishId
     * @return
     */
    public boolean deleteDish(String dishId);

    /**
     * 修改菜品
     * @param menuVo
     * @return
     */
    public boolean updateDish(MenuVo menuVo);
}
