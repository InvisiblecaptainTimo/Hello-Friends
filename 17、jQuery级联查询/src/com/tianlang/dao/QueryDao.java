package com.tianlang.dao;

import com.tianlang.entity.Province;
import com.tianlang.jdbcutil.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDao {
    public List<Province> query(){
        List<Province> list = new ArrayList<>();
        JDBCUtil jdbcUtil = new JDBCUtil();
        String sql = "select * from province";
        jdbcUtil.getConnection();
        PreparedStatement preparedStatement = jdbcUtil.getPrepareStatement(sql);
        ResultSet resultSet = null;
        try {

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Province province1 = new Province();
                String province = resultSet.getString("province");
                province1.setProvince(province);
                list.add(province1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.close();
        }return list;
    }
}
