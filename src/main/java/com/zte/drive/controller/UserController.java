package com.zte.drive.controller;

import com.alibaba.fastjson.JSON;
import com.zte.drive.entity.User;
import com.zte.drive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:helloboy
 * Date:2019-07-03 17:31
 * Description:<描述>
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    private String login() {
        return "user/login";
    }

    @RequestMapping("/login/do")
    @ResponseBody
    private String checkLogin(HttpServletRequest req,HttpSession session) {
        Map map = new HashMap<>(3);
        int uid;
        int status;
        String msg;
        String username=req.getParameter("name");
        String pwd=req.getParameter("pwd");
//      System.out.print(username);
//      System.out.print(pwd);
        // 获取用户
        User user = userService.checkLogin(username, pwd);
        // System.out.print(user);
        if ( user != null ) {
            session.setAttribute("user", user);
            uid = user.getId();
            status = 1;
            msg = "登录成功！";
            map.put("uid", uid);
            map.put("status", status);
            map.put("msg", msg);
            return JSON.toJSONString(map);
        }
        uid = 0;
        status = 0;
        msg = "用户名不存在或密码不正确！";
        map.put("uid", uid);
        map.put("status", status);
        map.put("msg", msg);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/regist")
    private String regist() {
        return "user/regist";
    }

    @RequestMapping("/regist/do")
    @ResponseBody
    private String doRegist(HttpServletRequest req, HttpSession session) {
        Map map = new HashMap<>(2);
        int status;
        String msg;
        // 获取用户名和密码
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        if ( name.length() == 0 || pwd.length() == 0  ) {
            status = 2;
            msg = "未输入用户名或密码！";
            map.put("status", status);
            map.put("msg", msg);
            return JSON.toJSONString(map);
        }
        // 调用Service层进行注册
        int result = userService.regist(name, pwd);
        // 用户名已存在
        if ( result == 0 ) {
            status = 0;
            msg = "用户名已存在！";
            map.put("status", status);
            map.put("msg", msg);
            return JSON.toJSONString(map);
        }
        User user = userService.findByName(name);
        session.setAttribute("user", user);
        status = 1;
        msg = "注册成功！";
        map.put("status", status);
        map.put("msg", msg);
        return JSON.toJSONString(map);
    }
}