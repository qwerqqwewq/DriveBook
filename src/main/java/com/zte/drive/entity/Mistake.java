package com.zte.drive.entity;

import java.io.Serializable;

/**
 * @author 王卓君
 * Created by ASUS on 2019/7/3.
 */
public class Mistake implements Serializable {
    private Integer id;

    //外键映射成实体类对象
    private User user;
    private Question question;

    private String createDate;

    public Mistake() {
    }

    public Mistake(Integer id,String createDate) {
        this.id = id;
        this.createDate=createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Mistake{" +
                "id=" + id +
                ", user=" + user +
                ", question=" + question +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
