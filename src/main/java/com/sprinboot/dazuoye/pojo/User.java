package com.sprinboot.dazuoye.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String username;//用户名
    private String name; //昵称
    private String password;//密码
    private Integer id; //id
    private String email; //邮箱
    private String sex; //性别
    private String address; //地址
    private String appid; //直播编码
    private String userSum; //用户简介
    private String liveStatus; //直播状态


    public User() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getUserSum() {
        return userSum;
    }

    public void setUserSum(String userSum) {
        this.userSum = userSum;
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    public User(String username, String name, String password, Integer id, String email, String sex, String address, String appid, String userSum, String liveStatus) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.id = id;
        this.email = email;
        this.sex = sex;
        this.address = address;
        this.appid = appid;
        this.userSum = userSum;
        this.liveStatus = liveStatus;
    }
}
