<%--
  Created by IntelliJ IDEA.
  User: ZHANG
  Date: 2019/10/25
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <form action="goLogin" method="post">
        username：<input type="text" name="username"><br>
        password：<input type="password" name="password"/><br>
        <input type="radio" value="student" name="position">学生
        <input type="radio" value="teacher" name="position">老师<br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
