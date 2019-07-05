package com.zte.drive.service;

import com.zte.drive.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
/**
 * Author:helloboy
 * Date:2019-07-03 9:24
 * Description:<描述>
 */
public interface ImageService {
    //根据类型id查询图片
    public Image findById(Integer id);
    //查询所有图片
    public List<Image> findAll();
    //新增一张图片
    public void add(Image image);
    //更新一个图片信息
    public void modify(Image image);
    //根据ID删除一张图片
    public void remove(Integer id);
    //上传图片
    public String uploadImage(String dirpath, String filename, MultipartFile file);

}
