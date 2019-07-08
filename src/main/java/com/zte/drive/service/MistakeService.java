package com.zte.drive.service;

import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.User;

import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
public interface MistakeService {
    /**
     * 增加一条错题记录
     * @param mistake
     * @return  增加行数
     */
    int add(Mistake mistake);

    /**
     *根据用户id删除一条错题记录
     * @param user,id
     * @return 删除行数
     */
    int remove(User user,Integer id);

    /**
     * 用户删除所有ID
     */
    int removeall(User user);

    /**
     *  用户查询其所有错题记录
     *@param user
     * @return 错题列表
     */
    List<Mistake> findall(User user);

    /**
     * 用户按错题id查询错题
     * @param user,id
     * @return 错题
     */
    Mistake findById(User user,Integer id);

    /**
     * 按试题内容查询用户错题
     * @param user,content
     * @return 错题集
     */
    List<Mistake> findByContent(User user,String content);

    /**
     *用户根据试题类型查询
     * @param type
     * @return 错题集
     */
    List<Mistake> findByType(User user,String type);

    /**
     * 用户查询最近错的前num道错题
     * @param user,num
     * @return 错题集
     */
    List<Mistake> findByTime(User user,Integer num);

    /**
     * 用户根据试题iD查询试题
     * @param user
     * @param qid
     * @return
     */
    Mistake findByqid(User user,Integer qid);
}
