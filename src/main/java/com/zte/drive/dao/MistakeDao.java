package com.zte.drive.dao;

import com.zte.drive.entity.Question;

import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
public interface MistakeDao {
    /***
     * 增加一条错题记录
     * @param question
     * @return
     */
     public int insert(Question question);

    /***
     *删除一条错题记录
     * @param
     * @return
     */
    public int delete();

    /***
     * 更新一条错题记录
     *@param question
     * @return
     */
    public int update(Question question);

    /*
    * 查询所有错题记录
    *@param
    * @return
    * */
    public List<Question> selectall();
}
