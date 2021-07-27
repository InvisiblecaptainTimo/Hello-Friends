<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2021/6/7
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
<%--
    九大内置对象：
    PageContext     javax.servlet.jsp.PageContext               页面范围(不能跨页面)
    request         javax.servlet.http.HttpServletRequest       请求范围（不能跨请求）
    session         javax.servlet.http.HttpSession              会话范围（不能跨会话）
    application     javax.servlet.ServletContext                应用范围（所用用户共享）
    response        javax.servlet.http.HttpServletResponse      响应对象
    out             javax.servlet.jsp.JspWriter                 标准输出流
    config          javax.servlet.ServletConfig                 Servlet配置信息对象
    exception       java.lang.Throwable                         异常引用(isError="true")
    Page            javax.servlet.http.HttpServlet              几乎不用

    四大作用域对象：
    PageContext < request < session < application
--%>