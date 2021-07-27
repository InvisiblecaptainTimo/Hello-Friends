package com.tianlang.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tianlang.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String result = "点击查询按钮";

        String city = request.getParameter("city");
        if (city != null && !"".equals(city.trim())) {
            result = city;
            ProvinceDao dao = new ProvinceDao();
            result = dao.queryProvinceById(Integer.valueOf(result));

        }
        out.println(result);
        out.flush();
        out.close();
    }
}
