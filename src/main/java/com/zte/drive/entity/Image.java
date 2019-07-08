package com.zte.drive.entity;

import java.io.Serializable;

/**
 * @author helloboy
 * Date:2019-07-03 8:33
 * Description: T_IMAGE表实体类
 */
public class Image implements Serializable{
    private Integer id;
    private String src;

    public Image() {
    }

    public Image(Integer id, String src) {
        this.id = id;
        this.src = src;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", src='" + src + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

}
