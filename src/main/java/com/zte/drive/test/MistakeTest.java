package com.zte.drive.test;

import com.zte.drive.dao.MistakeDao;
import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.Type;
import com.zte.drive.entity.User;
import com.zte.drive.utils.CurrentDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
public class MistakeTest {
    private static MistakeDao mistakeDao;
    static String path="spring-dao.xml";
    static String createDate= CurrentDate.getCurrentDate();

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        mistakeDao=(MistakeDao)context.getBean("mistakeDao");
        //insert();
        //delete();
         //selectall();
        //selectById();
        //selectByContent();
        //selectByType();
        selectByDate();
    }

    /**
     * 测试错题增加
     */
    public static void insert(){
        Mistake mistake=new Mistake();
        User user=new User();
        user.setId(2);
        Question question=new Question();
        question.setId(3);
        mistake.setUser(user);
        mistake.setQuestion(question);
        mistake.setCreateDate(createDate);
        int row=mistakeDao.insert(mistake);
        System.out.print("测试插入"+row);
        System.out.print("测试结果"+mistake);
    }

    /**
     * 测试错题删除
     */
    public static void delete(){
        Mistake mistake=new Mistake();
       User user=new User();
        user.setId(1);
        Integer id=1;
        int row=mistakeDao.delete(user,id);
        System.out.print("测试删除"+row);
        System.out.print("测试结果"+mistake);
    }

    /**
     * 测试查询用户所有收藏操作
     */
     public static void selectall(){
         User user=new User();
         user.setId(1);
         List<Mistake> list=mistakeDao.selectall(user);
         System.out.print("测试查询"+list);
         }

    /**
     * 测试用户按错题id查找错题
     */
    public static void selectById(){
        User user=new User();
        user.setId(2);
        Integer id=3;
        Mistake mistake=mistakeDao.selectById(user,id);
        System.out.print("测试结果为"+mistake);
    }

    /**
     * 测试用户按错题内容查询错题
     */
    public static void selectByContent(){
        User user=new User();
        user.setId(2);
        String content="1";
        List<Mistake> list=mistakeDao.selectByContent(user, content);
        System.out.print("测试查询"+list);
    }

    /**
     * 测试按题目类型查询
     */
    /*
     public static void selectByType(){
         User user=new User();
         user.setId(1);
         String type="1";
         List<Mistake> mistakes=mistakeDao.selectByType(user,type);
         System.out.print("测试查询"+mistakes);
     }
     */
    /**
     * 用户查询最近前num道错题
     */
    public static void selectByDate(){
        User user=new User();
        user.setId(1);
        Integer num=2;
        List<Mistake> list=mistakeDao.selectByTime(user,num);
        System.out.print("测试查询"+list);
    }
    }
