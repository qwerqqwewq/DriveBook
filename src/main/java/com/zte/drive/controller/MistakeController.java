package com.zte.drive.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.drive.dao.TypeDao;
import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.User;
import com.zte.drive.service.MistakeService;
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

    private static String createDate= CurrentDate.getCurrentDate();
    /**
     * 用户增加错题
     * @param session
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public int add(HttpSession session){
        Mistake mistake=new Mistake();
        User user=(User)session.getAttribute("user");
        mistake.setUser(user);
        mistake.setCreateDate(createDate);
        //设置Question

       return 0;
    }

    /**
     *用户删除错题
     */
    @RequestMapping("/dele")
    @ResponseBody
    public int dele(HttpSession session,Integer id){
        User user=(User)session.getAttribute("user");
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
     *
     * */
    @RequestMapping("/findType")
    @ResponseBody
    public List<Mistake> findType(HttpSession session,String typename){
           User user=(User)session.getAttribute("user");
           System.out.print(typename);
           String type=Integer.toString(typeService.findByType(typename));
           System.out.print(type);
           List<Mistake> list=mistakeService.findByType(user,type);
          return list;
    }

    /**
     * 用户查询最近错的前num的题目
     */
    @RequestMapping("/findNum")
    @ResponseBody
    public List<Mistake> findNum( HttpSession session,Integer num){
        User user=(User)session.getAttribute("user");
        List<Mistake> list1=mistakeService.findByTime(user,num);
        return list1;
    }
}
