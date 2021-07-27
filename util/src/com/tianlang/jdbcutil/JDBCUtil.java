package com.tianlang.jdbcutil;

import java.sql.*;

public class JDBCUtil {
    Connection conn = null;
//    Statement stm = null;
    PreparedStatement pstm = null;

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tianlang","root","Lance2497");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
/*
    public Statement getStatement(){
        try {
            stm = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stm;
    }
*/
    public PreparedStatement getPrepareStatement(String sql){
        try {
            pstm = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstm;
    }

    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(){
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
