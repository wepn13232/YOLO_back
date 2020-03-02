package com.sprinboot.dazuoye.pojo;

public class PicWall {
    private Integer id;
    private String src;
    private String content;
    private String username;
    private String name;
    private String picUrl;


    public PicWall() {
        super();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public PicWall(String picUrl) {
        this.picUrl = picUrl;
    }

    public PicWall(Integer id, String src, String content, String username, String name) {
        this.id = id;
        this.src = src;
        this.content = content;
        this.username = username;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

}
