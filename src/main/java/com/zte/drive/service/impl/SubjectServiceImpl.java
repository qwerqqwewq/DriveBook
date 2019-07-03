package com.zte.drive.service.impl;

import com.zte.drive.dao.SubjectDao;
import com.zte.drive.entity.Subject;
import com.zte.drive.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 9:01
 * Description:<描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subject;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Subject findById(Integer id) {
        return subject.selectById(id);
    }

    @Override
    public List<Subject> findAll() {
        return subject.selectAll();
    }
    //
    @Override
    public void add(Subject subject) {
        this.subject.insert(subject);
    }

    @Override
    public void modify(Subject subject) {
        this.subject.update(subject);
    }

    @Override
    public void remove(Integer id) {
        subject.deleteById(id);
    }

}