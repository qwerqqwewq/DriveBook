package com.zte.drive.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.drive.dao.QuestionDao;
import com.zte.drive.dao.TypeDao;
import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.User;
import com.zte.drive.service.*;
import com.zte.drive.utils.CurrentDate;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  wzj
 * Created by ASUS on 2019/7/3.
 */
@Controller
@RequestMapping("/mistake")
public class MistakeController {

    @Autowired
    private UserService userService;
    @Autowired
    private MistakeService mistakeService;
    @Autowired
    private QuestionService questionService;

    private static String createDate= CurrentDate.getCurrentDate();
    /**
     * 用户增加错题
     * @param req
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletRequest req){
        Map map=new HashMap<>();
        int status;
        String msg;
        Integer uid=Integer.valueOf(req.getParameter("uid"));
        User user=userService.findById(uid);

        Mistake mistake=new Mistake();
        mistake.setUser(user);
        mistake.setCreateDate(createDate);
        Integer questionId=Integer.valueOf(req.getParameter("questionId"));
        //设置Question
        Question question=questionService.findById(questionId);
        mistake.setQuestion(question);

        if(mistakeService.findByqid(user,questionId) == null){
            status=1;
            msg="收录成功";
            map.put("status",status);
            map.put("msg",msg);
            mistakeService.add(mistake);
            return JSON.toJSONString(map);
        }else{
            status=0;
            msg="收录失败已有该试题";
            map.put("status",status);
            map.put("msg",msg);
            return JSON.toJSONString(map);
        }
    }

    /**
     *用户删除一条错题
     */
    @RequestMapping("/dele")
    @ResponseBody
    public String dele(HttpServletRequest req){
        Map map=new HashMap<>();
        int status;
        String msg;
        Integer uid=Integer.valueOf(req.getParameter("uid"));
        User user=userService.findById(uid);
        Integer id=Integer.valueOf(req.getParameter("id"));
        int row=mistakeService.remove(user,id);
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
     *用户删除一条错题
     */
    @RequestMapping("/deleall")
    @ResponseBody
    public String deleall(HttpServletRequest req){
        Map map=new HashMap<>();
        int status;
        String msg;
        Integer uid=Integer.valueOf(req.getParameter("uid"));
        User user=userService.findById(uid);
        int row=mistakeService.removeall(user);
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
     * 根据用户ID查询用户所有错题
     * @param req
     * @return
     */
    @RequestMapping("/find")
    @ResponseBody
    public String find(@RequestParam(value="pageNo",defaultValue = "1")Integer pageNo,  HttpServletRequest req,ModelMap map1){
        int status;
        String msg;
        Map map=new HashMap<>();
        //Integer pageSize=1;
        //每页显示一条记录
        //分页查询
        //PageHelper.startPage(pageNo,pageSize);
        Integer id=Integer.valueOf(req.getParameter("uid"));
        User user=userService.findById(id);
        if(mistakeService.findall(user)!=null){
            status=1;
            msg="查询成功";
            List<Mistake> list=mistakeService.findall(user);
            map.put("status",status);
            map.put("msg",msg);
            map.put("list",list);
            return JSON.toJSONString(map);
        }
        //PageInfo<Mistake> pageInfo=new PageInfo<Mistake>(list);
        //map1.addAttribute("pageInfo",pageInfo);
        else{
            status=0;
            msg="查询失败";
            return JSON.toJSONString(map);
        }
    }

    /**
     *根据用户ID 以及错题ID查询试题
     */
    @RequestMapping("/findId")
    @ResponseBody
    public String findId(HttpServletRequest req){
        String msg;
        int status;
        Map map=new HashMap<>();
        Integer uid=Integer.valueOf(req.getParameter("uid"));
        User user=userService.findById(uid);
        Integer id=Integer.valueOf(req.getParameter("id"));
        if(mistakeService.findById(user,id)!=null){
            status=1;
            msg="查询成功";
            Mistake mistake=mistakeService.findById(user,id);
            map.put("status",status);
            map.put("msg",msg);
            map.put("mistake",mistake);
            return JSON.toJSONString(map);
        }else{
            status=0;
            msg="查询失败";
            map.put("status",status);
            map.put("msg",msg);
            return JSON.toJSONString(map);
        }
    }

    /**
     * 用户根据试题内容查询试题
     */
    @RequestMapping("/findContent")
    @ResponseBody
    public String findContent(@RequestParam(value="pageNo",defaultValue = "1")Integer pageNo,ModelMap map1,HttpServletRequest req){
        int status;
        String msg;
        Map map=new HashMap<>();
        Integer uid=Integer.valueOf(req.getParameter("uid"));
        User user=userService.findById(uid);
        //Integer pageSize=1;
        //PageHelper.startPage(pageNo,pageSize);
        String content=req.getParameter("content");
        if(mistakeService.findByContent(user,content)!=null) {
            status = 1;
            msg = "查询成功";
            List<Mistake> list = mistakeService.findByContent(user, content);
            map.put("status", status);
            map.put("msg", msg);
            map.put("list", list);
            return JSON.toJSONString(map);
        }
        //PageInfo<Mistake> pageInfo1=new PageInfo<Mistake>(list1);
        //map.addAttribute("page", pageInfo1);
        else{
            status=0;
            msg="查询失败";
            map.put("status",status);
            map.put("msg",msg);
            return JSON.toJSONString(map);
        }
    }


    /*
    * 用户根据试题类型或者科目查询试题
    * */
    @RequestMapping("/findType")
    @ResponseBody
    public String findType(HttpServletRequest req){
          Integer status;
          String msg;
          Map map=new HashMap<>();
          Integer uid=Integer.valueOf(req.getParameter("uid"));
           User user=userService.findById(uid);
           String typename=req.getParameter("name");
           if(mistakeService.findByType(user,typename) !=null){
               status=1;
               msg="查询成功";
               List<Mistake> list=mistakeService.findByType(user,typename);
               map.put("status",status);
               map.put("msg",msg);
               map.put("list",list);
               return JSON.toJSONString(map);
           }else{
               status=0;
               msg="查询失败";
               map.put("status",status);
               map.put("mag",msg);
               return JSON.toJSONString(map);
           }
    }


    /**
     * 用户查询最近错的前num的题目
     */
    @RequestMapping("/findNum")
    @ResponseBody
    public String findNum(HttpServletRequest req){
        String msg;
        int status;
        Map map=new HashMap<>();
        Integer uid=Integer.valueOf(req.getParameter("uid"));
        Integer num=Integer.valueOf(req.getParameter("num"));
        User user=userService.findById(uid);
        if(mistakeService.findByTime(user,num)!=null){
            status=1;
            msg="查询成功";
            List<Mistake> list=mistakeService.findByTime(user,num);
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
