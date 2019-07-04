package com.zte.drive.test;
import com.zte.drive.entity.Subject;
import com.zte.drive.dao.SubjectDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:helloboy
 * Date:2019-07-03 11:26
 * Description:<描述>
 */
public class SubjectTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        SubjectDao subjectdao = (SubjectDao) context.getBean("subjectDao");
        if (subjectdao != null) {
            Subject subject1 = new Subject(5, "123");
            subjectdao.insertSubject(subject1);
            System.out.println("插入一个科目：");

            System.out.println("查找ID为1的科目：");
            System.out.println(subjectdao.selectById(1));

            System.out.println("修改评论Id为1的科目：");
            Subject subject2 = new Subject(5, "123");
            subjectdao.updateSubject(subject2);
            System.out.println(subjectdao.selectById(1));
            System.out.println("删除ID为1的科目：");
            subjectdao.deleteById(5);
        } else {
            System.out.println("error");
        }
    }
}
