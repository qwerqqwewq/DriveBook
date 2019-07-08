<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
<c:forEach  items="${list}" var="list">
    用户ID：${list.user.id} &nbsp;
    题目ID：${list.question.id} &nbsp;
    答案：${list.answers}<br>
</c:forEach>
</body>
</html>
