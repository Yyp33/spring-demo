<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2021/2/18
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试传参</title>
</head>
<body>
    <h2>简单数据类型</h2>
    <form action ="${pageContext.request.contextPath}/params02">
        用户名<input type="text" name="userName">
        <input type="submit" value="提交">
    </form>
    <h2>复杂数据类型params03</h2>
    <form action ="${pageContext.request.contextPath}/params03">
        id<input type="text" name="id"><br>
        name<input type="text" name="name"><br>
        alias<input type="checkbox" name="alias" value="1" checked> 狗蛋
        <input type="checkbox" name="alias" value="2" checked> 二狗<br>
        hobbies<input type="text" name="hobbies" value="乒乓球">
        <input type="text" name="hobbies" value="羽毛球"><br>
        relative<input type="text" name="relative[father]" value="父亲">
        <input type="text" name="relative[mom]" value="母亲"><br>
        角色 <input type="text" name="role.name" value="用户角色"><br>
        friends<input type="text" name="friends[0].name" value="狗剩">
        <input type="text" name="friends[1].name" value="二狗"><br>
        时间<input type="text" name="date" value="2020-10-10"><br>

        <input type="submit" value="提交"><br>
    </form>

    <h2>复杂数据类型-多参数封装对象params04</h2>
    <form action ="${pageContext.request.contextPath}/params04">
        id<input type="text" name="user.id"><br>
        name<input type="text" name="user.name"><br>
        alias<input type="checkbox" name="user.alias" value="1" checked> 狗蛋
        <input type="checkbox" name="user.alias" value="2" checked> 二狗<br>
        hobbies<input type="text" name="user.hobbies" value="乒乓球">
        <input type="text" name="user.hobbies" value="羽毛球"><br>
        relative<input type="text" name="user.relative[father]" value="父亲">
        <input type="text" name="user.relative[mom]" value="母亲"><br>
        角色 <input type="text" name="user.role.name" value="用户角色"><br>
        friends<input type="text" name="user.friends[0].name" value="狗剩">
        <input type="text" name="user.friends[0].name" value="二狗"><br>
        新增用户<input type="text" name="role.name" value="新增用户"><br>
        时间<input type="text" name="user.date" value="2020-10-10"><br>
        <input type="submit" value="提交"><br>
    </form>
</body>
</html>
