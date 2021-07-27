package com.tianlang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tianlang.entity.Province;

public class TestJson {
    public static void main(String[] args) {
        Province province = new Province();
        province.setProvince(1);
        province.setName("湖南");

        //利用Jackson把p转换为json数据
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //writeValueAsString：把参数的Java对象转换为json格式的字符串
            String json = objectMapper.writeValueAsString(province);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
