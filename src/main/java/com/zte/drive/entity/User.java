package com.zte.drive.entity;

/**
 * @author dsf
 * @date 2019-07-03 8:18
 * Description:t_user表的实体对象
 */
public class User {
    private Integer id;
    private String pwd;
    private String name;
    private String registDate;

    public User() {
    }

    public User(Integer id, String pwd, String name, String registDate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.registDate = registDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", registDate='" + registDate + '\'' +
                '}';
    }
}
