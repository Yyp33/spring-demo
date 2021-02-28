<%--
  Created by IntelliJ IDEA.
  User: YYP
  Date: 2021-02-24
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    id:${requestScope.user.id}
<%--    spring:eval 标签可以按照格式输出对象的属性--%>
    birthday:    <spring:eval expression=" requestScope.user.date"></spring:eval>
<br>
</body>
</html>
