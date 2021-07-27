<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax局部刷新</title>
    <script type="text/javascript">
        function doAjax(){
            //使用内存中的异步对象，代替浏览器发送请求。异步对象是用js创建和管理的
            //1、创建异步对象
            var xmlHttp = new XMLHttpRequest();

            //2、绑定事件：
            xmlHttp.onreadystatechange = function () {
                //alert("readyState属性值："+xmlHttp.readyState+"   status:"+xmlHttp.status)
                //处理服务端返回的数据，更新当前页面
                if (xmlHttp.readyState === 4 && xmlHttp.status === 200){
                    //alert(xmlHttp.responseText);//xmlHttp.responseText拿到的数据就是servlet里的print数据
                    var result = xmlHttp.responseText;
                    document.getElementById("result").innerText = result;//更新dom对象、更新页面数据
                }
            };

            //3、初始请求数据
            //获取dom对象的值：
            var name = document.getElementById("name").value;
            var w = document.getElementById("w").value;
            var h = document.getElementById("h").value;
            var ss = "?name="+name+"&h="+h+"&w="+w;

            xmlHttp.open("get","bmi"+ss,true);//这里没有/，只要servlet的别名

            //4、发情请求
            xmlHttp.send();
        }
    </script>
</head>

<body>
<p>用ajax局部刷新</p>
    用户：<input type="text" id="name"><br>
    身高m：<input type="text" id="h"><br>
    体重kg：<input type="text" id="w"><br>
    <input type="button" value="提交" onclick="doAjax()">
<div id="result">点击提交计算您的Bim...</div>
</body>
</html>
