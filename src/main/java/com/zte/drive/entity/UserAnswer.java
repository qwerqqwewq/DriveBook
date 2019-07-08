package com.zte.drive.entity;

import java.io.Serializable;

/**
 * @author dsf
 * @date 2019-07-03 8:52
 * Description:表t_user_answer的实体类
 */
public class UserAnswer implements Serializable{
    private Integer id;
    private User user;
    private Question question;
    private String answers;

    public UserAnswer() {
    }

    public UserAnswer(Integer id, String answers, Question question, User user) {
        this.id = id;
        this.answers = answers;
        this.question = question;
        this.user = user;
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

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "id=" + id +
                ", user=" + user +
                ", question=" + question +
                ", answers='" + answers + '\'' +
                '}';
    }
}