<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-04
  Time: 오후 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th style="color: pink">ID</th>
        <th style="color: pink">NAME</th>
        <th style="color: pink">CITY</th>
        <th style="color: pink">COUNTRY</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
    <tr>
        <td>${customer.id}</td>
        <td>${customer.name}</td>
        <td>${customer.city}</td>
        <td>${customer.country}</td>
    </tr>
    </c:forEach>

</table>
</body>
</html>
