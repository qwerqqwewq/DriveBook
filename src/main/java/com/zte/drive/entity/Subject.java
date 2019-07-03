package com.zte.drive.entity;

/**
 * @author 刘煦健
 * @date 2019-07-03 8:22
 * Description:<描述>
 */
public class Subject {
    private Integer id;
    private String subject;

    public Subject(Integer id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public Subject() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                '}';
    }
}
