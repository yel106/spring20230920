<%--
  Created by IntelliJ IDEA.
  User: cool3
  Date: 2023-10-10
  Time: 오전 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
    .active {
      background-color: darkblue;
      color: #eeeeee;
    }
    </style>
</head>
<body>
<h4>고객 목록</h4>
<table>
  <tr>
    <th>ID</th>
    <th>NAME</th>
  </tr>

  <c:forEach items="${customerList}" var="customer">
    <tr>
      <td>${customer.id}</td>
      <td>${customer.name}</td>
    </tr>
  </c:forEach>
</table>
<div>
  <c:if test="${prevPageNumber > 0}">
    <a href="/main22/sub3?p=${prevPageNumber}">이전</a> |
  </c:if>
  <c:forEach begin="${leftPageNumber}" end="${rightPageNumber}" var="pageNumber">
    <a
            <c:if test="${pageNumber == currentPage}">
              class="active"
            </c:if>
            href="/main22/sub3?p=${pageNumber}">${pageNumber}</a>
    |
  </c:forEach>
  <c:if test="${lastPageNumber >= nextPageNumber}">
    <a href="/main22/sub3?p=${nextPageNumber}">다음</a>
  </c:if>
</div>
</body>
</html>
