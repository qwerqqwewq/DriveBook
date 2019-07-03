package com.zte.drive.dao;

import com.zte.drive.entity.User;

import java.util.List;

/**
 * @author 邓胜峰
 * @date 2019-07-03 8:56
 * Description:User实体类的Dao方法
 */
public interface UserDao {
    /**
     * 新增一个用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 根据ID删除一个用户
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 更新一个用户的信息
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectAll();

    /**
     * 根据用户ID查询某个用户信息
     * @param id
     * @return
     */
    User selectById(Integer id);
}