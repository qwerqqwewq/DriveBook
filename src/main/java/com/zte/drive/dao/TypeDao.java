package com.zte.drive.dao;

import com.zte.drive.entity.Type;

import java.util.List;
/**
 * Author:helloboy
 * Date:2019-07-03 8:45
 * Description:<描述>
 */
public interface TypeDao {
    public Type selectById(Integer id);

    public List<Type> selectAll();

    public int insertType(Type  type);

    public int updateType(Type type);

    public int deleteById(Integer id);

    public Integer selectByType(String mytype);

}
