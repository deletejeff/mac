package com.mac.manager.web;

import com.mac.common.bean.Page;
import com.mac.common.bean.PageList;
import com.mac.common.utils.RandomUtil;
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
    public Map<String, Object> pageList(Page.Offset page, String categoryId){
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
    
    
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String addDish(MenuVo menuVo, MultipartFile multipartFile, HttpServletRequest request) {
        String msg = null;
        try {
            if(multipartFile.getSize()>0){
                String realPath = request.getSession().getServletContext().getRealPath("/static/upload/images");
                String fileType = multipartFile.getOriginalFilename().substring(
                        multipartFile.getOriginalFilename().lastIndexOf(".")+1
                );
                String fileName = RandomUtil.getRandomFileName() + "." + fileType;
                File file = new File(realPath + "/" + fileName);
                FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
                menuVo.setDishImgurl("static/upload/images/" + fileName);
            }
            this.menuService.addDish(menuVo);
            msg = "add:success";
        } catch (Exception e) {
            msg = "add:failure";
        }
        return "redirect:list_manager.do?msg=" + msg;
    }

    @RequestMapping("/delete.do")
    public String deleteByDishId(String dishId, HttpServletRequest request){
        String msg = null;
        try {
            MenuVo menuVo = this.menuService.getById(dishId);
            String realPath = request.getSession().getServletContext().getRealPath("/");
            String filePath = realPath + menuVo.getDishImgurl();//文件的绝对路径
            this.menuService.deleteDish(dishId);
            File file = new File(filePath);
            if(file.exists()) {
                file.delete();
            }
            msg = "delete:success";
        } catch (Exception e) {
            msg = "delete:failure";
        }
        return "redirect:list_manager.do?msg=" + msg;
    }


    @RequestMapping(value = "/update.do", method = RequestMethod.GET)
    public String updateCategory(ModelMap map, String dishId) {
        map.put("menuVo", this.menuService.getById(dishId));
        return "manager/dish_update";
    }


    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    public String updateDish(MenuVo menuVo, MultipartFile multipartFile, HttpServletRequest request){
        String msg = null;
        try {
            if(multipartFile.getSize()>0){
                String realPath = request.getSession().getServletContext().getRealPath("/static/upload/images");
                String fileType = multipartFile.getOriginalFilename().substring(
                        multipartFile.getOriginalFilename().lastIndexOf(".") + 1
                );
                String fileName = RandomUtil.getRandomFileName() + "." + fileType;
                File file = new File(realPath + "/" + fileName);
                FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
                menuVo.setDishImgurl("static/upload/images/" + fileName);
            }
            this.menuService.updateDish(menuVo);
            msg = "update:success";
        } catch (Exception e) {
            msg = "update:failure";
        }
        return "redirect:list_manager.do?msg=" + msg;
    }
    
    @ResponseBody
    @RequestMapping("/delete_img.do")
    public Map<String, Object> deleteImg(String dishId, HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            MenuVo menuVo = this.menuService.getById(dishId);
            String realPath = request.getSession().getServletContext().getRealPath("/");
            String filePath = realPath + menuVo.getDishImgurl();//文件的绝对路径
            menuVo.setDishImgurl("");
            this.menuService.updateDish(menuVo);
            File file = new File(filePath);
            if(file.exists()) {
                file.delete();
            }
            map.put("success", true);
            map.put("msg" , "删除成功!");
        }catch (Exception e){
            System.out.println(e.getMessage());
            map.put("success" , false);
            map.put("msg" , "删除失败!");
        }
        return map;
    }
}
