package com.mac.manager.web;

import com.mac.manager.service.CategoryService;
import com.mac.manager.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
