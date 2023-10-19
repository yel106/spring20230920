<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-19
  Time: 오전 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>고객 조회</h3>
<form action="/main30/sub15">
<input type="text" name="customerId" placeholder="고객번호 입력하세요" >
    <button>조회하기</button>
</form>


<h3>고객 정보 수정</h3>
<form action="/main30/sub16" method="post">

<div>
    <input type="text" name="customerId" value="${customer.customerId}" readonly> <%--name이 프로퍼티명과 같아야함 --%>
</div>
<div>
    <input type="text" name="customerName" value="${customer.customerName}">
</div>
<div>
    <input type="text" name="city" value="=${customer.city}">
</div>
<div>
    <input type="text" name="country" value="${customer.country}">
</div>
<div>
    <button>수정</button>
</div>
</form>

<div>
    <h4>${message}</h4>
</div>
</body>
</html>
