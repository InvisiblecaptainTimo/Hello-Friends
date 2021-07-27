package com.tianlang.dao;

import com.tianlang.entity.Province;

public class Text {
    public static void main(String[] args) {
        Dao dao = new Dao();
        Province province = dao.find("怀化");
        System.out.println(province.getProvince());
    }
}
