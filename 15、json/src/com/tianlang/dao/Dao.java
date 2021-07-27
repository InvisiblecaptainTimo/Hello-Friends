package com.tianlang.dao;

import com.tianlang.entity.Province;
import com.tianlang.jdbcutil.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
    JDBCUtil jdbcUtil = new JDBCUtil();
    Province province = new Province();

    public Province find(String city){
        String sql = "select * from city where city = ?";
        ResultSet rs = null;
        jdbcUtil.getConnection();
        PreparedStatement preparedStatement = jdbcUtil.getPrepareStatement(sql);

        try {
            preparedStatement.setString(1,city);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                province.setProvince(rs.getString("province"));
                province.setCity(rs.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.close(rs);
        }return province;
    }
}
