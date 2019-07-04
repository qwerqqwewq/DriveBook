package com.zte.drive.service.impl;

import com.zte.drive.dao.ImageDao;
import com.zte.drive.entity.Image;
import com.zte.drive.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 9:01
 * Description:<描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDao image;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Image findById(Integer id) {
        return image.selectById(id);
    }

    @Override
    public List<Image> findAll() {
        return image.selectAll();
    }
    //
    @Override
    public void add(Image image) {
        this.image.insertImage(image);
    }

    @Override
    public void modify(Image image) {
        this.image.updateImage(image);
    }

    @Override
    public void remove(Integer id) {
        this.image.deleteById(id);
    }

}
