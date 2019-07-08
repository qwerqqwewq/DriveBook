package com.zte.drive.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * @author dsf
 * @date 2019-07-03 8:40
 * Description:表t_question_comment的实体类
 */
public class QuestionComment implements Comparable<QuestionComment> {
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
        if (o == null || o.getCommentDate() == null) {
            return 1;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = sdf.parse(this.getCommentDate());
            Date d2 = sdf.parse(o.getCommentDate());
            return (int) ((d1.getTime() - d2.getTime())/(24*3600*1000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
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