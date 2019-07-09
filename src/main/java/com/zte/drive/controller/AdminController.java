package com.zte.drive.controller;

import com.zte.drive.entity.Admin;
import com.zte.drive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 11:17
 * Description:<描述>
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    private String login() {
        return "admin/login";

    }

    @RequestMapping("/login/do")
    private String checkLogin(HttpServletRequest req, HttpSession session) {
        String username=req.getParameter("name");
        String pwd=req.getParameter("pwd");

        // 获取管理员
        Admin admin = adminService.checkLogin(username, pwd);
        // System.out.print(user);

        if ( admin != null ) {
            session.setAttribute("admin", admin);
            return "admin/success";
        }
        return "admin/fail";
    }

    @RequestMapping("/regist")
    private String regist() {
        return "admin/regist";
    }

    @RequestMapping("/regist/do")
    @ResponseBody
    private String doRegist(HttpServletRequest req, HttpSession session) {
        // 获取用户名和密码
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        // 调用Service层进行注册
        int result = adminService.regist(name, pwd);
        Admin admin = adminService.findByName(name);
        session.setAttribute("admin", admin);
        return "admin/success";
    }





    //查询所有管理员
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Admin> list= adminService.findAll();
        model.addAttribute("list",list);
        return "findAllAdmin";
    }

    //根据id查询某一位管理员
    @RequestMapping("/findById")
    public String findById(Model model, Integer id) {
        Admin mm = adminService.findById(id);
        model.addAttribute("mm", mm);
        return "findById";
    }

    //增加一位管理员
    @RequestMapping("/addAdmin")
    public String addAdmin(Admin admin) {
        adminService.add(admin);
        return "redirect:findAll";
    }

    //根据id删除某个管理员
    @RequestMapping("/removeById")
    public String removeById(Integer id) {
        adminService.remove(id);
        return "redirect:findAll";
    }

    //修改某位管理员
    @RequestMapping("/modify")
    public String modify(Admin admin) {
        adminService.modify(admin);
        return "redirect:findAll";
    }

}

