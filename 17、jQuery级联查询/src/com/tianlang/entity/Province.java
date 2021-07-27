package com.tianlang.entity;

public class Province {
    private String city;
    private String province;


    public Province() {
    }

    public Province(String city, String province) {
        this.city = city;
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
