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
     *根据用户id删除一条错题记录
     * @param uid,id
     * @return 删除行数
     */
    public int delete(Integer uid,Integer id);


    /**
     *  用户查询其所有错题记录
    *@param uid
     * @return 错题列表
    */
    public List<Mistake> selectall(Integer uid);

    /**
     * 用户按错题id查询错题
     * @param uid,id
     * @return 错题
     */
    public Mistake selectById(Integer uid,Integer id);

    /**
     * 按试题内容查询用户错题
     * @param uid,content
     * @return 错题集
     */
    public List<Question> selectByContent(Integer uid,String content);

    /**
     *用户根据试题类型查询
     * @param type
     * @return 错题集
     */
     public List<Question> selectByType(Integer uid,Type type);

    /**
     * 用户查询最近错的前num道错题
     * @param uid,num
     * @return 错题集
     */
    public List<Question> selectByTime(Integer uid,Integer num);
}
