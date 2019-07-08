package com.zte.drive.service;

import com.zte.drive.entity.Question;
import com.zte.drive.entity.User;
import com.zte.drive.entity.UserAnswer;

import java.util.List;

/**
 * @author dsf
 * @date 2019-07-03 9:39
 * Description:UserAnswer实体类的Service方法
 */
public interface UserAnswerService {
    /**
     * 插入一条用户答案
     * @param userAnswer
     * @return 插入行数
     */
    int add(UserAnswer userAnswer);

    /**
     * 根据ID删除一条用户答案
     * @param id
     * @return 删除行数
     */
    int removeById(Integer id);

    /**
     * 更新某条用户答案，要求用户ID
     * @param userAnswer
     * @return 更新行数
     */
    int modify(UserAnswer userAnswer);

    /**
     * 查询所有用户答案
     * @return 用户答案列表
     */
    List<UserAnswer> findAll();

    /**
     * 查询某用户的所有答案
     * @param user
     * @return 用户答案列表
     */
    List<UserAnswer> findByUser(User user);

    /**
     * 查询某题目的所有答题信息
     * @param question
     * @return 用户答案列表
     */
    List<UserAnswer> findByQuesiton(Question question);

    /**
     * 根据ID查询某条用户答案
     * @param id
     * @return 用户答案
     */
    UserAnswer findById(Integer id);
}