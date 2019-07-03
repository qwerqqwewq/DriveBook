package com.zte.drive.dao;

import com.zte.drive.entity.Subject;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 8:44
 * Description:<描述>
 */
public interface SubjectDao {
    Subject selectById(Integer id);

    List<Subject> selectAll();

    int insert(Subject  subject);

    int update(Subject subject);

    int deleteById(Integer id);
    
    
    
}
