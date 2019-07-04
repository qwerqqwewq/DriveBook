package com.zte.drive.service.impl;

import com.zte.drive.dao.AdminDao;
import com.zte.drive.entity.Admin;
import com.zte.drive.service.AdminService;
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
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao admin;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin findById(Integer id) {
        return admin.selectById(id);
    }

    @Override
    public List<Admin> findAll() {
        return admin.selectAll();
    }
    //
    @Override
    public void add(Admin admin) {
        this.admin.insertAdmin(admin);
    }

    @Override
    public void modify(Admin admin) {
        this.admin.updateAdmin(admin);
    }

    @Override
    public void remove(Integer id) {
        admin.deleteById(id);
    }

}
