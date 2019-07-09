<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style>
        .c{
            background-image:url('${pageContext.request.contextPath}/images/bg3.jpg');
            background-repeat: no-repeat;
            height:100%;
            width:100%;
        }
    </style>
</head>
<body   class="c">
操作成功！
<a href="${pageContext.request.contextPath}/question/insert">上传题目</a>
<a href="${pageContext.request.contextPath}/image/upload">上传图片</a>
<a href="${pageContext.request.contextPath}/video/upload">上传视频</a>

<%--&lt;%&ndash;<a href="${pageContext.request.contextPath}/vedio/upload">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<button>上传视频</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;</a>&ndash;%&gt;--%>

<%--<input type="button" name="uploadVideo" value ="上传视频" onclick="window.location.href='/vedio/upload.jsp'"/>--%>

</body>
</html>
