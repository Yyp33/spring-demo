<%--
  Created by IntelliJ IDEA.
  User: YYP
  Date: 2021-03-04
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/upload01" method="post" enctype="multipart/form-data">
        <input type="file" name="myfile">
        <input type="submit" value="上传文件">
    </form>
</body>
</html>
