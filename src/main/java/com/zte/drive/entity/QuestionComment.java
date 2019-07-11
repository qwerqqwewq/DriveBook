package com.zte.drive.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * @author dsf
 * @date 2019-07-03 8:40
 * Description:表t_question_comment的实体类
 */
public class QuestionComment implements Comparable<QuestionComment>,Serializable {
    private Integer id;
    private User user;
    private Question question;

    private String content;
    private String commentDate;

    QuestionComment questionComment;

    Set<QuestionComment> comments;

    private Integer commentNumber;

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Set<QuestionComment> getComments() {
        return comments;
    }

    public void setComments(Set<QuestionComment> comments) {
        this.comments = comments;
    }

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

    @Override
    public int compareTo(QuestionComment o) {
        if (o == null) {
            return 1;
        }
        return this.getId() - o.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        QuestionComment that = (QuestionComment) o;

        return !(getId() != null ? !getId().equals(that.getId()) : that.getId() != null);

    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}