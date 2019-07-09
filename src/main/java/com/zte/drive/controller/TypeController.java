package com.zte.drive.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.zte.drive.entity.Type;
import com.zte.drive.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:helloboy
 * Date:2019-07-03 11:17
 * Description:<描述>
 */
@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    //查询所有类型
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Type> list= typeService.findAll();
        model.addAttribute("list",list);
        return "findAllType";
    }

    //根据id查询某一类型
    @RequestMapping("/findById")
    public String findById(Model model, Integer id) {
        Type mm = typeService.findById(id);
        model.addAttribute("mm", mm);
        return "findById";
    }

    //增加一个类型
    @RequestMapping("/addType")
    public String addType(Type type) {
        typeService.add(type);
        return "redirect:findAll";
    }

    //根据id删除某个类型
    @RequestMapping("/removeById")
    public String removeById(Integer id) {
        typeService.remove(id);
        return "redirect:findAll";
    }

    //修改某个类型
    @RequestMapping("/modify")
    public String modify(Type type) {
        typeService.modify(type);
        return "redirect:findAll";
    }

    @RequestMapping("http://localhost/drive/type/get/all")
    @ResponseBody
    private String getAll() {
        Map map = new HashMap<>(2);
        List<Integer> id;
        List<String> type;
        id = typeService.findAllId();
        type = typeService.findAllType();
        map.put("id", id);
        map.put("type", type);
        return JSON.toJSONString(map);
    }



}


