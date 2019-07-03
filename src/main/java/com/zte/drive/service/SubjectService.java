package com.zte.drive.service;

import com.zte.drive.entity.Subject;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 9:23
 * Description:<描述>
 */
public interface SubjectService {
    //根据科目id查询
    public Subject findById(Integer id);
    //查询所有科目
    public List<Subject> findAll();
    //新增一个科目
    public void add(Subject subject);
    //更新一个科目信息
    public void modify(Subject subject);
    //根据ID删除一个科目
    public void remove(Integer id);



}
