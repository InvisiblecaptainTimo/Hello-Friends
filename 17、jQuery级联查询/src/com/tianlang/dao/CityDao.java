package com.tianlang.dao;

import com.tianlang.entity.City;
import com.tianlang.entity.Province;
import com.tianlang.jdbcutil.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
    public List<City> query(String provinceid){
        List<City> list = new ArrayList<>();
        JDBCUtil jdbcUtil = new JDBCUtil();
        String sql = "select * from city where province = ?";
        jdbcUtil.getConnection();
        PreparedStatement preparedStatement = jdbcUtil.getPrepareStatement(sql);
        ResultSet resultSet = null;
        try {
            preparedStatement.setString(1,provinceid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                City city = new City();
                String province = resultSet.getString("province");
                String city1 = resultSet.getString("city");
                city.setProvince(province);
                city.setCity(city1);
                list.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.close();
        }return list;
    }
}
