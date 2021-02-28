<%--
  Created by IntelliJ IDEA.
  User: yanpengyin
  Date: 2021/2/28
  Time: 5:18 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>增加用户</title>
</head>
<body>
    <h1>展示用户</h1>
    <spring:eval expression="user.id"></spring:eval><br>
    <spring:eval expression="user.name"></spring:eval><br>
    <spring:eval expression="user.birthday"></spring:eval><br>
    <spring:eval expression="user.money"></spring:eval><br>
    <spring:eval expression="user.age"></spring:eval><br>
    <spring:eval expression="user.email"></spring:eval><br>
    <spring:eval expression="user.hobbies"></spring:eval><br>

</body>
</html>
