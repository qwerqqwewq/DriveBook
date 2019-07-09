<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/userAnswer/getUserInfo/do" method="post">
        用户ID：<input id="uid" name="uid" type="text"><br>
        科目ID：<input id="sid" name="sid" type="text"><br>
        <input type="submit" value="查询">
    </form>
</body>
</html>
