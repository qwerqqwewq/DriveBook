package com.zte.drive.service.impl;

import com.zte.drive.dao.MistakeDao;
import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.User;
import com.zte.drive.service.MistakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class MistakeServiceImpl implements MistakeService {
    @Autowired
    private MistakeDao mistakeDao;
    @Override
    public int add(Mistake mistake) {
        return mistakeDao.insert(mistake);
    }

    @Override
    public int remove(User user, Integer id) {
        return mistakeDao.delete(user,id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Mistake> findall(User user) {
        return mistakeDao.selectall(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Mistake findById(User user, Integer id) {
        return mistakeDao.selectById(user,id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Mistake> findByContent(User user, String content) {
        return mistakeDao.selectByContent(user,content);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Mistake> findByType(User user, String type) {
        return mistakeDao.selectByType(user,type);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Mistake> findByTime(User user, Integer num) {
        return mistakeDao.selectByTime(user,num);
    }
}
