<%--
  Created by IntelliJ IDEA.
  User: Saber
  Date: 2022/3/23
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="../css/login.css" rel="stylesheet">
</head>

<body>

<div id="loginDiv" style="height: 350px">
    <form action="/B12_LoginRegisteredCase01_war/login" id="form" method="post">
        <h1 id="loginMsg">LOGIN IN</h1>

        <div id="errorMsg">${register_msg}</div>

        <p>Username:<input id="username" name="username" type="text" value="${username}"></p>
        <p>Password:<input id="password" name="password" type="password" value="${password}"></p>

        <p>Remember:<input id="remember" name="remember" type="checkbox"></p>

        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>

</div>

</body>
</html>
