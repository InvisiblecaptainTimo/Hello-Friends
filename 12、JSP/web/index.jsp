<%@page contentType="text/html;charset=UTF-8" %>

<%!
        public void doSome(){}
%>
hello word!
<br>
out.println("<br>");
<%
    System.out.println("阿萨的韩国");
%>

<br>

<html>
<body>
<input type="button" value="check me">
</body>
</html>

<br>

<input type="button" value="check you">

<br>
    out.write("qweas")

<br>

<%
    out.write("sada");
%>

<br>

<%
    out.println("page="+page);
    out.println("<br>");
    out.println("pageContext="+pageContext);
    out.println("<br>");
    out.println("request="+request);
    out.println("<br>");
    out.println("session="+session);
    out.println("<br>");
    out.println("application="+application);
    out.println("<br>");
    out.println("out="+out);
    out.println("<br>");
    out.println("response="+response);
    out.println("<br>");
    out.println("config="+config);
%>

<%
    for (int i = 1;i<6;i++){
%>
    <h<%out.print(i);%>>字体<h<%=i%>>
<%
    }
%>



