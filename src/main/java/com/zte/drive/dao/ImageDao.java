package com.zte.drive.dao;

import com.zte.drive.entity.Image;

/**
 * @author lxj
 * Date:2019-07-03 8:46
 * Description:<描述>
 */
public interface ImageDao {
    /**
     * 插入一张图片
     * @param image 图片信息
     * @return 影响行数
     */
    public int insertImage(Image image);

    /**
     * 删除一张图片
     * @param id 图片id
     * @return 影响行数
     */
    public int deleteImage(Integer id);

    /**
     * 根据id选择一张图片
     * @param id 图片id
     * @return 选择的条目
     */
    public Image selectById(Integer id);

}
