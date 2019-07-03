package com.zte.drive.dao;

import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.Type;

import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
public interface MistakeDao {

    /**
     * 增加一条错题记录
     * @param mistake
     * @return  增加行数
     */
     public int insert(Mistake mistake);

    /**
     *删除一条错题记录
     * @param id
     * @return 删除行数
     */
    public int delete(Integer id);


    /**
     *  查询所有错题记录
    *@param
     * @return 试题列表
    */
    public List<Question> selectall();

    /**
     * 按错题id查询错题
     * @param id
     * @return 错题
     */
    public Question selectById(Integer id);

    /**
     * 按试题内容查询错题
     * @param content
     * @return 错题集
     */
    public List<Question> selectByContent(String content);

    /**
     *根据试题类型查询
     * @param type
     * @return 错题集
     */
     public List<Question> selectByType(Type type);

    /**
     * 查询最近错的前num道错题
     * @param
     * @return 错题集
     */
    public List<Question> selectByTime(Integer num);


}
