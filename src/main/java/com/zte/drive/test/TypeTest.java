package com.zte.drive.test;

import com.zte.drive.dao.TypeDao;
import com.zte.drive.entity.Type;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:helloboy
 * Date:2019-07-03 11:26
 * Description:<描述>
 */
public class TypeTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        TypeDao typedao = (TypeDao) context.getBean("typeDao");
        if (typedao != null) {
            Type type1 = new Type(8, "123");
            typedao.insertType(type1);
            System.out.println("插入一个类型：");
            System.out.println("查找ID为1的类型：");;
            System.out.println(typedao.selectByType("单选题"));
            System.out.println("修改Id为1的类型：");
            Type type2 = new Type(8, "123");
            typedao.updateType(type2);
            System.out.println(typedao.selectById(1));
            System.out.println("删除Id为8的类型：");
            typedao.deleteById(8);
        } else {
            System.out.println("error");
        }
    }
}