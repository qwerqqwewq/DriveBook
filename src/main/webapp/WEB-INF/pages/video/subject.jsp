<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频页面</title>
    <style>
        .c{
            background-image:url('${pageContext.request.contextPath}/images/bg3.jpg');
            background-size:cover;
        }
        .video{
            text-align:center;
            margin:80px auto;
            width:1000px;
            height:1000px;
            font-size:16px
        }
    </style>
</head>
<body class="c">
<div class="video">
    <h1>视频内容</h1>
    <c:forEach items="${videos}" var="video" varStatus="vs">
        <video src="${video.src}" width="100%" height="450px"
               controls="controls"
               preload="auto"
                <%--frameborder=0--%>
                <%--allowfullscreen="true"--%>
                <%--webkitallowfullscreen="true"--%>
                <%--mozallowfullscreen="true"--%>
                >

        </video>
    </c:forEach>
</div>
</body>
</html>
