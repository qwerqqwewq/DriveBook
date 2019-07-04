package com.zte.drive.service;

import com.zte.drive.entity.User;

import java.util.List;

/**
 * @author dsf
 * @date 2019-07-03 9:39
 * Description:User实体类的Service方法
 */
public interface UserService {
    /**
     * 新增一个用户
     * @param user
     * @return 插入行数
     */
    int add(User user);

    /**
     * 根据ID删除一个用户
     * @param id
     * @return 删除行数
     */
    int removeById(Integer id);

    /**
     * 更新某个用户的信息，仅能修改用户名和密码
     * @param user
     * @return 更新行数
     */
    int modify(User user);

    /**
     * 查询所有用户信息
     * @return 用户列表
     */
    List<User> findAll();

    /**
     * 根据ID查询某个用户信息
     * @param id
     * @return 用户
     */
    User findById(Integer id);

    /**
     * 根据用户名查询某个用户
     * @param name
     * @return 用户
     */
    User findByName(String name);

    /**
     * 检查登录
     * @param name
     * @param pwd
     * @return 用户
     */
    User checkLogin(String name, String pwd);

    /**
     * 用户注册
     * @param name
     * @param pwd
     * @return 新增人数
     */
    int regist(String name, String pwd);
}