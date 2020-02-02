package com.sprinboot.dazuoye.pojo;

public class Host {
    private Integer id;
    private String username;
    private String name;
    private String appid;
    private String title;
    private String roomSum;
    private Boolean isLive;

    public Host() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoomSum() {
        return roomSum;
    }

    public void setRoomSum(String roomSum) {
        this.roomSum = roomSum;
    }

    public Boolean getLive() {
        return isLive;
    }

    public void setLive(Boolean live) {
        isLive = live;
    }

    public Host(Integer id, String username, String name, String appid, String title, String roomSum, Boolean isLive) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.appid = appid;
        this.title = title;
        this.roomSum = roomSum;
        this.isLive = isLive;
    }
}
