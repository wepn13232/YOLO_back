package com.sprinboot.dazuoye.pojo;

public class EssayComment {
    private Integer id;
    private String username;
    private String name;
    private Integer essayId;
    private String date;
    private String comment;
    private String picUrl;


    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public EssayComment(String picUrl) {
        this.picUrl = picUrl;
    }

    public EssayComment() {
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

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public EssayComment(Integer id, String username, String name, Integer essayId, String date, String comment) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.essayId = essayId;
        this.date = date;
        this.comment = comment;
    }
}
