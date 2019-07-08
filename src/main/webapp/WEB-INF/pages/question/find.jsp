<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>按用户查询所有答案</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/userAnswer/findByUser/do" method="post">
    用户ID：<input id="uid" name="uid" type="text"><br>
    <input type="submit" value="查询">
</form>

<form action="${pageContext.request.contextPath}/userAnswer/findByQuestion/do" method="post">
    题目ID：<input id="qid" name="qid" type="text"><br>
    <input type="submit" value="查询">
</form>
</body>
</html>
