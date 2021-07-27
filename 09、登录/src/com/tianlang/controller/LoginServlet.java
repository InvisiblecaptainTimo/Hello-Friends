package com.tianlang.controller;

import com.tianlang.DAO.JDBCUtil;
import com.tianlang.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        String sql = "select count(*) from user where userName = ? and password = ?";
        JDBCUtil util = new JDBCUtil();
        PreparedStatement preparedStatement = util.getPrepareStatement(sql);
        ResultSet resultSet = null;
        int result = 0;
        try {
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet.next());
            if (resultSet.next()){
                result = resultSet.getInt("count(*)");  // why？0
                System.out.println(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }

        if (result == 1){
            response.sendRedirect("succsses.html");
        }else {
            response.sendRedirect("false.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
