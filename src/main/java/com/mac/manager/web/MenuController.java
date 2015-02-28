package com.mac.manager.web;

import com.mac.common.bean.Page;
import com.mac.common.bean.PageList;
import com.mac.manager.service.MenuService;
import com.mac.manager.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by machao on 2015/2/12.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;


    @ResponseBody
    @RequestMapping("/list.do")
    public Map<String, Object> pageList(Page.Offset page, Integer categoryId){
        Map<String, Object> map = new HashMap<String, Object>();
        PageList<MenuVo> pageList = this.menuService.findByPage(page, categoryId);
        if(pageList != null){
            map.put("pageList", pageList);
            map.put("msg", "操作成功!");
            map.put("success", true);
        }else{
            map.put("msg", "操作失败!");
            map.put("success", false);
        }
        return map;
    }

    @RequestMapping("/list_manager.do")
    public String pageListManager(ModelMap map, Page.Offset page){
        PageList<MenuVo> pageList = this.menuService.findByPage(page, null);
        if(pageList != null){
            map.put("pageList", pageList);
            map.put("msg", "操作成功!");
            map.put("success", true);
        }else{
            map.put("msg", "操作失败!");
            map.put("success", false);
        }
        return "manager/menu_manager";
    }

    @ResponseBody
    @RequestMapping("/add.do")
    public Map<String, Object> addDish(MenuVo menuVo){
        Map<String, Object> map = new HashMap<String, Object>();
        String msg = null;
        try {
            this.menuService.addDish(menuVo);
            map.put("success", true);
            map.put("msg", msg);
        } catch (Exception e) {
            map.put("success", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/delete.do")
    public Map<String, Object> deleteByDishId(String dishId){
        Map<String, Object> map = new HashMap<String, Object>();
        String msg = null;
        try {
//            this.menuService.deleteDish(dishId);
            map.put("success", true);
            map.put("msg", msg);
        } catch (Exception e) {
            map.put("success", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/update.do")
    public Map<String, Object> updateDish(MenuVo menuVo){
        Map<String, Object> map = new HashMap<String, Object>();
        String msg = null;
        try {
            this.menuService.updateDish(menuVo);
            map.put("success", true);
            map.put("msg", msg);
        } catch (Exception e) {
            map.put("success", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }
}
