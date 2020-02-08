package com.sprinboot.dazuoye.pojo;

public class addressInfo {
    private String address;
    private Integer num;

    public addressInfo() {
        super();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public addressInfo(String address, Integer num) {
        this.address = address;
        this.num = num;
    }
}
