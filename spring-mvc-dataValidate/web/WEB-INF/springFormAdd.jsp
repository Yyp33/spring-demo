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

    <h1>spring的form标签库提交(使用这个标签到达这个界面时model中需要包含一个user对象，即使这个对象是个空对象)</h1>
    <form:form action="${pageContext.request.contextPath}/dataValidate01" method="post">
        id:<form:input path="id" ></form:input><form:errors path="id"></form:errors>
        name:<form:input path="name" ></form:input><form:errors path="name"></form:errors>
        birthday:<form:input path="birthday" ></form:input><form:errors path="birthday"></form:errors>
        money:<form:input path="money" ></form:input><form:errors path="money"></form:errors>
        age:<form:input path="age" ></form:input><form:errors path="age"></form:errors>
        email:<form:input path="email" ></form:input><form:errors path="email"></form:errors>
        hobbies(String):<form:checkboxes path="hobbies" items="hobbiesList"></form:checkboxes>
<%--        hobbies(map):<form:checkboxes path="hobbies" items="hobbiesMap"></form:checkboxes>--%>
<%--        hobbies(obj):<form:checkboxes path="hobbies" items="hobbiesObjList" itemValue="key" itemLabel="value"> </form:checkboxes>--%>
        <input type="submit" value="提交">
    </form:form>
</body>
</html>
