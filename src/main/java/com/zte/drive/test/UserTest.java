package com.zte.drive.test;

import com.zte.drive.dao.UserDao;
import com.zte.drive.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dsf
 * @date 2019-07-03 10:32
 * Description:测试
 */
public class UserTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        // 测试int insert(User user);
        User user1 = new User();
        user1.setName("测试用户名");
        user1.setPwd("测试密码");
        user1.setRegistDate("测试日期");
        int result1 = userDao.insert(user1);
        System.out.println("插入函数insert测试：返回结果为" + result1);
        System.out.println("插入的用户信息为：" + user1);
        int insertId = user1.getId();
        String insertRegistDate = user1.getRegistDate();

        // 测试int update(User user);
        User user2 = new User();
        user2.setId(insertId);
        user2.setName("测试修改用户名");
        user2.setPwd("测试修改密码");
        user2.setRegistDate(insertRegistDate);
        int result2 = userDao.update(user2);
        System.out.println("更新函数update测试：返回结果为" + result2);
        System.out.println("更新后的用户信息为：" + user2);
    }


}