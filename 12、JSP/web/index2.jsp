<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" errorPage="index3.jsp" %><%--ture表示有内置对象session，false表示完全消灭内置对象session--%>

<%--
    page：   页面指令
    include：包含指令
    taglib： 标签库指令

指令格式：   <%@ 指令名 属性名=属性值 属性名= 属性值....%>

    page：
        contentType     设置JSP的响应内容类型
        pageEncoding    设置JSP响应时的字符编码方式
        import          组织导入
        session         设置当前JSP页面中是否可以直接使用session内置对象
        errorPage       错误页面(用于当前页面出错之后，需要跳转的页面)
        isErrorPage     是否是错误页面
        isELIgnored     是否忽略EL表达式
--%>

<%=
session
%>
<%HttpSession session1 = request.getSession(false);%> <%--表示获取内置对象session，false表示获取不到就返回null，true表示获取不到就新建--%>

<%
    String s = null;
    s.toString();
%>








