package com.zte.drive.service;

import com.zte.drive.entity.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author lxj
 * Date:2019-07-03 14:03
 * Description:视频插入的Service接口
 */
public interface VideoService {

    /**
     * 添加一个视频
     * @param video
     * @return
     */
    public int addVideo(Video video);

    /**
     * 修改一个视频
     * @param video
     * @return
     */
    public int modifyVideo(Video video);

    /**
     * 移除一个视频
     * @param id
     * @return
     */
    public int removeVideo(Integer id);

    /**
     * 查找所有视频
     * @return
     */
    public List<Video> findAll();

    /**
     * 根据范围查找视频，从0开始，左闭右开
     * @param start
     * @param end
     * @return
     */
    public List<Video> findByRange(Integer start, Integer end);

    /**
     * 根据id查找视频
     * @param id
     * @return
     */
    public Video findById(Integer id);

    /**
     * 上传视频
     * @param dirpath 视频存储路径
     * @param filename 存储后的文件名
     * @param file 表单上传来的MultipartFile
     * @return
     */
    public String uploadVideo(String dirpath, String filename, MultipartFile file);

}
