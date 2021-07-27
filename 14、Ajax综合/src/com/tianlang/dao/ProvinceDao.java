package com.tianlang.dao;

import com.tianlang.jdbcutil.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceDao {
    public String queryProvinceById(Integer provinceId){
        String sql = "select name from province where province = ?";
        JDBCUtil util = new JDBCUtil();
        util.getConnection();
        PreparedStatement preparedStatement = util.getPrepareStatement(sql);
        ResultSet resultSet =null;
        String name = "";
        try {
            preparedStatement.setInt(1,provinceId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                name = resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(resultSet);
        }
        return name;
    }
}
