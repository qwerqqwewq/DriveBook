package com.zte.drive.controller;

import com.zte.drive.entity.User;
import com.zte.drive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    private String checkLogin(HttpServletRequest req,HttpSession session) {
        String username=req.getParameter("name");
        String pwd=req.getParameter("pwd");
//      System.out.print(username);
//      System.out.print(pwd);
        // 获取用户
        User user = userService.checkLogin(username, pwd);
        // System.out.print(user);
        if ( user != null ) {
            session.setAttribute("user", user);
            return "user/success";
        }
        return "user/fail";
    }

    @RequestMapping("/regist")
    private String regist() {
        return "user/regist";
    }

    @RequestMapping("/regist/do")
    @ResponseBody
    private String doRegist(HttpServletRequest req, HttpSession session) {
            // 获取用户名和密码
            String name = req.getParameter("name");
            String pwd = req.getParameter("pwd");
            // 调用Service层进行注册
            int result = userService.regist(name, pwd);
            User user = userService.findByName(name);
            session.setAttribute("user", user);
            return "user/success";
    }
}