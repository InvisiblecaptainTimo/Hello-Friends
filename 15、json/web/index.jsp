<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2021/6/23
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">

      function find() {
        //1创建对象
        var xmlHttp = new XMLHttpRequest();
        //2绑定事件
        xmlHttp.onreadystatechange = function () {
          if (xmlHttp.readyState === 4 && xmlHttp.status === 200){
            var data = xmlHttp.responseText;
            var jsonobj = eval("("+data+")");
            document.getElementById("city").value = jsonobj.province;
          }
        };
        //3初始化请求
        var province = document.getElementById("pro").value;
          xmlHttp.open("get","servlet?pro="+province,true);
        //4发送请求
        xmlHttp.send();
      }

    </script>
  </head>

  <body>
  <center>
    <p>Ajax利用Jason格式数据</p>
    <table>
      <tr>
        <td>城市</td>
        <td><input type="text" id="pro"></td>
        <td><input type="button" id="search" value="查询" onclick="find()"></td>
      </tr>
      <tr>
        <td>省份</td>
        <td><input type="text" id="city"></td>
      </tr>
    </table>
  </center>
  </body>
</html>
