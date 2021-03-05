<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: YYP
  Date: 2021-03-05
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>登录-国际化</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">



    <link href="${ctx}/assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="${ctx}/assets/signin.css" rel="stylesheet">
</head>
<body class="text-center">

<main class="form-signin">
    <form>
        <img class="mb-4" src="${ctx}/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
        <h1 class="h3 mb-3 fw-normal"><fmt:message key="welcome"/></h1>
        <label for="inputEmail" class="visually-hidden"><fmt:message key="email"></fmt:message></label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="visually-hidden"><fmt:message key="password"></fmt:message></label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> <fmt:message key="remember"></fmt:message>
            </label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit"><fmt:message key="button"></fmt:message></button>
        <%--上边可以根据浏览器的语言自动转换，我们也可以自己转化--%>
        <a href="${ctx}/change1?locale=zh_CN">中文</a>
        <a href="${ctx}/change1?locale=en_US">英文</a>
        <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
    </form>
</main>



</body>
</html>
