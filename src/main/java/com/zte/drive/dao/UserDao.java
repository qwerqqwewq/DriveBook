package com.zte.drive.dao;

import com.zte.drive.entity.User;

import java.util.List;

/**
 * @author dsf
 * @date 2019-07-03 8:56
 * Description:User实体类的Dao方法
 */
public interface UserDao {
    /**
     * 新增一个用户
     * @param user
     * @return 插入行数
     */
    int insert(User user);

    /**
     * 根据ID删除一个用户
     * @param id
     * @return 删除行数
     */
    int deleteById(Integer id);

    /**
     * 更新一个用户的信息，仅能修改用户名和密码
     * @param user
     * @return 更新行数
     */
    int update(User user);

    /**
     * 查询所有用户信息
     * @return 用户列表
     */
    List<User> selectAll();

    /**
     * 根据用户ID查询某个用户信息
     * @param id
     * @return 用户
     */
    User selectById(Integer id);

    /**
     * 根据用户名查询某个用户
     * @param name
     * @return 用户
     */
    User selectByName(String name);
}