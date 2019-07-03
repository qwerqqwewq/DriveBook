package com.zte.drive.service.impl;

import com.zte.drive.dao.UserAnswerDao;
import com.zte.drive.entity.User;
import com.zte.drive.entity.UserAnswer;
import com.zte.drive.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dsf
 * @date 2019-07-03 9:39
 * Description:UserService实现方法
 */
@Service
public class UserAnswerServiceImpl implements UserAnswerService {
    @Autowired
    private UserAnswerDao userAnswerDao;

    @Override
    public int add(UserAnswer userAnswer) {
        return userAnswerDao.insert(userAnswer);
    }

    @Override
    public int removeById(Integer id) {
        return userAnswerDao.deleteById(id);
    }

    @Override
    public int modify(UserAnswer userAnswer) {
        return userAnswerDao.update(userAnswer);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserAnswer> findAll() {
        return userAnswerDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<UserAnswer> findByUser(User user) {
        return userAnswerDao.selectByUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public UserAnswer findById(Integer id) {
        return userAnswerDao.selectById(id);
    }
}