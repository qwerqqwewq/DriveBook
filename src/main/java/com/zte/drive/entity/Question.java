package com.zte.drive.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author 刘煦健
 * @date 2019-07-03 8:18
 * Description:t_question表的实体对象
 */
public class Question implements Serializable{
    protected Integer id;

    protected Subject subject;
    protected String content;
    protected String options;
    protected String answers;
    protected Integer totalNum;
    protected Integer correctNum;
    protected String resolve;

    protected List<Type> types;

    public Question() {
    }

    public Question(Question question) {
        this.id = question.id;
        this.types = question.types;
        this.subject = question.subject;
        this.content = question.content;
        this.options = question.options;
        this.answers = question.answers;
        this.totalNum = question.totalNum;
        this.correctNum = question.correctNum;
        this.resolve = question.resolve;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", types='" + types + '\'' +
                ", subject=" + subject +
                ", content='" + content + '\'' +
                ", options='" + options + '\'' +
                ", answers='" + answers + '\'' +
                '}';
    }

    public String getResolve() {
        return resolve;
    }

    public void setResolve(String resolve) {
        this.resolve = resolve;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getCorrectNum() {
        return correctNum;
    }

    public void setCorrectNum(Integer correctNum) {
        this.correctNum = correctNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
