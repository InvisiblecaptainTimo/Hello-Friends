<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2021/6/9
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>全局刷新</title>
  </head>
  <body>
  <p>全局刷新BMI</p>
  <form action="/13Ajax_war_exploded/bmi" method="get">
    用户：<input type="text" name="name"><br>
    身高m：<input type="text" name="h"><br>
    体重kg：<input type="text" name="w"><br>
    <input type="submit" value="提交">
  </form>
  </body>
</html>
