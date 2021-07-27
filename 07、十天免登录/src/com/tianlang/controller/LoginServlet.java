package com.tianlang.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if ("Lance2497".equals(password)&&"530672168".equals(name)){
            String autologin = request.getParameter("AutoLogin");
            if ("ok".equals(autologin)){
                Cookie cookie1 = new Cookie("name",name);
                Cookie cookie2 = new Cookie("password",password);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                out.println("<font>登录成功，并且十天内免登录</font>");
            }else {
                out.println("<font>登录成功</font>");
            }
        }else {
            out.println("<font>登录失败</font>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
