package com.zte.drive.dao;

import com.zte.drive.entity.Admin;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 8:44
 * Description:<描述>
 */
public interface AdminDao {
    Admin selectById(Integer id);

    List<Admin> selectAll();

    int insertAdmin(Admin  admin);

    int updateAdmin(Admin admin);

    int deleteById(Integer id);

    Admin selectByName(String name);


}
