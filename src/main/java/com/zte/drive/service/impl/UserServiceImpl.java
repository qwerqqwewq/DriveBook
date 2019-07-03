package com.zte.drive.service.impl;

import com.zte.drive.dao.UserDao;
import com.zte.drive.entity.User;
import com.zte.drive.service.UserService;
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
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int add(User user) {
        return userDao.insert(user);
    }

    @Override
    public int removeById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public int modify(User user) {
        return userDao.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findAll() {
        return userDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findById(Integer id) {
        return userDao.selectById(id);
    }
}