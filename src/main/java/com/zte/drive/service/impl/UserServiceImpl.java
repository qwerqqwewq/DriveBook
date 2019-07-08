package com.zte.drive.service.impl;

import com.zte.drive.dao.UserDao;
import com.zte.drive.entity.User;
import com.zte.drive.service.UserService;
import com.zte.drive.utils.CurrentDate;
import com.zte.drive.utils.MD5Util;
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
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
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

    @Override
    public User findByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User checkLogin(String name, String pwd) {
        // 先将传入的密码进行MD5加密
        String md5Pwd = MD5Util.MD5Encode(pwd);
        // 根据传入的用户名查询得到用户实体类
        User user = userDao.selectByName(name);
        // 判断用户名和密码是否正确
        // System.out.print(user);
        if (user != null && user.getPwd().equals(md5Pwd)) {
            return user;
        }
        return null;
    }

    @Override
    public int regist(String name, String pwd) {
        User user = new User();
        user.setName(name);
        String md5Pwd = MD5Util.MD5Encode(pwd);
        user.setPwd(md5Pwd);
        user.setRegistDate(CurrentDate.getCurrentDate());
        // 在数据库中查找是否有用户名重复
        User check = userDao.selectByName(name);
        if ( check != null ) {
            return 0;
        }
        return userDao.insert(user);
    }
}