<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/7/4
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<p>当前${pageInfo.pageNum}页，总${pageInfo.pages}页，总${pageInfo.total}条记录</p>
<c:if test="${pageInfo.hasPreviousPage}">
  <a href="find?pageNo=${pageInfo.pageNum-1}">上一页</a>
</c:if>
<c:if test="${pageInfo.hasNextPage}">
  <a href="find?pageNo=${pageInfo.pageNum+1}">下一页</a>
  </c:if>
</body>
</html>
