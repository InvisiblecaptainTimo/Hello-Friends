<%@page contentType="text/html; utf-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<!--href��ֵֻ���൱��һ�����󣬶�Ӧ@RequestMapping��valueֵ������ֻ������web.xml�е����������������������ܱ�����������-->
    <a href="dosome.do">some</a><br>
    <a href="doother.do">other</a><br>

<a href="dosome.do" methods="get">get����</a><br>

<form action="doother.do" method="post">
    <input type="text" />
</form>
</body>
</html>
