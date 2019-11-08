<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2019/10/25
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>请假列表</title>
</head>
<body>
    <form action="saveHoliday" method="post">
        开始日期：<input type="date" name="startDate"/><br>
        结束日期：<input type="date" name="endDate"/><br>
        请假理由：<input type="text" name="reason"><br>
        选择审批老师：<select name="teaName">
                    <c:forEach items="#{teacherList}" var="teacher">
                        <option>${teacher.username}</option>
                    </c:forEach>
                </select><br>
        <input type="submit">
    </form>
</body>
</html>
