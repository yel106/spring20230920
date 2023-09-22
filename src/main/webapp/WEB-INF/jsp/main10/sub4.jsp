<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오후 2:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>forEach tag</h1>
<p>콘텐츠 반복 출력</p>
<p>주요 attribute: begin, end, var, items, varStatus</p>
<c:forEach begin="0" end="3">
<%--
   begin과 end 포함해서 반복
   end는 begin보다 커야함
   begin은 0보다 크거나 같아야 함. 음수는 쓸수 없음
   --%>
    <li>Lorem ipsum.</li>
</c:forEach>

<hr>
<c:forEach begin="0" end="2" var="num"> <%--var는 begin과 end사이의 값을 담음--%>
    <li>num: ${num}</li>
</c:forEach>

<hr>
<c:forEach begin="0" end="2" var="num">
    <li>car: ${myList[num]}</li><%--따옴표 없이 쓰면 --%>
</c:forEach>

<hr>
<%--반복할 리스트와 item을 쓰면 숫자말고 다른것도 쓸수있음--%>
 <c:forEach items="${myList}" var="item"> <%--배열인 attribute name을 쓰면 전체 길이를 몰라도 반복해서 쓸수 있음--%>
    <li>car: ${item}</li>
</c:forEach>
</body>
</html>
