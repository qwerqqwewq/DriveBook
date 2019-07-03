package com.zte.drive.dao;

import com.zte.drive.entity.Favorites;

import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
public interface FavoritesDao {
    /**
     * ����һ���ղؼ�¼
     * @param favorites
     * @return ��������
     */
    public int insert(Favorites favorites);

    /**
     * ɾ��һ���ղؼ�¼
     * @param uid
     * @return ɾ������
     */
    public int delete(Integer uid);

    /**
     * ��ѯ�û������ղ�
     * @param uid
     * @return �ղؼ�
     */
    public List<Favorites> select(Integer uid);

    /**
     *�û���ѯǰNum���ղ�
     * @param uid,num
     * @return �ղؼ�
     */
    public List<Favorites> selectByNum(Integer uid,Integer num);
}
