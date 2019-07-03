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
        User user = new User();
        user.setName("测试用户名");
        user.setPwd("测试密码");
        user.setRegistDate("测试日期");
        int result = userDao.insert(user);
        System.out.println("插入函数insert测试：返回结果为" + result);
        System.out.println("插入的用户信息为：" + user);
    }


}