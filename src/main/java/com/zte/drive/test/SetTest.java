package com.zte.drive.test;

import com.zte.drive.dao.QuestionCommentDao;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.QuestionComment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * Author:helloboy
 * Date:2019-07-11 9:47
 * Description:<描述>
 */
public class SetTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        QuestionCommentDao questionCommentDao = (QuestionCommentDao) context.getBean("questionCommentDao");
        Question question = new Question();
        question.setId(5);
        List<QuestionComment> root = questionCommentDao.selectByQuestion(question);
        //step2 按次查找根问题的所有子评论，将他们放置在根问题的子评论集合中
        for (QuestionComment rootNode : root) {
            //定义子评论集合
            Set<QuestionComment> set = new TreeSet<>();
            //定义队列，先找到的子评论先加入集合中
            Queue<QuestionComment> queue = new LinkedList<>();
            //将根节点的直接子评论放到queue中
            queue.addAll(questionCommentDao.selectByComment(rootNode));
            //如果它有子评论，进入循环
            QuestionComment temp;
            while (!queue.isEmpty()) {
                //拿走队头
                QuestionComment first = queue.remove();

                //查找队头的所有直接子评论
                List<QuestionComment> commentsOfFirst = questionCommentDao.selectByComment(first);
                //将他们添加到队伍中
                queue.addAll(commentsOfFirst);
                //将队头放到set里
                set.add(first);
                temp = first;
                //如果队列里还有元素则重复这项操作
            }
            //所有子评论都已经加入
            //将子评论集合设置
            rootNode.setCommentNumber(set.size());
            rootNode.setComments(set);



        }
    }
}
