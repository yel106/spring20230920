<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-27
  Time: 오전 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--forEach로도 쓰기--%>
<ul>
<c:forEach items="${food}" var="item"> <%--var의 이름과 밑에 있는 이름이 item으로 같아야함 --%> <%--반복. food를 items에 넣은거고, item이 하나씩 꺼내서 출력함--%>
    <li>${item}</li>
</c:forEach>
</ul>

<%--<div>${food}를 선택하셨습니다. </div>--%>
<a href="/main15/sub9">sub9로 가기 </a>
</body>
</html>
