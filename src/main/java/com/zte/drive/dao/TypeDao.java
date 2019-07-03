package com.zte.drive.dao;

import com.zte.drive.entity.Type;

import java.util.List;
/**
 * Author:helloboy
 * Date:2019-07-03 8:45
 * Description:<描述>
 */
public interface TypeDao {
    Type selectById(Integer id);

    List<Type> selectAll();

    int insert(Type  type);

    int update(Type type);

    int deleteById(Integer id);

}
