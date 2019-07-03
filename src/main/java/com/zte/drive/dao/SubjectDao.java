package com.zte.drive.dao;

import com.zte.drive.entity.Subject;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 8:44
 * Description:<描述>
 */
public interface SubjectDao {
    public Subject selectById(Integer id);

    public List<Subject> selectAll();

    public int insertSubject(Subject  subject);

    public int updateSubject(Subject subject);

    public int deleteById(Integer id);
    
    
    
}
