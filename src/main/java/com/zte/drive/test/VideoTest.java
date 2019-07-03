package com.zte.drive.test;

import com.zte.drive.dao.VideoDao;
import com.zte.drive.entity.Video;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author helloboy
 * Date:2019-07-03 9:42
 * Description:用于测试VideoDao的测试类
 */
public class VideoTest {
    private static VideoDao videoDao;
    static private String path = "spring-dao.xml";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        videoDao = (VideoDao) context.getBean("videoDao");

        insertTest();


    }

    private static void insertTest() {
        Video video = new Video();
        video.setTitle("测试标题");
        video.setContext("测试内容");
        video.setIntro("测试简介");
        int row = videoDao.insertVideo(video);
        System.out.println("测试插入----返回结果" + row);
        System.out.println("测试插入----参数变化" + video);

    }
}
