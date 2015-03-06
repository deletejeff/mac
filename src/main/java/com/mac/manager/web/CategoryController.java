package com.mac.manager.web;

import com.mac.manager.service.CategoryService;
import com.mac.manager.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by machao on 2015/2/28.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @ResponseBody
    @RequestMapping("/list.do")
    public Map<String, Object> findList(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<CategoryVo> list = this.categoryService.findList();
        if(list != null){
            map.put("list", list);
            map.put("msg", "操作成功!");
            map.put("success", true);
        }else{
            map.put("msg", "操作失败!");
            map.put("success", false);
        }
        return map;
    }

    @RequestMapping("/list_manager.do")
    public String findList(ModelMap map, String msg){
        List<CategoryVo> list = this.categoryService.findList();
        if(list != null){
            map.put("list", list);
            map.put("msg", msg);
            map.put("success", true);
        }else{
            map.put("msg", msg);
            map.put("success", false);
        }

        return "manager/manager_category";
    }
    
    @RequestMapping("/delete.do")
    public String deleteByCategoryId(String categoryId){
        String msg = null;
        try {
            this.categoryService.deleteCategory(categoryId);
            msg = "delete:success";
        } catch (Exception e) {
            msg = "delete:failure";
        }
        return "redirect:list_manager.do?msg=" + msg;
    }

    @RequestMapping(value = "/add.do", method = RequestMethod.GET)
    public String addCategory(){
        return "manager/category_add";
    }

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String addCategory(CategoryVo categoryVo) {
        Map<String, Object> map = new HashMap<String, Object>();
        String msg = null;
        try {
            this.categoryService.addCategory(categoryVo);
            msg = "add:success";
        } catch (Exception e) {
            msg = "add:failure";
        }
        return "redirect:list_manager.do?msg=" + msg;
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.GET)
    public String updateCategory(ModelMap map, String categoryId) {
        map.put("categoryVo", this.categoryService.getById(categoryId));
        return "manager/category_update";
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    public String updateCategory(CategoryVo categoryVo) {
        String msg = null;
        try {
            this.categoryService.updateCategory(categoryVo);
            msg = "update:success";
        } catch (Exception e) {
            msg = "update:failure";
        }
        return "redirect:list_manager.do?msg=" + msg;
    }
}
