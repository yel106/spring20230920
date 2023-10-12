<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-10
  Time: 오전 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;

        }

        th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h5>공급자 목록</h5>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <c:forEach items="${supplierList}" var ="supplier">
            <tr>
                <th>${supplier.id}</th>
                <th>${supplier.name}</th>
            </tr>
        </c:forEach>
    </tr>
</table>

<div>
    <c:forEach begin="1" end="${lastPageNumber}" var="pageNumber">
        <a href="/main22/sub2?p=${pageNumber}">${pageNumber}</a>

    </c:forEach>
</div>

</body>
</html>
