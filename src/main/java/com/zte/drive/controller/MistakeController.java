package com.zte.drive.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.drive.dao.QuestionDao;
import com.zte.drive.dao.TypeDao;
import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.User;
import com.zte.drive.service.MistakeService;
import com.zte.drive.service.QuestionService;
import com.zte.drive.service.TypeService;
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
import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
@Controller
@RequestMapping("/mistake")
public class MistakeController {

    @Autowired
    private MistakeService mistakeService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private QuestionService questionService;

    private static String createDate= CurrentDate.getCurrentDate();
    /**
     * 用户增加错题
     * @param session
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public int add(HttpSession session,HttpServletRequest req){
        Mistake mistake=new Mistake();
        User user=(User)session.getAttribute("user");
        mistake.setUser(user);
        mistake.setCreateDate(createDate);
        Integer questionId=Integer.valueOf(req.getParameter("questionId"));
        //设置Question
        Question question=questionService.findById(questionId);
        mistake.setQuestion(question);
        int row=mistakeService.add(mistake);
       return row;
    }
    /**
     *用户删除错题
     */
    @RequestMapping("/dele")
    @ResponseBody
    public int dele(HttpSession session,HttpServletRequest req){
        User user=(User)session.getAttribute("user");
        Integer id=Integer.valueOf(req.getParameter("id"));
        int row=mistakeService.remove(user,id);
        return row;
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
    public Mistake findId(HttpSession session,HttpServletRequest req){
        User user=(User)session.getAttribute("user");
        Integer id=Integer.valueOf(req.getParameter("id"));
        Mistake mistake=mistakeService.findById(user,id);
        return mistake;
    }

    /**
     * 用户根据试题内容查询试题
     */
    @RequestMapping("/findContent")
    public String findContent(@RequestParam(value="pageNo",defaultValue = "1")Integer pageNo,  HttpSession session,ModelMap map,HttpServletRequest req){
        User user=(User)session.getAttribute("user");
        Integer pageSize=1;
        PageHelper.startPage(pageNo,pageSize);
        String content=req.getParameter("content");
        List<Mistake> list1=mistakeService.findByContent(user,content);
        PageInfo<Mistake> pageInfo1=new PageInfo<Mistake>(list1);
        map.addAttribute("page", pageInfo1);
        return "mistake/listid";
    }


    @RequestMapping("/findType")
    @ResponseBody
    public List<Mistake> findType(HttpSession session,HttpServletRequest req){
           User user=(User)session.getAttribute("user");
           String typename=req.getParameter("typename");
           String type=Integer.toString(typeService.findByType(typename));
           List<Mistake> list=mistakeService.findByType(user,type);
          return list;
    }


    /**
     * 用户查询最近错的前num的题目
     */
    @RequestMapping("/findNum")
    @ResponseBody
    public List<Mistake> findNum( HttpSession session,HttpServletRequest req){
        Integer num=Integer.valueOf(req.getParameter("num"));
        User user=(User)session.getAttribute("user");
        List<Mistake> list1=mistakeService.findByTime(user,num);
        return list1;
    }
}
