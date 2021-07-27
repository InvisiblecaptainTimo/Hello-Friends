package com.tianlang.dao;

import com.tianlang.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    JDBCUtil util = new JDBCUtil();

    public int add(User user){
        int result =0;
        String sql = "insert into user(userName,password,sex,email) values(?,?,?,?)";
        PreparedStatement ps = util.getPrepareStatement(sql);
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    public List find(){
        List<User> userlist = new ArrayList();
        String sql = "select * from user";
        PreparedStatement ps = util.getPrepareStatement(sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()){
//                int userid = rs.getInt("userId");
                String userName = rs.getString("userName");
                String userPassword = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");

                User user = new User(null,userName,userPassword,sex,email);
                userlist.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }return userlist;
    }

    public int delete(String userName){
        String sql = "delete from user where userName = ?";
        PreparedStatement preparedStatement = util.getPrepareStatement(sql);
        int result = 0;
        try {
            preparedStatement.setString(1,userName);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }return result;
    }

    public int login(String userName,String password){
        String sql = "select count(*) from user where userName = ? and password = ?";
        PreparedStatement preparedStatement = util.getPrepareStatement(sql);
        ResultSet resultSet = null;
        int result = 0;
        try {
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result = resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }return result;
    }
}
