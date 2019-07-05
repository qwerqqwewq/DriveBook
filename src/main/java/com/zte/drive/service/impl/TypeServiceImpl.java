package com.zte.drive.service.impl;

import com.zte.drive.dao.TypeDao;
import com.zte.drive.entity.Type;
import com.zte.drive.service.TypeService;
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
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao type;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Type findById(Integer id) {
        return type.selectById(id);
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer findByType(String mytype) {
        return type.selectByType(mytype);
    }

    @Override
    public List<Type> findAll() {
        return type.selectAll();
    }
    //
    @Override
    public void add(Type type) {
        this.type.insertType(type);
    }

    @Override
    public void modify(Type type) {
        this.type.updateType(type);
    }

    @Override
    public void remove(Integer id) {
        type.deleteById(id);
    }

}