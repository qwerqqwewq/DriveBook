package com.zte.drive.controller;

import com.google.gson.Gson;
import com.zte.drive.entity.Type;
import com.zte.drive.service.QuestionService;
import com.zte.drive.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lxj
 * Date:2019-07-04 14:24
 * Description:<描述>
 */
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private TypeService typeService;

    @RequestMapping("/insert/do")
    @ResponseBody
    public Object insertAction() {


        Map map = new HashMap(2);
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    @RequestMapping("/insert")
    String insertPage(Model model) {
        List<Type> types = typeService.findAll();
        model.addAttribute("types", types);
        return "question/insert";
    }

    @RequestMapping("/ctc")
    String ctcPage(Type type) {
        System.out.println(type);
        return "insert";
    }
}
