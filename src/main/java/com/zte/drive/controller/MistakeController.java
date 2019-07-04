package com.zte.drive.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.User;
import com.zte.drive.service.MistakeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
@Controller
@RequestMapping("/mistake")
public class MistakeController {

    @Autowired
    private MistakeService mistakeService;

    @RequestMapping("/add")
    @ResponseBody
    public Mistake add(HttpServletRequest req){
        req.getSession().getAttribute("id");
        return null;
    }

    /**
     * 根据用户ID查询用户错题
     * @param session
     * @return
     */
    @RequestMapping("/find")
    public String find(@RequestParam(value="pageNo",defaultValue = "1")Integer pageNo,  HttpSession session,ModelMap map){
        Integer pageSize=1;
        //每页显示一条记录
        //分页查询
        PageHelper.startPage(pageNo,pageSize);
        User user=(User)session.getAttribute("user");
        List<Mistake> list=mistakeService.findall(user);
        PageInfo<Mistake> pageInfo=new PageInfo<Mistake>(list);
        map.addAttribute("pageInfo",pageInfo);
        return "mistake/listall";
    }

    /**
     *根据用户ID 以及错题ID查询试题
     */
    @RequestMapping("/findId")
    @ResponseBody
    public Mistake findId(HttpSession session,Integer id){
        User user=(User)session.getAttribute("user");
        Mistake mistake=mistakeService.findById(user,id);
        return mistake;
    }

    /**
     * 用户根据试题内容查询试题
     */
    @RequestMapping("/findContent")
    public String findContent(@RequestParam(value="pageNo",defaultValue = "1")Integer pageNo,  HttpSession session,ModelMap map,@Param("content")String content){
        User user=(User)session.getAttribute("user");
        Integer pageSize=1;
        PageHelper.startPage(pageNo,pageSize);
        List<Mistake> list1=mistakeService.findByContent(user,content);
        PageInfo<Mistake> pageInfo1=new PageInfo<Mistake>(list1);
        map.addAttribute("page", pageInfo1);
        return "mistake/listid";
    }

    /**
     * 用户按类型查询试题
     */
    @RequestMapping("/findType")
    public String findType(@RequestParam(value="pageNo",defaultValue = "1")Integer pageNo,  HttpSession session,ModelMap map,@Param("content")String type){
        User user=(User)session.getAttribute("user");
        Integer pageSize=1;
        PageHelper.startPage(pageNo,pageSize);
        List<Mistake> list1=mistakeService.findByType(user,type);
        PageInfo<Mistake> pageInfo1=new PageInfo<Mistake>(list1);
        map.addAttribute("page", pageInfo1);
        return "mistake/listtype";
    }
}
