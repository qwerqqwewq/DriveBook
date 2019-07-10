<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>上传视频</title>
    <style>
        .c{
            background-image:url('${pageContext.request.contextPath}/images/bg3.jpg');
            background-size:cover;
        }
    </style>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(function () {
            $("#uploadBtn").click(function () {
                var urlx = "/drive/video/upload/do";
                var form = $("#uploadForm")[0];
                var formData = new FormData(form);
                //form的enctype没有设定的时候，需要增加此内容
                //formData.append(‘file’, $(‘#file’)[0].files[0]);
                $.ajax({
                    url:urlx,
                    type:'post',
                    data:formData,
                    datatype:'json',
                    async: false,
                    cache: false,
                    processData: false,
                    contentType: false,
                    success: function (data) {
                        alert(data.msg)
                    },
                    error:function(hxr,data,error) {
                        alert("ajax失败");
                    }

                });


            })
        });
    </script>
</head>
<body   class="c">
    <form id="uploadForm" enctype="multipart/form-data" method="post" >
        <input type="file" name="uploadFile"> <br>
        视频标题<input type="text" name="title">
        <textarea name="intro">此处输入简介</textarea><br>
        <textarea name="context">此处输入正文</textarea><br>
        <c:forEach items="${subjects}" var="subject">
            <input type="radio" name="tid" value="${subject.id}">${subject.subject}，
        </c:forEach>
        <button id="uploadBtn">上传选择文件</button>
    </form>
</body>
</html>
