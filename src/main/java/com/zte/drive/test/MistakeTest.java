package com.zte.drive.test;

import com.zte.drive.dao.MistakeDao;
import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.Question;
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
        insert();
        selectall();
        selectById();
        selectByContent();
        selectByType();
        selectByDate();
        selectByqid();
        delete();
        deleteall();
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
        System.out.println("测试插入"+row);
        System.out.println("测试结果"+mistake);
    }

    /**
     * 测试错题删除
     */
    public static void delete(){
       User user=new User();
        user.setId(2);
        Integer id=2;
        int row=mistakeDao.delete(user,id);
        System.out.println("测试删除"+row);
    }

    /**
     * 测试错题所有删除
     */
    public static void deleteall(){
        User user=new User();
        user.setId(2);
        int row=mistakeDao.deleteall(user);
        System.out.println("测试删除"+row);
    }

    /**
     * 测试查询用户所有错题操作
     */
     public static void selectall(){
         User user=new User();
         user.setId(2);
         List<Mistake> list=mistakeDao.selectall(user);
         System.out.println("测试查询"+list);
         }

    /**
     * 测试用户按错题id查找错题
     */
    public static void selectById(){
        User user=new User();
        user.setId(2);
        Integer id=3;
        Mistake mistake=mistakeDao.selectById(user,id);
        System.out.println("测试结果为"+mistake);
    }

    /**
     * 测试用户按错题内容查询错题
     */
    public static void selectByContent(){
        User user=new User();
        user.setId(2);
        String content="S";
        List<Mistake> list=mistakeDao.selectByContent(user, content);
        System.out.println("测试查询"+list);
    }

    /**
     * 测试按题目类型查询
     */

     public static void selectByType(){
         User user=new User();
         user.setId(2);
         String type="科目二";
         List<Mistake> mistakes=mistakeDao.selectByType(user,type);
         System.out.println("测试查询"+mistakes);
     }

    /**
     * 用户查询最近前num道错题
     */
    public static void selectByDate(){
        User user=new User();
        user.setId(2);
        Integer num=1;
        List<Mistake> list=mistakeDao.selectByTime(user,num);
        System.out.println("测试查询"+list);
    }

    /**
     *测试用户根据试题Id查询错题记录
     */
    public static void selectByqid(){
        User user=new User();
        user.setId(2);
        Integer qid=3;
        Mistake mistake=mistakeDao.selectByqid(user,qid);
        System.out.println("测试查询"+mistake);
    }
}