<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>管理员</title>
    <style>
        .b{background-image:url('${pageContext.request.contextPath}/images/bg.jpg');}
        .login{
            text-align:center;
            margin:250px auto;
            width:400px;
            height:100px;
            font-size:16px
        }
        .button{
            background-color: #e7e7e7;
            border: none;
            color: black;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            margin:10px 5px 15px 20px;
        }
        .input{
            padding: 12px 20px;
            margin: 8px 0;
            border: none;
            border-bottom: 2px solid black;
        }
    </style>


</head>
<body class="b">
<div class="login" >
    <%--<button id="load" onclick="window.location.reload('regist.jsp')">注册</button>--%>
    <form action="${pageContext.request.contextPath}/admin/login/do" method="post"  >
        用户名：<input id="name" name="name" type="text" placeholder="请输入用户名" class="input"><br>
        密码  ：<input id="pwd" name="pwd" type="password" placeholder="请输入密码" class="input"><br>
        <input type="submit" value="登录" class="button">
    </form>
        <a href="${pageContext.request.contextPath}/admin/regist">
            没有管理员账号？点我注册
        </a>

</div>

</html>
</body>
