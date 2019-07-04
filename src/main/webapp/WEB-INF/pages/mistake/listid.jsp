<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/7/4
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<p>当前${page.pageNum}页，总${page.pages}页，总${page.total}条记录</p>
<c:if test="${page.hasPreviousPage}">
  <a href="findContent?pageNo=${page.pageNum-1}&content=1">上一页</a>
</c:if>
<c:if test="${page.hasNextPage}">
  <a href="findContent?pageNo=${page.pageNum+1}&content=1">下一页</a>
</c:if>
</body>
</html>
