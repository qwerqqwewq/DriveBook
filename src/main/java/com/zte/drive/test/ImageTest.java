package com.zte.drive.test;

import com.zte.drive.dao.ImageDao;
import com.zte.drive.entity.Image;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author helloboy
 * Date:2019-07-03 10:19
 * Description:用于测试ImageDao的测试类
 */
public class ImageTest {
    private static ImageDao imageDao;
    static private String path = "spring-dao.xml";
    static private int justInsertId;
    static private final int INSERT_NUM = 5;
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        imageDao = (ImageDao) context.getBean("imageDao");

        insertTest();

        selectById(justInsertId);

        deleteTest(justInsertId);

        selectById(justInsertId);


    }

    private static void insertTest() {
        Image image = new Image();
        image.setSrc("测试路径");
        int row = imageDao.insertImage(image);
        System.out.println("测试插入----返回结果 " + row);
        System.out.println("测试插入----参数变化 " + image);
        justInsertId = image.getId();
    }

    private static void deleteTest(Integer id) {
        int row = imageDao.deleteImage(id);
        System.out.println("测试按id删除----返回结果 " + row);

    }

    private static void selectById(Integer id) {
        Image image = imageDao.selectById(id);
        System.out.println("测试按id查询----返回结果 " + image);
    }
}
