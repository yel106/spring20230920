<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>jstl if tag</h1>
<c:if test="true">
    <p>출력😋</p>
</c:if>

<c:if test="false">
    <p>출력 안 됨😥</p>
</c:if>

<hr>

<c:if test="${param.name eq 'son'}"> <%--name이 son이면 hello son이 나옴 그리고 띄어쓰기는 최대한 없애는게 좋음--%>
    <p>hello son</p>
</c:if>

<hr>
<h3>var 속성: test의 연산결과 저장</h3>
<c:if test="${param.name eq 'son'}" var="isSon">
    <p>hello son</p>
</c:if>
<c:if test="${isSon}">
    <p>여전히 son</p>
</c:if>

<c:if test="${not isSon}"> <%--저장된 값 isSon의 not이라고 했으니까 else의 효과를 가짐--%>
    <p>son이 아님</p>
</c:if>


</body>
</html>
