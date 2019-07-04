<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>插入试题</title>
    <script src="js/jquery-2.1.4.min.js"></script>
    <script>
        $(function () {
                    $("#btn1").onclick(function(){
                        var tr = "<tr><td></td><td><input name='options' type='text'/></td><td> <input type='checkbox' name='isAnswer' /> </td> </tr>";
                        $("#tab").append(tr);
                    });
                }
        );
    </script>
</head>
<body>
<form id="form" action="${pageContext.request.contextPath}/drive/question/insert/do" method="post">
    标题<input name="title" type="text" /><br>
    科目类别<input type="radio" name="subjectId" value="1">科目一   <input type="radio" name="subjectId" value="4">科目四<br>
    题目内容<input type="text" name="content"><br>
    所属题目类型
    <span>
        <c:forEach items="${types}" var="type">
            <input type="checkbox" name="tid" value="${type.id}">
        </c:forEach>
    </span>

    题目选项
    <table id="tab">
        <thead>序号</thead>
        <thead>选项内容</thead>
        <thead>是否是答案</thead>

    </table>
    <button id="btn1" >添加一行</button>
</form>
</body>
</html>
