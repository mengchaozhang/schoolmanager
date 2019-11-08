package com.qf.pojo;

public class User {
    private int uid;
    private String username;
    private String password;
    private String position;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User(int uid, String username, String password, String position) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public User(String username, String password, String position) {
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
