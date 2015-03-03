package com.mac.manager.web;

import com.mac.common.bean.Page;
import com.mac.common.bean.PageList;
import com.mac.manager.service.MenuService;
import com.mac.manager.vo.MenuVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    public String pageListManager(ModelMap map, Page.Offset page, String msg){
        PageList<MenuVo> pageList = this.menuService.findByPage(page, null);
        if(pageList != null){
            map.put("pageList", pageList);
            map.put("msg", msg);
            map.put("success", true);
        }else{
            map.put("msg", msg);
            map.put("success", false);
        }
        return "manager/manager_menu";
    }


    @RequestMapping(value = "/add.do", method = RequestMethod.GET)
    public String addDish(){
        return "manager/dish_add";
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public Map<String, Object> addDish(MenuVo menuVo, MultipartFile multipartFile, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        String msg = null;
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/static/upload/images");
            File file = new File(realPath + "/" +multipartFile.getOriginalFilename());
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
            menuVo.setDishImgurl("static/upload/images/" + multipartFile.getOriginalFilename());
            this.menuService.addDish(menuVo);
            map.put("success", true);
            map.put("msg", msg);
        } catch (Exception e) {
            map.put("success", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @RequestMapping("/delete.do")
    public String deleteByDishId(String dishId){
        String msg = null;
        try {
//            this.menuService.deleteDish(dishId);
            msg = "delete:success";
        } catch (Exception e) {
            msg = "delete:failure";
        }
        return "redirect:list_manager.do?msg=" + msg;
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
