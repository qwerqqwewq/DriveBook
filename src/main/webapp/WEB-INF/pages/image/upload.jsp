<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>上传图片</title>

    <style>
        .c{
            background-image:url('${pageContext.request.contextPath}/images/bg3.jpg');
            background-size:cover;
        }
        .upload{
            text-align:center;
            margin:250px auto;
            width:400px;
            height:100px;
            font-size:16px
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
    <script src="/js/jquery-2.1.4.min.js"></script>
    <script>
        $(function () {
            $("#uploadBtn").click(function () {
                var urlx = "/image/upload/do";
                var form = $("#uploadForm")[0];
                log(formData);
                //form的enctype没有设定的时候，需要增加此内容
                //formData.append(‘file’, $(‘#file’)[0].files[0]);
                $.ajax({
                    url:urlx,
                    type:'post',
                    data:formData,
                    //datatype:'json',
                    async: false,
                    cache: false,
                    processData: false,
                    contentType: false,
                    success: function (data) {
                        alert("上传成功" + data)
                    },
                    error:function(hxr,data,error) {
                        alert("ajax失败");
                    }

                });


            })
        });
    </script>
</head>
<body class="c">
<div class="upload">
    <form id="uploadForm" enctype="multipart/form-data" method="post" >
        <input type="file" name="uploadFile"> <br>
        <button id="uploadBtn" class="button">上传所选择的图片</button>
    </form>
</div>
</body>
</html>
