package com.zte.drive.test;

import com.zte.drive.dao.VideoDao;
import com.zte.drive.entity.Video;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author helloboy
 * Date:2019-07-03 9:42
 * Description:用于测试VideoDao的测试类
 */
public class VideoTest {
    private static VideoDao videoDao;
    static private String path = "spring-dao.xml";
    static private int justInsertId;
    static private final int INSERT_NUM = 5;
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        videoDao = (VideoDao) context.getBean("videoDao");

        insertTest();

        selectById(justInsertId);

        updateTest();

        selectById(justInsertId);

        for (int i = 0; i < INSERT_NUM; i++) {
            insertTest();
        }

        selectAllTest();

        selectByRange(3,6);

        deleteTest();

    }

    private static void insertTest() {
        Video video = new Video();
        video.setTitle("测试标题");
        video.setContext("测试内容");
        video.setIntro("测试简介");
        video.setSrc("测试路径");
        int row = videoDao.insertVideo(video);
        System.out.println("测试插入----返回结果 " + row);
        System.out.println("测试插入----参数变化 " + video);
        justInsertId = video.getId();

    }

    private static void updateTest() {
        Video video = new Video();
        video.setTitle("测试修改标题");
        video.setContext("测试修改内容");
        video.setIntro("测试修改简介");
        video.setId(justInsertId);

        int row = videoDao.updateVideo(video);
        System.out.println("测试修改----返回结果 " + row);
    }

    private static void selectAllTest() {
        List<Video> videos = videoDao.selectAll();
        for (Video video : videos) {
            System.out.println("测试查询所有----返回结果 " + video);
        }
    }

    private static void selectByRange(Integer start,Integer end) {
        List<Video> videos = videoDao.selectByRange(start, end);
        for (Video video : videos) {
            System.out.println("测试按范围["+start+","+end+")查询----返回结果 " + video);
        }
    }

    private static void selectById(Integer id) {
        Video video = videoDao.selectById(id);
        System.out.println("测试按id查询----返回结果 " + video);
    }

    private static void deleteTest() {
        List<Video> videos = videoDao.selectAll();
        for (Video video : videos) {
            Integer id = video.getId();
            int row = videoDao.deleteVideo(id);
            System.out.println("测试删除----返回结果 " + row);
        }
        selectAllTest();
    }
}
