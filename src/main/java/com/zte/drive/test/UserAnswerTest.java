package com.zte.drive.test;

import com.zte.drive.dao.UserAnswerDao;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.User;
import com.zte.drive.entity.UserAnswer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 14:17
 * Description:<描述>
 */
public class UserAnswerTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserAnswerDao userAnswerDao = (UserAnswerDao) context.getBean("userAnswerDao");
        User user = new User();
        user.setId(1);
        Question question = new Question();
        question.setId(1);

        // 测试insert(UserAnswer userAnswer);
        UserAnswer userAnswer1 = new UserAnswer();
        userAnswer1.setUser(user);
        userAnswer1.setQuestion(question);
        userAnswer1.setAnswer("测试答案");
        int result1 = userAnswerDao.insert(userAnswer1);
        System.out.println("测试插入用户答案，返回结果为：" + result1);
        System.out.println("插入的用户答案为：" + userAnswer1);
        int insertId = userAnswer1.getId();

        // 测试update(UserAnswer userAnswer);
        UserAnswer userAnswer2 = new UserAnswer();
        userAnswer2.setId(insertId);
        userAnswer2.setUser(user);
        userAnswer2.setQuestion(question);
        userAnswer2.setAnswer("测试修改答案");
        int result2 = userAnswerDao.update(userAnswer2);
        System.out.println("测试修改用户答案，返回结果为：" + result2);
        System.out.println("修改后的用户答案为：" + userAnswer2);

        // 测试List<UserAnswer> selectAll();
        List<UserAnswer> userAnswers1 = userAnswerDao.selectAll();
        System.out.println("测试查询所有用户答案，返回结果为：");
        for ( UserAnswer userAnswer : userAnswers1 ) {
            System.out.println(userAnswer);
        }

        // 测试List<UserAnswer> selectByUser(User user);
        List<UserAnswer> userAnswers2 = userAnswerDao.selectByUser(user);
        System.out.println("测试查询某用户的所有答案，返回结果为：");
        for ( UserAnswer userAnswer : userAnswers2 ) {
            System.out.println(userAnswer);
        }

        // 测试UserAnswer selectById(Integer id);
        UserAnswer userAnswer3 = userAnswerDao.selectById(insertId);
        System.out.println("测试按ID查询某条用户答案，返回结果为：" + userAnswer3);

        // 测试deleteById(Integer id);
        int result3 = userAnswerDao.deleteById(insertId);
        System.out.println("测试按ID删除某条用户答案，返回结果为：" + result3 );
        List<UserAnswer> userAnswers3 = userAnswerDao.selectAll();
        System.out.println("删除后查询所有用户答案，结果为：");
        for ( UserAnswer userAnswer : userAnswers3 ) {
            System.out.println(userAnswer);
        }

    }
}