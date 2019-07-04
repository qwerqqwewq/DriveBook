<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/regist/do" method="post">
        用户名：<input id="name" name="name" type="text"><br>
        密码：<input id="pwd" name="pwd" type="password"><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
