package com.zte.drive.dao;

import com.zte.drive.entity.Image;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 8:44
 * Description:<描述>
 */
public interface ImageDao {
    Image selectById(Integer id);

    List<Image> selectAll();

    int insertImage(Image  image);

    int updateImage(Image image);

    int deleteById(Integer id);


}
