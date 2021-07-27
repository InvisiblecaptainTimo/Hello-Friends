package com.tianlang;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration paraName = request.getParameterNames();//这个方法是将所有请求参数名保存到一个枚举对象里，访问需要迭代
        while (paraName.hasMoreElements()){
            String name= (String) paraName.nextElement();
            String value = request.getParameter(name);//这个方法能获得指定的请求参数的值
            System.out.println("请求参数："+name+"值："+value);
        }
    }
}
