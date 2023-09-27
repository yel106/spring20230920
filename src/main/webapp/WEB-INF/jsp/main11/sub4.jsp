<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오후 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty param.age}">
  <c:if test="${param.age >= 20}" var="accept">
    <p>투표 가능합니다.</p>
  </c:if>

  <c:if test="${not accept}">
    <p>투표 불가능합니다.</p>
  </c:if>
</c:if>
<c:if test="${empty param.age}">
  <p>age값을 입력해주세요</p>
</c:if>


</body>
</html>
