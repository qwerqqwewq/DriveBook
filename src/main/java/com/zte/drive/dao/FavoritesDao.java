package com.zte.drive.dao;

import com.zte.drive.entity.Favorites;
import com.zte.drive.entity.User;

import java.util.List;

/**
 * @author  王卓君
 * Created by ASUS on 2019/7/3.
 */
public interface FavoritesDao {

    /**
     * @param favorites
     * @return  添加行数
     */
     int insert(Favorites favorites);

    /**
     * @param user,id
     * @return 删除行数
     */
     int delete(User user,Integer id);

    /**
     * @param user
     * @return 收藏列表
     */
     List<Favorites> select(User user);

    /**
     * @param user
     * @param num
     * @return 收藏的前几条数据
     */
     List<Favorites> selectByNum(User user,Integer num);
}
