package com.zte.drive.controller;

import com.google.gson.Gson;
import com.zte.drive.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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

    @RequestMapping("/insert/do")
    @ResponseBody
    public Object insertAction() {


        Map map = new HashMap(2);
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
