package com.tianlang;

import com.tianlang.dao.UserDao;
import com.tianlang.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();

        List<User> userlist = dao.find();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<table border = '2' align = 'center'>");

        out.println("<tr>");
            out.println("<td>用户编号</td>");
            out.println("<td>用户姓名</td>");
            out.println("<td>用户密码</td>");
            out.println("<td>用户性别</td>");
            out.println("<td>用户邮箱</td>");
            out.println("<td></td>");
        out.println("</tr>");

        for (User user:userlist){
            out.println("<tr>");
            out.println("<td>"+user.getId()+"</td>");
            out.println("<td>"+user.getUserName()+"</td>");
            out.println("<td>"+user.getPassword()+"</td>");
            out.println("<td>"+user.getSex()+"</td>");
            out.println("<td>"+user.getEmail()+"</td>");
            out.println("<td><a href='/MyWeb/delete?userName="+user.getUserName()+"'>点击删除</a></td>");
            out.println("</tr>");
        }
    }
}
