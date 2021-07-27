<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2021/6/30
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>级联查询</title>
    <style type="text/css">
      body{
        background-color: cornflowerblue;
      }
      #title{
        color: lime;
      }
      #city{
        width: 100px;
      }
      #province{
        width: 100px;
      }
    </style>
    <script type="text/javascript" src="jquery-3.6.0.js"></script>
    <script type="text/javascript">
      $(function () {
        $(document).ready(function () {
          $.ajax({url:"Query",
            dataType:"json",
            error:function () {
              alert("请求出现错误")
            },
            success:function (responseText) {
              $(responseText).each(function (i,e) {
                  $("#province").append("<option value="+e.city+">"+e.province+"</option>");
              })
            }
          });
        });

        $("#province").change(function () {
          var province = $("#province>option:selected").text();
          $.ajax({url:"city",
            data:{"province":province},
            dataType:"json",
            error:function () {
              alert("请求出现错误")
            },
            success:function (responseText) {
            $("#city").empty();
              $(responseText).each(function (i,e) {
                $("#city").append("<option value="+e.province+">"+e.city+"</option>");
              })
            }
          });
        })
      })
    </script>
  </head>
  <body>
    <center>
      <div>
        <h3 id="title">城市查询系统</h3>
        <table>
          <tr>
            <td><select id="province">
            </select>省</td>
          </tr>
          <tr>
            <td><select id="city"><option>----</option></select>市</td>
          </tr>
        </table>
      </div>
    </center>
  </body>
</html>
