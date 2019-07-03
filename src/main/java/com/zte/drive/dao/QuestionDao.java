package com.zte.drive.dao;

import com.zte.drive.entity.Question;
import com.zte.drive.entity.Subject;
import com.zte.drive.entity.Type;

import java.util.List;

/**
 * @author lxj
 * Date:2019-07-03 16:05
 * Description:QuestionDao
 */
public interface QuestionDao {

    /**
     * 插入题目信息
     * @param question 题目信息bean
     * @return 影响行数
     */
    public int insertQuestion(Question question);

    /**
     * 修改题目信息
     * @param question 题目信息bean
     * @return 影响行数
     */
    public int updateQuestion(Question question);

    /**
     * 根据id删除题目
     * @param id 题目id
     * @return 影响行数
     */
    public int deleteQuestion(Integer id);

    /**
     * 根据id选择题目
     * @param id 题目id
     * @return 题目集合
     */
    public Question selectById(Integer id);

    /**
     * 根据类型选择题目
     * @param type 类型
     * @return 题目集合
     */
    public List<Question> selectByType(Type type);

    /**
     * 根据科目选择题目
     * @param subject 科目
     * @return 题目集合
     */
    public List<Question> selectBySubject(Subject subject);

    /**
     * 更新答题人数，使其自增1
     * @return 影响行数
     */
    int updateTotalNum(Integer id);

    /**
     * 更新正答人数，使其自增1
     * @return 影响行数
     */
    int updateCorrectNum(Integer id);
}
