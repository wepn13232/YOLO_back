package com.sprinboot.dazuoye.pojo;

public class Sub {
    private Integer id;
    private String subUser;
    private Integer picId;
    private Integer subCount;


    public Sub() {
        super();
    }

    public Integer getSubCount() {
        return subCount;
    }

    public void setSubCount(Integer subCount) {
        this.subCount = subCount;
    }

    public Sub(String subUser) {
        this.subUser = subUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubUser() {
        return subUser;
    }

    public void setSubUser(String subUser) {
        this.subUser = subUser;
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Sub(Integer id, String subUser, Integer picId) {
        this.id = id;
        this.subUser = subUser;
        this.picId = picId;
    }
}
