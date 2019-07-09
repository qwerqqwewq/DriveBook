package com.zte.drive.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.drive.entity.Favorites;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.User;
import com.zte.drive.service.FavoritesService;
import com.zte.drive.service.QuestionService;
import com.zte.drive.service.UserService;
import com.zte.drive.utils.CurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

/**
 * @author wzj
 * Created by ASUS on 2019/7/5.
 */
@Controller
@RequestMapping("/fav")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;

    private static String createDate= CurrentDate.getCurrentDate();

    /**
     * 用户增加收藏
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletRequest req){
        String msg;
        int status;
        Map map=new HashMap<>();

        Integer uid=Integer.valueOf(req.getParameter("uid"));
        Favorites favorites=new Favorites();
        User user=userService.findById(uid);
        Integer questionid=Integer.valueOf(req.getParameter("questionId"));
        Question question=questionService.findById(questionid);
        favorites.setQuestion(question);
        favorites.setUser(user);
        favorites.setCreateDate(createDate);
        if(favoritesService.findByqid(user,questionid)==null){
            status=1;
            msg="成功收录";
            favoritesService.add(favorites);
            map.put("status",status);
            map.put("msg",msg);
            return JSON.toJSONString(map);
        }else{
            status=0;
            msg="收录失败";
            map.put("status",status);
            map.put("msg",msg);
            return JSON.toJSONString(map);
        }
    }

    /**
     * 用户删除收藏
     */
    @RequestMapping("dele")
    @ResponseBody
    public String dele(HttpServletRequest req){
        String msg;
        int status;
        Map map=new HashMap<>();
        Integer uid=Integer.valueOf(req.getParameter("uid"));
        User user=userService.findById(uid);
        Integer id=Integer.valueOf(req.getParameter("id"));
        int row=favoritesService.remove(user,id);
        if(row==1){
            status=1;
            msg="删除成功";
            map.put("status",status);
            map.put("msg",msg);
            return JSON.toJSONString(map);
        }else{
            status=0;
            msg="删除失败";
            map.put("status",status);
            map.put("msg",msg);
            return JSON.toJSONString(map);
        }
    }

    /**
            * 用户删除所有收藏
    */
    @RequestMapping("deleall")
    @ResponseBody
    public String deleall(HttpServletRequest req){
        String msg;
        int status;
        Map map=new HashMap<>();
        Integer uid=Integer.valueOf(req.getParameter("uid"));
        User user=userService.findById(uid);
        int row=favoritesService.removeall(user);
        if(row==1){
            status=1;
            msg="删除成功";
            map.put("status",status);
            map.put("msg",msg);
            return JSON.toJSONString(map);
        }else{
            status=0;
            msg="删除失败";
            map.put("status",status);
            map.put("msg",msg);
            return JSON.toJSONString(map);
        }
    }


    /**
     * 查询用户所有收藏
     */
    @RequestMapping("/find")
    @ResponseBody
    public String find(@RequestParam(value="pageNo",defaultValue = "1")Integer pageNo,HttpServletRequest req,ModelMap map1){
        int status;
        String msg;
        Map map=new HashMap<>();
        //Integer pageSize=1;
        //每页显示一条记录
        //分页查询
        //PageHelper.startPage(pageNo, pageSize);
        Integer uid=Integer.valueOf(req.getParameter("uid"));
        User user=userService.findById(uid);
        if(favoritesService.find(user)!=null){
            status=1;
            msg="查询成功";
            map.put("status",status);
            map.put("msg",msg);
             List<Favorites> list=favoritesService.find(user);
             map.put("list",list);
            return JSON.toJSONString(map);
        }
        //PageInfo<Favorites> pageInfo=new PageInfo<Favorites>(list);
        //map.addAttribute("pageInfo",pageInfo);
        else{
            status=0;
            msg="查询失败";
            map.put("status",status);
            map.put("msg",msg);
            return JSON.toJSONString(map);
        }
    }

    /**
     * 查询用户最近的收藏
     */
    @RequestMapping("/findNum")
    @ResponseBody
    public String findNum(HttpServletRequest req){
        int status;
        String msg;
        Map map=new HashMap<>();
        Integer num=Integer.valueOf(req.getParameter("num"));
        Integer uid=Integer.valueOf(req.getParameter("uid"));
        User user=userService.findById(uid);
        if(favoritesService.findByNum(user,num)!=null){
            status=1;
            msg="查询成功";
            List<Favorites> list=favoritesService.findByNum(user,num);
            map.put("status",status);
            map.put("msg",msg);
            map.put("list",list);
            return JSON.toJSONString(map);
        }else{
            status=0;
            msg="查询失败";
            map.put("status",status);
            map.put("msg",msg);
            return JSON.toJSONString(map);
        }
    }
}
