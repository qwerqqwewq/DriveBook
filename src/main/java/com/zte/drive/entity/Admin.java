package com.zte.drive.entity;

/**
 * Author:helloboy
 * Date:2019-07-03 8:35
 * Description:<描述>
 */
public class Admin {
    private Integer id;
    private String pwd;
    private String name;
    private String registerDate;
    public Admin(Integer id, String pwd, String name, String registerDate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.registerDate = registerDate;
    }

    public Admin() {
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

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", registerDate='" + registerDate + '\'' +
                '}';
    }
}