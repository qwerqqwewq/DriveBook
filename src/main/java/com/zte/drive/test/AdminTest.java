package com.zte.drive.test;

import com.zte.drive.dao.AdminDao;
import com.zte.drive.entity.Admin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Author:helloboy
 * Date:2019-07-03 11:26
 * Description:<描述>
 */
public class AdminTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        AdminDao admindao = (AdminDao) context.getBean("adminDao");
        if (admindao != null) {
            Admin admin1 = new Admin(1,"sss", "sss", "123");
            admindao.insertAdmin(admin1);
            System.out.println("插入一个管理员：");
            System.out.println("查找ID为1的管理员：");
            System.out.println(admindao.selectById(1));
            System.out.println("修改Id为1的管理员：");
            Admin admin2 = new Admin(1,"ss", "ss", "123");
            admindao.updateAdmin(admin2);
            System.out.println(admindao.selectById(1));
            System.out.println("删除Id为1的管理员：");
            admindao.deleteById(1);
        } else {
            System.out.println("error");
        }
    }
}