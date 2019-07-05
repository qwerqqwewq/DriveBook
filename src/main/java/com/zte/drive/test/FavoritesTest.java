package com.zte.drive.test;

import com.zte.drive.dao.FavoritesDao;
import com.zte.drive.entity.Favorites;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.User;
import com.zte.drive.utils.CurrentDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
public class FavoritesTest {
    private static FavoritesDao favoritesDao;
    static String path="spring-dao.xml";
    static String createDate= CurrentDate.getCurrentDate();

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext(path);
        favoritesDao=(FavoritesDao)context.getBean("favoritesDao");
        //insert();
        //delete();
        //selectall();
        selectByNum();
    }

    //测试增加
    public static void insert(){
        Favorites favorites=new Favorites();
        User user=new User();
        user.setId(1);
        Question question=new Question();
        question.setId(2);
        favorites.setCreateDate(createDate);
        favorites.setQuestion(question);
        favorites.setUser(user);
        int row=favoritesDao.insert(favorites);
        System.out.print(row);
    }

    //测试删除
    public static  void delete(){
        User user=new User();
        user.setId(1);
        Integer id=2;
        int row=favoritesDao.delete(user,id);
        System.out.print(row);
    }

    //测试查询
    public static void selectall(){
        User user=new User();
        user.setId(1);
        List<Favorites> list=favoritesDao.select(user);
        System.out.print(list);
    }

    //测试收藏的前几条数据
    public static void selectByNum(){
        User user=new User();
        user.setId(1);
        Integer num=3;
       List<Favorites> list=favoritesDao.selectByNum(user,num);
        System.out.print(list);
    }
    /**
     *测试用户根据试题Id查询错题记录
     */

    public static void selectByqid(){
        User user=new User();
        user.setId(1);
        Integer qid=1;
        Favorites mistake=favoritesDao.selectByqid(user,qid);
        System.out.print("测试查询"+mistake);
    }
}
