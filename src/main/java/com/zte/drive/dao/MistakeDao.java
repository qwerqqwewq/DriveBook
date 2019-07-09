package com.zte.drive.dao;

import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.Type;
import com.zte.drive.entity.User;

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
      int insert(Mistake mistake);

    /**
     *根据用户id删除一条错题记录
     * @param user,id
     * @return 删除行数
     */
      int delete(User user,Integer id);

    /**
     * 用户删除所有ID
     */
      int deleteall(User user);

    /**
     *  用户查询其所有错题记录
    *@param user
     * @return 错题列表
    */
     List<Mistake> selectall(User user);

    /**
     * 用户按错题id查询错题
     * @param user,id
     * @return 错题
     */
     Mistake selectById(User user,Integer id);

    /**
     * 按试题内容查询用户错题
     * @param user,content
     * @return 错题集
     */
     List<Mistake> selectByContent(User user,String content);

    /**
     *用户根据试题类型查询
     * @param type
     * @return 错题集
     */
     List<Mistake> selectByType(User user,String type);

    /**
     * 用户查询最近错的前num道错题
     * @param user,num
     * @return 错题集
     */
     List<Mistake> selectByTime(User user,Integer num);

    /**
     * 用户根据试题ID查询试题
     */
    Mistake selectByqid(User user,Integer qid);
}
