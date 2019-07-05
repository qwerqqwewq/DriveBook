<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <title>成功</title>
</head>
<body>
操作成功！
<a href="${pageContext.request.contextPath}/fav/find" >查询</a>
</body>
<form action="${pageContext.request.contextPath}/fav/add" method="post">
    <input type="text" name="questionId">
    <input type="submit">
    </form>
</html>
