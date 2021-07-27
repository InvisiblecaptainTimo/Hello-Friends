package com.tianlang.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tianlang.dao.QueryDao;
import com.tianlang.entity.Province;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        QueryDao dao = new QueryDao();
        List<Province> list = dao.query();
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
