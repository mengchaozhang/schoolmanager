<%--
  Created by IntelliJ IDEA.
  User: ZHANG
  Date: 2019/10/25
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <c:if test="${user.position == 'student'}">
        <a href="addHoliday">发起请假</a>
        <a href="fakeStrip">我的假条</a>
    </c:if>

    <c:if test="${user.position == 'teacher'}">
        <a href="getApproveHolidays">待审批假条</a>
    </c:if>
</body>
</html>
