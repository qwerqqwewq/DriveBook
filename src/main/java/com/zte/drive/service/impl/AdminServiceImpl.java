package com.zte.drive.service.impl;

import com.zte.drive.dao.AdminDao;
import com.zte.drive.entity.Admin;
import com.zte.drive.service.AdminService;
import com.zte.drive.utils.CurrentDate;
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
    private AdminDao adminDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin findById(Integer id) {
        return adminDao.selectById(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminDao.selectAll();
    }
    //
    @Override
    public void add(Admin admin) {
        this.adminDao.insertAdmin(admin);
    }

    @Override
    public void modify(Admin admin) {
        this.adminDao.updateAdmin(admin);
    }

    @Override
    public void remove(Integer id) {
        adminDao.deleteById(id);
    }

    @Override
    public Admin findByName(String name) {
        return adminDao.selectByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin checkLogin(String name, String pwd) {
        // 根据传入的用户名查询得到用户实体类
        Admin admin = adminDao.selectByName(name);
        // 判断用户名和密码是否正确
        // System.out.print(user);
        if (admin != null && admin.getPwd().equals(pwd)) {
            return admin;
        }
        return null;
    }

    @Override
    public int regist(String name, String pwd) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPwd(pwd);
        admin.setRegistDate(CurrentDate.getCurrentDate());
        return adminDao.insertAdmin(admin);
    }

}
