package com.zte.drive.service.impl;

import com.zte.drive.dao.QuestionCommentDao;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.QuestionComment;
import com.zte.drive.entity.User;
import com.zte.drive.service.QuestionCommentService;
import com.zte.drive.utils.CurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author dsf
 * @date 2019-07-03 9:39
 * Description:QuestionCommentService实现方法
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class QuestionCommentServiceImpl implements QuestionCommentService {
    @Autowired
    private QuestionCommentDao questionCommentDao;

    @Override
    public int add(QuestionComment questioncomment) {
        questioncomment.setCommentDate(CurrentDate.getCurrentDate());
        return questionCommentDao.insert(questioncomment);
    }

    @Override
    public int removeById(Integer id) {
        return questionCommentDao.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<QuestionComment> findAll() {
        return questionCommentDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<QuestionComment> findByUser(User user) {
        return questionCommentDao.selectByUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<QuestionComment> findByQuestion(Question question,Integer num) {
        //step1 查找问题的直接评论(即parentId==null)
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

            while (!queue.isEmpty()) {
                //拿走队头
                QuestionComment first = queue.remove();
                //查找队头的所有直接子评论
                List<QuestionComment> commentsOfFirst = questionCommentDao.selectByComment(first);
                //将他们添加到队伍中
                queue.addAll(commentsOfFirst);
                //将队头放到set里
                set.add(first);
                //如果队列里还有元素则重复这项操作
            }
            //所有子评论都已经加入

            //将子评论集合设置
            rootNode.setCommentNumber(set.size());

            //由于传到前台时，根节点的所有评论不能全传，因此只选择其中五个
            Set<QuestionComment> setNew = new TreeSet();
            int i = 0;
            for (QuestionComment questionComment : set) {
                if (++i > num) {
                    break;
                }
                setNew.add(questionComment);
            }
            rootNode.setComments(setNew);

        }

        //根节点评论子评论设置完成
        return root;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<QuestionComment> findByComment(QuestionComment questionComment) {
        return questionCommentDao.selectByComment(questionComment);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public QuestionComment findById(Integer id) {
        QuestionComment rootNode = questionCommentDao.selectById(id);
        //定义子评论集合
        Set<QuestionComment> set = new TreeSet<>();
        //定义队列，先找到的子评论先加入集合中
        Queue<QuestionComment> queue = new LinkedList<>();
        //将根节点的直接子评论放到queue中
        queue.addAll(questionCommentDao.selectByComment(rootNode));
        //如果它有子评论，进入循环
        while (!queue.isEmpty()) {
            //拿走队头
            QuestionComment first = queue.remove();
            //查找队头的所有直接子评论
            List<QuestionComment> commentsOfFirst = questionCommentDao.selectByComment(first);
            //将他们添加到队伍中
            queue.addAll(commentsOfFirst);
            //将队头放到set里
            set.add(first);
            //如果队列里还有元素则重复这项操作
        }
        //所有子评论都已经加入
        //将子评论集合设置
        rootNode.setComments(set);
        rootNode.setCommentNumber(set.size());
        return rootNode;
    }
}