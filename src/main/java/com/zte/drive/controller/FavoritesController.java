package com.zte.drive.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.drive.entity.Favorites;
import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.User;
import com.zte.drive.service.FavoritesService;
import com.zte.drive.service.QuestionService;
import com.zte.drive.utils.CurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2019/7/5.
 */
@Controller
@RequestMapping("/fav")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;
    @Autowired
    private QuestionService questionService;

    private static String createDate= CurrentDate.getCurrentDate();

    /**
     * 用户增加收藏
     */
    @RequestMapping("/add")
    @ResponseBody
    public int add(HttpSession session,HttpServletRequest req){
        Favorites favorites=new Favorites();
        User user=(User)session.getAttribute("user");
        Integer questionid=Integer.valueOf(req.getParameter("questionId"));
        Question question=questionService.findById(questionid);
        favorites.setQuestion(question);
        favorites.setUser(user);
        favorites.setCreateDate(createDate);
        int row=1;
        if(favoritesService.findByqid(user,questionid)==null){
            row=favoritesService.add(favorites);
        }else{
            System.out.print("该试题已被收录");
            row=0;
        }

        return row;
    }

    /**
     * 用户删除收藏
     */
    @RequestMapping("dele")
    @ResponseBody
    public int dele(HttpSession session,HttpServletRequest req){
        User user=(User)session.getAttribute("user");
        Integer id=Integer.valueOf(req.getParameter("id"));
        int row=favoritesService.remove(user,id);
        return row;
    }

    /**
     * 查询用户所有收藏
     */
    @RequestMapping("/find")
    public String find(@RequestParam(value="pageNo",defaultValue = "1")Integer pageNo,  HttpSession session,ModelMap map){
        Integer pageSize=1;
        //每页显示一条记录
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        User user=(User)session.getAttribute("user");
        List<Favorites> list=favoritesService.find(user);
        PageInfo<Favorites> pageInfo=new PageInfo<Favorites>(list);
        map.addAttribute("pageInfo",pageInfo);
        return "favorites/listall";
    }

    /**
     * 查询用户最近的收藏
     */
    @RequestMapping("/findNum")
    @ResponseBody
    public List<Favorites> findNum( HttpSession session,HttpServletRequest req){
        Integer num=Integer.valueOf(req.getParameter("num"));
        User user=(User)session.getAttribute("user");
        List<Favorites> list1=favoritesService.findByNum(user,num);
        return list1;
    }
}
