package com.zte.drive.entity;


import java.io.Serializable;

public class Type implements Serializable{
    private Integer id;
    private String type;

    public Type(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Type() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
