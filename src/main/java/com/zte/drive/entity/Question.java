package com.zte.drive.entity;

/**
 * @author 刘煦健
 * @date 2019-07-03 8:18
 * Description:t_question表的实体对象
 */
public class Question {
    protected Integer id;
    protected String types;
    protected Subject subject;
    protected String content;
    protected String option;
    protected String answer;
    protected Integer totalNum;
    protected Integer correctNum;
    protected String resolve;

    public Question() {
    }

    public Question(Question question) {
        this.id = question.id;
        this.types = question.types;
        this.subject = question.subject;
        this.content = question.content;
        this.option = question.option;
        this.answer = question.answer;
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
                ", option='" + option + '\'' +
                ", answer='" + answer + '\'' +
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

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
