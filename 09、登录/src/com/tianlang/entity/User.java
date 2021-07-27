package com.tianlang.entity;

public class User {
    private Integer id;
    private String userName;
    private String password;
    private String sex;
    private String email;

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(Integer id, String userName, String password, String sex, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }
}