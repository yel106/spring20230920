<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-27
  Time: 오전 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${food}" var="item">
    <li>${item}</li>
</c:forEach>
</ul>
<%--<div>${food}를 제공합니다.</div>--%>
<a href="/main15/sub7">첫화면으로 돌아가서 음식 다시 선택하기</a>
</body>
</html>
