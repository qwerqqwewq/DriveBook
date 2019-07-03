package com.zte.drive.dao;

import com.zte.drive.entity.User;
import com.zte.drive.entity.UserAnswer;

import java.util.List;

/**
 * @author dsf
 * @date 2019-07-03 9:12
 * Description:<描述>
 */
public interface UserAnswerDao {

    /**
     * 插入一条用户答案
     * @param userAnswer
     * @return 插入行数
     */
    int insert(UserAnswer userAnswer);

    /**
     * 根据ID删除某条用户答案
     * @param id
     * @return 删除行数
     */
    int deleteById(Integer id);

    /**
     * 更新某条用户答案，要求用户ID
     * @param userAnswer
     * @return 更新行数
     */
    int update(UserAnswer userAnswer);

    /**
     * 查询所有用户答案
     * @return 用户答案列表
     */
    List<UserAnswer> selectAll();

    /**
     * 查询某用户的所有答案
     * @param user
     * @return 用户答案列表
     */
    List<UserAnswer> selectByUser(User user);

    /**
     * 根据ID查询某条用户答案
     * @param id
     * @return 用户答案
     */
    UserAnswer selectById(Integer id);

}