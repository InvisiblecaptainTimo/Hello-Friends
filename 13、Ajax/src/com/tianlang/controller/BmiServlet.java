package com.tianlang.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BmiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String hh = request.getParameter("h");
        String ww =request.getParameter("w");

        float w = Float.valueOf(ww);
        float h = Float.valueOf(hh);

        float bmi = w/(h*h);
        out.println(name+"的Bim是:"+bmi);
        out.flush();
        out.close();

//全局刷新机制：
/*
        request.setAttribute("bmi",bmi);
        request.setAttribute("name",name);
        request.getRequestDispatcher("/result.jsp").forward(request,response);

//HttpServletResponse输出数据：
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(name);
        out.println(bmi);
        out.flush();
        out.close();
 */
    }
}
