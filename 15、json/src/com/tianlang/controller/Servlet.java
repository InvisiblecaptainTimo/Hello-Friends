package com.tianlang.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tianlang.dao.Dao;
import com.tianlang.entity.Province;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Province province = new Province();
        String json = "{}";
        String pro = request.getParameter("pro");
        if (null != pro){
            Dao dao = new Dao();
            province = dao.find(pro);

            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(province);
        }
        out.println(json);
        out.flush();
        out.close();
    }
}
