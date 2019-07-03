package com.zte.drive.controller;

import com.zte.drive.entity.Mistake;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 2019/7/3.
 */
@Controller
@RequestMapping("/mistake")
public class MistakeController {
    @RequestMapping("/add")
    @ResponseBody
    public Mistake add(HttpServletRequest req){
        req.getSession().getAttribute("id");
        return null;
    }
}
