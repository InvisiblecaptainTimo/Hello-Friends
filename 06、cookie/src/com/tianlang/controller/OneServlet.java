package com.tianlang.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Name"); //  用请求去读取界面的参数信息
        String money = request.getParameter("money");

        Cookie card1 = new Cookie("name",name);
        Cookie card2 = new Cookie("money",money);

        //Cookie设置有效时长时，会保存在硬盘上:    card1.setMaxAge(60);

        response.addCookie(card1);  //将Cookie写入到响应体
        response.addCookie(card2);  // 默认情况下，Cookie会和最后一个“/”前的路径绑定在一起。也可以调用方法实现指定路径绑定
        //card1.setPath("/MyWeb/index.html");    设置路径方法

        card1.setMaxAge(10);
        card2.setMaxAge(10);
        //通知Tomcat将点餐页面写到响应体，交给浏览器(请求转发方案)
        request.getRequestDispatcher("/diancan.html").forward(request,response);
    }
}
