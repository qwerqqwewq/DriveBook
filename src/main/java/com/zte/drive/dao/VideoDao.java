package com.zte.drive.dao;

import com.zte.drive.entity.Video;

import java.util.List;

/**
 * @author lxj
 * Date:2019-07-03 8:46
 * Description:<描述>
 */
public interface VideoDao {
    /**
     * 插入一条视频
     * @param video
     * @return 插入行数
     */
    public int insertVideo(Video video);

    /**
     * 更新一条视频，要求视频id，只能更新title，intro和context
     * @param video
     * @return 更新行数
     */
    public int updateVideo(Video video);

    /**
     * 删除一条视频
     * @param id 视频id
     * @return 删除行数
     */
    public int deleteVideo(Integer id);

    /**
     * 查询所有视频
     * @return 所有视频
     */
    public List<Video> selectAll();

    /**
     * 查询从start到end的所有视频，start与end都是从0开始的，左闭右开
     * @param start
     * @param end
     * @return 视频列表
     */
    public List<Video> selectByRange(int start,int end);

    /**
     * 根据id查找视频
     * @param id 视频id
     * @return 视频
     */
    public Video selectById(Integer id);



}
