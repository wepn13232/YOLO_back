package com.sprinboot.dazuoye.pojo;

public class addressInfo {
    private String address;
    private Integer sum;

    public addressInfo() {
        super();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public addressInfo(String address, Integer sum) {
        this.address = address;
        this.sum = sum;
    }
}
