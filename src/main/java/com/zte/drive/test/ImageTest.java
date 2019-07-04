package com.zte.drive.test;

import com.zte.drive.dao.ImageDao;
import com.zte.drive.entity.Image;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Author:helloboy
 * Date:2019-07-03 11:26
 * Description:<描述>
 */
public class ImageTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        ImageDao imagedao = (ImageDao) context.getBean("imageDao");
        if (imagedao != null) {
            Image image1 = new Image(1,"ss123");
            imagedao.insertImage(image1);
            System.out.println("插入一个图片：");
            System.out.println("查找ID为1的图片：");
            System.out.println(imagedao.selectById(1));
            System.out.println("修改Id为1的图片：");
            Image image2 = new Image(2, "123");
            imagedao.updateImage(image2);
            System.out.println(imagedao.selectById(1));
            System.out.println("删除Id为1的图片：");
            imagedao.deleteById(1);
        } else {
            System.out.println("error");
        }
    }
}