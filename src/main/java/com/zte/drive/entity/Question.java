package com.zte.drive.entity;

/**
 * @author 刘煦健
 * @date 2019-07-03 8:18
 * Description:t_question表的实体对象
 */
public class Question {
    private Integer id;
    private Type type;
    private Subject subject;

    public Question() {
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", type=" + type +
                ", subject=" + subject +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
