<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2021/6/10
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>根据城市获取省份</title>
    <script type="text/javascript">
      function search() {
        //1创建对象
        var xmlHttp = new XMLHttpRequest();
        //2绑定事件
        xmlHttp.onreadystatechange = function () {
          if (xmlHttp.readyState === 4 && xmlHttp.status === 200){
            document.getElementById("province").innerText = xmlHttp.responseText;
          }
        };
        //3初始化请求
        var  city = document.getElementById("city").value;
        xmlHttp.open("get","MyServlet?city="+city,true);
        //4发送请求
        xmlHttp.send();
      }
    </script>
  </head>
  <body>
  <center>
    城市：<input type="text" id="city" ><br>
    省份：<span id="province"></span><br>
  <input type="button" value="查询" onclick="search()">
  </center>
  </body>
</html>
