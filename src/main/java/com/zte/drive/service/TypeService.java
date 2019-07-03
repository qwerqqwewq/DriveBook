package com.zte.drive.service;
import com.zte.drive.entity.Type;
import java.util.List;
/**
 * Author:helloboy
 * Date:2019-07-03 9:24
 * Description:<描述>
 */
public interface TypeService {
    //根据类型id查询
    public Type findById(Integer id);
    //查询所有类型
    public List<Type> findAll();
    //新增一个类型
    public void add(Type type);
    //更新一个类型信息
    public void modify(Type type);
    //根据ID删除一个类型
    public void remove(Integer id);



}
