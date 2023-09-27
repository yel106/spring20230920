<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-27
  Time: 오전 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--model과 session둘다 같은 attribute name을 가지고 있어도 출력할 수 있음 --%>
<h1>\${items}: ${items}</h1>
<h1>\${sessionScope.items} :${sessionScope.items}</h1>
</body>
</html>
