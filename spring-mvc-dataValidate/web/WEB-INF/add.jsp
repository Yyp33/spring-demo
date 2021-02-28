<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yanpengyin
  Date: 2021/2/28
  Time: 5:18 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加用户</title>
</head>
<body>
    <h1>普通form表单方式</h1>
    <form action="${pageContext.request.contextPath}/dataValidate01" method="post">
        id:<input type="text" name="id" value="${user.id}" >${errorMap.id}
        name:<input type="text" name="name" value="${user.name}" >${errorMap.name}
        birthday:<input name="birthday" type="text"  value="${user.birthday}">${errorMap.birthday}
        money:<input name="money" type="text"  value="${user.money}">${errorMap.money}
        age:<input name="age" type="text" value="${user.age}">${errorMap.age}
        email:<input name="email" type="text" value="${user.email}">${errorMap.email}
        hobbies:
        <input name="hobbies" type="checkbox" value="1" > 唱歌
        <input name="hobbies" type="checkbox" value="2" > 跳舞
        <input type="submit" value="提交">
    </form>
    <br>
    <br>
</body>
</html>
