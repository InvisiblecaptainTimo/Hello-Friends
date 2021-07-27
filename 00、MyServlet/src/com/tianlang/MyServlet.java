package com.tianlang;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    public MyServlet() {
        System.out.println("调用了一次构造方法");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("一次Get请求");
        //执行结果:
        String result = "hello habagou<br/>";
        String re = "英雄联盟<br/>地下城与勇士<br/>梦幻西游</br>";
        // 响应对象将结果写入到响应体：
//      1、通过响应对象，向Tomcat索要输出流：(如果要使用HTML标签语言，需要在得到输出流之前就设置content-type属性,即告诉浏览器使用对应的编译器；要显示中文，需设置字符集属性charset)
        resp.setContentType("text/html;charset=utf-8");
//        resp.sendRedirect("http://www.baidu.com");//sendRedirect()方法能把字符串赋值给响应头中的location属性，浏览器一旦发现响应头中由location属性，就会向location的地址发送请求信息
        PrintWriter out = resp.getWriter();
//        通过输出流，将结果以二进制数据写入响应体
        out.write(result);
        //write()方法在写入ing型数字的时候，会把数字当成ASCII码，所以实际开发中一般选用print()方法
        out.write(50);
        out.println("<br/>");
        out.println(50);
        out.println("<br/>");
        out.println(re);
//----------------------------------------------------------------------------------------------------------------------------------------
        String url = req.getRequestURL().toString();//这个方法获取url
        String method = req.getMethod();//这个方法获取请求方式
        String uri = req.getRequestURI();//这个方法获取uri
        System.out.println("url="+url);
        System.out.println("method="+method);
        System.out.println("URI="+uri);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("一次Post请求");
    }
}
