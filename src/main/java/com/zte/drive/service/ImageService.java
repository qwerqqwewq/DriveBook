package com.zte.drive.service;

import com.zte.drive.entity.Image;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lxj
 * Date:2019-07-03 15:42
 * Description:图片服务接口
 */
public interface ImageService {

    /**
     * 增加图片记录
     * @param image
     * @return
     */
    public int addImage(Image image);

    /**
     * 修改图片记录
     * @param image
     * @return
     */
    public int modifyImage(Image image);

    /**
     * 根据id查找图片记录
     * @param id
     * @return
     */
    public Image findById(Integer id);

    /**
     * 根据id移除图片记录
     * @param id
     * @return
     */
    public int removeImage(Integer id);

    /**
     * 上传图片
     * @param dirpath 保存文件夹
     * @param filename 文件名
     * @param file 从form中传递的file文件
     * @return
     */
    public String uploadImage(String dirpath, String filename, MultipartFile file);
}
