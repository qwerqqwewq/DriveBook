<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加用户答案</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/userAnswer/addUserAnswer/do" method="post">
        用户ID：<input id="uid" name="uid" type="text"><br>
        题目ID：<input id="qid" name="qid" type="text"><br>
        答案：<input id="content" name="content" type="text"><br>
        <input type="submit" value="确认">
    </form>
</body>
</html>
