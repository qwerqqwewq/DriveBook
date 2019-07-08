<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看所有题目</title>
    <style type="text/css">
        table{
            table-layout: fixed;
            text-align: center;
        }
        td span{
            font-weight:900;
        }
    </style>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(function () {

        });
    </script>
</head>
<body>
<h1>题目列表</h1>
<h2>查询属性</h2>

<form action="/drive/question/all">
    题目类别<br>
    <c:forEach items="${types}" var="type">
        <input name="tid[]" value="${type.id}" type="checkbox">${type.type}   ,
    </c:forEach>
    <br>

    所属科目:<br>
    <input type="radio" value="1" name="subjectId">科目一 ,  <input type="radio" value="4" name="subjectId"> 科目四
    <input type="reset" value="重置">
    <button id="submit">查询</button>

</form>


<h2>题目详情</h2>
<table border="1" width="100%" >
    <th>行号</th>
    <th>所属科目</th>
    <th>所属类型</th>
    <th>内容</th>
    <th>选项</th>
    <th>答案</th>
    <th>答题人数</th>
    <th>正答人数</th>
    <th>题目解析</th>
    <th>操作</th>
    <c:forEach items="${questions}" var="question" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td><span>${question.subject.subject}</span></td>
            <td>
                <c:forEach items="${question.types}" var="type" varStatus="tvs">
                    <span>${type.type}</span><br>
                </c:forEach>
            </td>
            <td>${question.content}</td>
            <td>
                <c:forEach items="${question.optionList}" var="option" varStatus="ovs">
                    <span>${ovs.count}.  </span>${option}<br>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${question.answerList}" var="answer" varStatus="avs">
                    <span>${avs.count}.  </span>${answer}<br>
                </c:forEach>
            </td>
            <td>
                ${question.totalNum}
            </td>
            <td>
                ${question.correctNum}
            </td>
            <td>
                ${question.resolve}
            </td>
            <td><a href="/drive/question/${question.id}">查看</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
