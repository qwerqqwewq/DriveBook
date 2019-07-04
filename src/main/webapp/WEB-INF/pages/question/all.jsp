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
</head>
<body>
<h1>题目列表</h1>

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
