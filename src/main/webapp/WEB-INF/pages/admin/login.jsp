<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>管理员</title>
    <style>
        .b{background-image:url('${pageContext.request.contextPath}/images/bg.jpg');}
    </style>


</head>
<body class="b">

<%--<button id="load" onclick="window.location.reload('regist.jsp')">注册</button>--%>
<form action="${pageContext.request.contextPath}/admin/login/do" method="post"  style="text-align:center">
    用户名：<input id="name" name="name" type="text"><br>
    密码  ：<input id="pwd" name="pwd" type="password"><br>
    <input type="submit" value="登录">
</form>
    <a href="${pageContext.request.contextPath}/admin/regist">
        <button>注册</button>
    </a>


</html>
</body>
