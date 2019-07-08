package com.zte.drive.dao;

import com.zte.drive.entity.Question;
import com.zte.drive.entity.QuestionComment;
import com.zte.drive.entity.User;

import java.util.List;

/**
 * @author dsf
 * @date 2019-07-03 8:56
 * Description:QuestionComment实体类的Dao方法
 */
public interface QuestionCommentDao {
    /**
     * 插入某条评论
     * @param questionComment
     * @return 插入行数
     */
    int insert(QuestionComment questionComment);

    /**
     * 根据评论ID删除某条评论
     * @param id
     * @return 删除行数
     */
    int deleteById(Integer id);

    /**
     * 查询所有评论
     * @return 评论列表
     */
    List<QuestionComment> selectAll();

    /**
     * 查询某用户的所有评论
     * @param user
     * @return 评论列表
     */
    List<QuestionComment> selectByUser(User user);

    /**
     * 查询某题目下的所有非子评论
     * @param question
     * @return 评论列表
     */
    List<QuestionComment> selectByQuestion(Question question);

    /**
     * 查询某评论的所有直接子评论
     * @param questionComment
     * @return 评论列表
     */
    List<QuestionComment> selectByComment(QuestionComment questionComment);

    /**
     * 根据评论ID查询某条评论
     * @param id
     * @return 评论
     */
    QuestionComment selectById(Integer id);
}