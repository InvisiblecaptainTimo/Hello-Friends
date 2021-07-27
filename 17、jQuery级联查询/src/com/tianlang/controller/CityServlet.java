package com.tianlang.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tianlang.dao.CityDao;
import com.tianlang.entity.City;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String province = request.getParameter("province");//这里获取到的值是$.ajax()里提交的值
        response.setContentType("application/json;charset=utf-8");
        CityDao cityDao = new CityDao();
        List<City> list = cityDao.query(province);
        String json = "{}";

        if (list != null){
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(list);
        }
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
