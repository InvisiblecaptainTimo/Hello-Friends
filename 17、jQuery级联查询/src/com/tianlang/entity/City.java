package com.tianlang.entity;

public class City {
    String province;
    String city;

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public City(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public City() {
    }
}
