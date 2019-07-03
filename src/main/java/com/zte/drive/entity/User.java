package com.zte.drive.entity;

/**
 * @author 邓胜峰
 * @date 2019-07-03 8:31
 * Description:<描述>
 */
public class User {
    // 用户ID
    private int id;
    // 密码
    private String password;
    // 用户名
    private String userName;
    // 注册时间
    private String registDate;

    // 无参构造
    public User() {

    }

    public User(int id, String password, String userName, String registDate) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.registDate = registDate;
    }

    // Getter与Setter开始
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }
    // Getter与Setter结束

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", registDate='" + registDate + '\'' +
                '}';
    }
}