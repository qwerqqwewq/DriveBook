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
        .upload{
            text-align:center;
            margin:150px auto;
            width:400px;
            height:100px;
            font-size:16px
        }
        .text{
            border:0;
            border-radius:5px;
            background-color:white;
            width: 355px;
            height: 100px;
            padding: 10px;
            resize: none;
        }
        .input{
            padding: 12px 20px;
            margin: 8px 0;
            border: none;
            border-bottom: 2px solid black;
        }
        .button{
            background-color: #2D64B3;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            margin:10px 5px 15px 20px;
        }
    </style>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(function () {
            <c:if test="${sessionScope.admin==null}">
                <c:redirect url="${pageContext.request.contentType}"></c:redirect>
                alert("管理员尚未登录");
            </c:if>
            $("#uploadBtn").click(function () {
                var urlx = "${pageContext.request.contextPath}/video/upload/do";
                var form = $("#uploadForm")[0];
                var formData = new FormData(form);
                //form的enctype没有设定的时候，需要增加此内容
                formData.append('file', $('#file')[0].files[0]);
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
                        alert(error);
                        alert(data);
                        alert(hxr);
                    }

                });


            })
        });
    </script>
</head>
<body   class="c">
    <div class="upload">
        <form enctype="multipart/form-data" id="uploadForm"  method="post" >
            <input id = "file" type="file" name="uploadFile"> <br>
            <b>视频标题</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="title" class="input"><br>
            <textarea name="intro" class="text" placeholder="此处输入简介"></textarea><br><br>
            <textarea name="context" class="text" placeholder="此处输入正文"></textarea><br><br>
            <b>选择视频所属科目</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <c:forEach items="${subjects}" var="subject">
                <c:if test="${subject.id==2||subject.id==3}">
                    <input type="radio" name="sid" value="${subject.id}">${subject.subject}
                </c:if>
            </c:forEach>
        </form>
        <button id="uploadBtn" class="button">上传所选择的文件</button>
    </div>
</body>
</html>
