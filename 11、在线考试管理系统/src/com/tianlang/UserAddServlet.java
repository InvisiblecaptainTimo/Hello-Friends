package com.tianlang;

import com.tianlang.dao.UserDao;
import com.tianlang.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDao dao = new UserDao();
        User user = null;
        PrintWriter out = null;
        int result = 0;
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");

        user = new User(null,userName,password,sex,email);

        result = dao.add(user);
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();

        if (result == 1){
            System.out.println("注册成功");
            out.println("<font style = 'color:red;font-size:40'>注册成功</font>");
            RequestDispatcher report = request.getRequestDispatcher("/find");
            try {
                report.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("注册失败");
            out.println("<font style = 'color:red;font-size:40px'>注册失败</font>");
        }
    }
}
