package com.kinlhp.spring.mvc.model;

public class User {
    private String guid;
    private String name;
    private String password;
    private String password2;
    private String userId;

    public User() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User [guid=" + guid + ", name=" + name + ", password=" + password + ", password2=" + password2
                + ", userId=" + userId + "]";
    }
}
