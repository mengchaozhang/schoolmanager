<%--
  Created by IntelliJ IDEA.
  User: ZHANG
  Date: 2019/10/25
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的假条</title>
</head>
<body>
<table>
    <table>
        <tr>
            <th>序号</th>
            <th>开始日期</th>
            <th>结束日期</th>
            <th>请假理由</th>
            <th>状态</th>
        </tr>
        <c:forEach items="${holidayList}" var="holiday" varStatus="i">
            <tr>
                <td>${i.count}</td>
                <td>${holiday.startDate}</td>
                <td>${holiday.endDate}</td>
                <td>${holiday.reason}</td>
                <c:if test="${holiday.state == 0}">
                    <td>待审核</td>
                </c:if>
                <c:if test="${holiday.state == 1}">
                    <td>审核通过</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</table>
</body>
</html>
