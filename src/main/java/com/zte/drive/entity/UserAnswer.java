package com.zte.drive.entity;

/**
 * @author dsf
 * @date 2019-07-03 8:52
 * Description:表t_user_answer的实体类
 */
public class UserAnswer {
    private Integer id;
    private User user;
    private Question question;
    private String answer;

    public UserAnswer() {
    }

    public UserAnswer(Integer id, String answer, Question question, User user) {
        this.id = id;
        this.answer = answer;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "id=" + id +
                ", user=" + user +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                '}';
    }
}