<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        .b{background-image:url('${pageContext.request.contextPath}/images/bg.jpg');}
        .regist{
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
<div class="regist">
    <form action="${pageContext.request.contextPath}/admin/regist/do" method="post">
        用户名：<input id="name" name="name" type="text" placeholder="新用户名" class="input"><br>
        密码：<input id="pwd" name="pwd" type="password" placeholder="新密码" class="input"><br>
        <input type="submit" value="注册" class="button">
    </form>
</div>
</body>
</html>
