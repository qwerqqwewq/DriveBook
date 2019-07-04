package com.zte.drive.service;

import com.zte.drive.entity.Admin;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 9:22
 * Description:<描述>
 */
public interface AdminService {
    //根据管理员id查询
    public Admin findById(Integer id);
    //查询所有管理员
    public List<Admin> findAll();
    //新增一个管理员
    public void add(Admin admin);
    //更新一个管理员信息
    public void modify(Admin admin);
    //根据ID删除一个管理员
    public void remove(Integer id);
    //根据姓名找管理员
    Admin findByName(String name);
    //检查登录
    Admin checkLogin(String name, String pwd);
    //检查注册
    int regist(String name, String pwd);

}
