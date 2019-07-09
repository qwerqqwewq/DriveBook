package com.zte.drive.service;

import com.zte.drive.entity.Favorites;
import com.zte.drive.entity.User;

import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
public interface FavoritesService {
    /**
     * @param favorites
     * @return  添加行数
     */
    int add(Favorites favorites);

    /**
     * @param user,id
     * @return 删除行数
     */
    int remove(User user,Integer id);

    /**
     * @param user,id
     * @return 删除行数
     */
    int removeall(User user);


    /**
     * @param user
     * @return 收藏列表
     */
    List<Favorites> find(User user);

    /**
     * @param user
     * @param num
     * @return 收藏的前几条数据
     */
    List<Favorites> findByNum(User user,Integer num);

    /**
     *
     * @param user
     * @param qid
     * @return
     */
    Favorites findByqid(User user,Integer qid);
}
