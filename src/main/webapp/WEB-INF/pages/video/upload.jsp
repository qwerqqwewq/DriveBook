<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>上传视频</title>

    <script src="/js/jquery-2.1.4.min.js"></script>
    <script>
        $(function () {
            $("#uploadBtn").click(){
                var urlx = "/video/upload/do";
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

            }
        });
    </script>
</head>
<body>
    <form id="uploadForm" enctype="multipart/form-data" method="post" >
        <input type="file" name="uploadFile"> <br>
        <button id="uploadBtn">上传选择文件</button>
    </form>
</body>
</html>
