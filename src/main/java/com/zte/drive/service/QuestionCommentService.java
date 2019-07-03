package com.zte.drive.service;

import com.zte.drive.entity.Question;
import com.zte.drive.entity.QuestionComment;
import com.zte.drive.entity.User;

import java.util.List;

/**
 * @author dsf
 * @date 2019-07-03 9:39
 * Description:QuestionComment实体类的Service方法
 */
public interface QuestionCommentService {
    /**
     * 插入某条评论
     * @param questioncomment
     * @return 插入行数
     */
    int add(QuestionComment questioncomment);

    /**
     * 根据评论ID删除某条评论
     * @param id
     * @return 删除行数
     */
    int removeById(Integer id);

    /**
     * 查询所有评论
     * @return 评论列表
     */
    List<QuestionComment> findAll();

    /**
     * 查询某用户的所有评论
     * @param user
     * @return 评论列表
     */
    List<QuestionComment> findByUser(User user);

    /**
     * 查询某题目下的所有非子评论
     * @param question
     * @return 评论列表
     */
    List<QuestionComment> findByQuestion(Question question);

    /**
     * 查询某评论的所有子评论
     * @param questionComment
     * @return 评论列表
     */
    List<QuestionComment> findByComment(QuestionComment questionComment);

    /**
     * 根据评论ID查询某条评论
     * @param id
     * @return 评论
     */
    QuestionComment findById(Integer id);
}