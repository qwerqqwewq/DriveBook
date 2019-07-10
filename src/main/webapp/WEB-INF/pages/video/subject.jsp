<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频页面</title>
</head>
<body>
<h1>视频内容</h1>
<c:forEach items="${videos}" var="video" varStatus="vs">
    <iframe src="${video.src}" style="width:98%;height: 450px;"
            frameborder=0
            allowfullscreen="true"
            webkitallowfullscreen="true"
            mozallowfullscreen="true">

    </iframe>
</c:forEach>
</body>
</html>
