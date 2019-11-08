<%--
  Created by IntelliJ IDEA.
  User: ZHANG
  Date: 2019/10/25
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>审批列表</title>
</head>
<body>
<table>
    <tr>
        <th>序号</th>
        <th>申请人</th>
        <th>开始日期</th>
        <th>结束日期</th>
        <th>请假理由</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${holidayList}" var="holiday" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${holiday.user.username}</td>
            <td>${holiday.startDate}</td>
            <td>${holiday.endDate}</td>
            <td>${holiday.reason}</td>
           <td><a href="updateHoliday?hid=${holiday.hid}">审批通过</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
