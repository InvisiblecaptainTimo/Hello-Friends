package com.tianlang;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 浏览器以GET方式发送请求，那么请求参数保存在请求头中
* 浏览器以POST方式发送请求，那么请求参数就保存在请求体中
* 当请求协议包送达服务器之后，服务器会对其进行解码，因为请求头的内容由Tomcat负责解码，而请求体的内容则由当前请求对象负责解码（request）
* Tomcat9.0解码时默认使用utf-8字符集，可以解码任何字符。而request使用的是ISO-8859-1，所以在解码汉字时会出现乱码
*
* 解决方法：
*  Post请求时，在读取到请求体内容之前，通知请求对象使用utf-8就好了
*
* */
public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        post请求的参数信息，在请求体中
        request.setCharacterEncoding("utf-8");//通知请求对象使用ut-8字符集
        String userName = request.getParameter("user");
        System.out.println("请求体的参数值："+userName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//get请求的参数信息，在请求头中
        String userName = request.getParameter("user");
        System.out.println("请求头的参数值："+userName);
    }
}
