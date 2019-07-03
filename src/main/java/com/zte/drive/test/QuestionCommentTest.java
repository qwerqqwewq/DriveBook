package com.zte.drive.test;

import com.zte.drive.dao.QuestionCommentDao;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.QuestionComment;
import com.zte.drive.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 15:21
 * Description:<描述>
 */
public class QuestionCommentTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        QuestionCommentDao questionCommentDao = (QuestionCommentDao) context.getBean("questionCommentDao");
        User user = new User();
        user.setId(1);
        Question question = new Question();
        question.setId(1);
        QuestionComment questionComment = new QuestionComment();
        questionComment.setId(1);


        // 测试int insert(QuestionComment questioncomment);
        QuestionComment questionComment1 = new QuestionComment();
        questionComment1.setUser(user);
        questionComment1.setQuestion(question);
        questionComment1.setQuestionComment(questionComment);
        questionComment1.setContent("测试评论内容");
        questionComment1.setCommentDate("测试评论日期");
        int result1 = questionCommentDao.insert(questionComment1);
        System.out.println( "测试插入一条评论，返回结果为：" + result1 );
        System.out.println( "插入的评论为：" + questionComment1 );
        int insertId = questionComment1.getId();

        // 测试List<QuestionComment> selectAll();
        List<QuestionComment> questionComments1 = questionCommentDao.selectAll();
        System.out.println( "测试查询所有评论，查询结果为：");
        for ( QuestionComment qc : questionComments1 ) {
            System.out.println(qc);
        }

        // 测试List<QuestionComment> selectByUserId(Integer uid);
        List<QuestionComment> questionComments2 = questionCommentDao.selectByUserId(1);
        System.out.println( "测试查询某用户的所有评论，查询结果为：");
        for ( QuestionComment qc : questionComments2 ) {
            System.out.println(qc);
        }

        // 测试List<QuestionComment> selectByQuestionId(Integer qid);
        List<QuestionComment> questionComments3 = questionCommentDao.selectByQuestionId(1);
        System.out.println( "测试查询某题目下的所有评论，查询结果为：");
        for ( QuestionComment qc : questionComments3 ) {
            System.out.println(qc);
        }

        // 测试QuestionComment selectById(Integer id);
        QuestionComment questionComment2 = questionCommentDao.selectById(insertId);
        System.out.println( "测试按ID查询某条评论，查询结果为：" + questionComment2 );

        // 测试int deleteById(Integer id);
        int result2 = questionCommentDao.deleteById(insertId);
        System.out.println( "测试按ID删除某条评论，返回结果为：" + result2 );
        List<QuestionComment> questionComments4 = questionCommentDao.selectAll();
        System.out.println( "删除后查询所有评论，查询结果为：");
        for ( QuestionComment qc : questionComments4 ) {
            System.out.println(qc);
        }
    }
}