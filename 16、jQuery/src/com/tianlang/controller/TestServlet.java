package com.tianlang.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String h = request.getParameter("shengao");
        String w = request.getParameter("tizhong");


        float hh = Float.valueOf(h)/100;
        float ww = Float.valueOf(w);

        out.println(ww/(hh*hh));
        out.flush();
        out.close();
    }
}
