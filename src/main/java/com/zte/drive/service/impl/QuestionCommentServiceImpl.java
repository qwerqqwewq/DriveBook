package com.zte.drive.service.impl;

import com.zte.drive.dao.QuestionCommentDao;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.QuestionComment;
import com.zte.drive.entity.User;
import com.zte.drive.service.QuestionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dsf
 * @date 2019-07-03 9:39
 * Description:QuestionCommentService实现方法
 */
@Service
public class QuestionCommentServiceImpl implements QuestionCommentService {
    @Autowired
    private QuestionCommentDao questionCommentDao;

    @Override
    public int add(QuestionComment questioncomment) {
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
    public List<QuestionComment> findByQuestion(Question question) {
        return questionCommentDao.selectByQuestion(question);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<QuestionComment> findByComment(QuestionComment questionComment) {
        return questionCommentDao.selectByComment(questionComment);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public QuestionComment findById(Integer id) {
        return questionCommentDao.selectById(id);
    }
}