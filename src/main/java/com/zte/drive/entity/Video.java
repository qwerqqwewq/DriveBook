package com.zte.drive.entity;

/**
 * @author 刘煦健
 * Date:2019-07-03 8:30
 * Description: T_VIDEO表实体类
 */
public class Video {
    private Integer id;
    private String title;
    private String intro;
    private String context;
    private String src;

    public Video() {
    }

    public Video(Integer id, String title, String intro, String context, String src) {
        this.id = id;
        this.title = title;
        this.intro = intro;
        this.context = context;
        this.src = src;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", context='" + context + '\'' +
                ", src='" + src + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
