package com.zte.drive.service.impl;

import com.zte.drive.dao.VideoDao;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.Type;
import com.zte.drive.entity.Video;
import com.zte.drive.service.VideoService;
import com.zte.drive.utils.OptionUtil;
import com.zte.drive.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  lxj
 * Date:2019-07-03 14:12
 * Description:VideoService的实现
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;

    @Override
    public int addVideo(Video video) {
        return videoDao.insertVideo(video);
    }

    @Override
    public int modifyVideo(Video video) {
        return videoDao.updateVideo(video);
    }

    @Override
    public int removeVideo(Integer id) {
        return videoDao.deleteVideo(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Video> findAll() {
        return videoDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Video> findByRange(Integer start, Integer end) {
        return videoDao.selectByRange(start,end);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Video findById(Integer id) {
        return videoDao.selectById(id);
    }

    @Override
    public String uploadVideo(String dirpath, String filename, MultipartFile file) {
        //生成存储文件夹
        File dir = new File(dirpath);
        if (!dir.exists()) {
            //如果文件夹不存在
            //则创建
            dir.mkdirs();
        }
        String msg;
        File store = new File(dirpath, filename);
        try {
            file.transferTo(store);
            msg = "文件上传成功！";
        } catch (IOException | IllegalStateException e) {
            msg = "文件上传失败！";
            e.printStackTrace();
        }

        //返回操作信息
        return msg;
    }
}
