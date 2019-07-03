package com.zte.drive.dao;

import com.zte.drive.entity.Favorites;

import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
public interface FavoritesDao {
    /**
     * 增加一条收藏记录
     * @param favorites
     * @return 增加行数
     */
    public int insert(Favorites favorites);

    /**
     * 删除一条收藏记录
     * @param uid
     * @return 删除行数
     */
    public int delete(Integer uid);

    /**
     * 查询用户所有收藏
     * @param uid
     * @return 收藏夹
     */
    public List<Favorites> select(Integer uid);

    /**
     *用户查询前Num个收藏
     * @param uid,num
     * @return 收藏夹
     */
    public List<Favorites> selectByNum(Integer uid,Integer num);
}
