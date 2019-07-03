package com.zte.drive.entity;

/**
 * @author 刘煦健
 * @date 2019-07-03 8:21
 * Description:t_type表的实体类
 */
public class Type {
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
