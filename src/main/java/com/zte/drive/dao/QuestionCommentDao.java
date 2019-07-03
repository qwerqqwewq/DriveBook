package com.zte.drive.dao;

import com.zte.drive.entity.QuestionComment;

import java.util.List;

/**
 * @author dsf
 * @date 2019-07-03 8:56
 * Description:QuestionComment实体类的Dao方法
 */
public interface QuestionCommentDao {
    /**
     * 插入某条评论
     * @param questioncomment
     * @return 插入行数
     */
    int insert(QuestionComment questioncomment);

    /**
     * 根据评论ID删除某条评论
     * @param id
     * @return 删除行数
     */
    int deleteById(Integer id);

    /**
     * 更新某条评论信息
     * @param questionComment
     * @return 更新行数
     */
    int update(QuestionComment questionComment);

    /**
     * 查询所有评论
     * @return 评论列表
     */
    List<QuestionComment> selectAll();

    /**
     * 查询某用户的所有评论
     * @param uid
     * @return 评论列表
     */
    List<QuestionComment> selectByUserId(Integer uid);

    /**
     * 查询某题目下的所有评论
     * @param qid
     * @return
     */
    List<QuestionComment> selectByQuestionId(Integer qid);

    /**
     * 根据评论ID查询某条评论
     * @param id
     * @return 评论
     */
    QuestionComment selectById(Integer id);
}