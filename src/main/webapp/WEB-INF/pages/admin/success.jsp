<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style>
        .c{
            background-image:url('${pageContext.request.contextPath}/images/bg3.jpg');
            background-size:cover;
        }
        .main{
            text-align:center;
            margin:150px auto;
            width:800px;
            height:100px;
            font-size:16px
        }
        .button{
            background-color: azure;
            border: none;
            color: black;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            margin:10px 5px 15px 20px;
        }
        .welcome{
            font-size:30px;
            text-align: left;
            margin:50px auto;
        }
    </style>
</head>
<body   class="c">
<div class="welcome">
    欢迎管理员！
</div>
<div class="main" >
    <a href="${pageContext.request.contextPath}/question/insert">
        <button class="button">上传题目</button>
    </a> <br>
    <a href="${pageContext.request.contextPath}/image/upload">
        <button class="button">上传图片</button>
    </a> <br>
    <a href="${pageContext.request.contextPath}/video/upload">
        <button class="button">上传视频</button>
    </a>

<%--&lt;%&ndash;<a href="${pageContext.request.contextPath}/vedio/upload">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<button>上传视频</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;</a>&ndash;%&gt;--%>

<%--<input type="button" name="uploadVideo" value ="上传视频" onclick="window.location.href='/vedio/upload.jsp'"/>--%>
</div>
</body>
</html>
