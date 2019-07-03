package com.zte.drive.entity;

/**
 * @author dsf
 * @date 2019-07-03 8:40
 * Description:表t_question_comment的实体类
 */
public class QuestionComment {
    private Integer id;
    private User user;
    private Question question;

    private String content;
    private String commentDate;

    QuestionComment questionComment;

    public QuestionComment() {
    }

    public QuestionComment(Integer id, User user, Question question, String content, String commentDate, QuestionComment questionComment) {
        this.id = id;
        this.user = user;
        this.question = question;
        this.content = content;
        this.commentDate = commentDate;
        this.questionComment = questionComment;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public QuestionComment getQuestionComment() {
        return questionComment;
    }

    public void setQuestionComment(QuestionComment questionComment) {
        this.questionComment = questionComment;
    }

    @Override
    public String toString() {
        return "QuestionComment{" +
                "id=" + id +
                ", user=" + user +
                ", question=" + question +
                ", content='" + content + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", questionComment=" + questionComment +
                '}';
    }
}