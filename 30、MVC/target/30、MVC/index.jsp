<%@page contentType="text/html; utf-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<!--href的值只是相当于一个请求，对应@RequestMapping的value值，名字只有满足web.xml中的中央调度器的命名规则才能被调度器接收-->
    <a href="dosome.do">some</a><br>
    <a href="doother.do">other</a><br>

<a href="dosome.do" methods="get">get请求</a><br>

<form action="doother.do" method="post">
    <input type="text" />
</form>
</body>
</html>
