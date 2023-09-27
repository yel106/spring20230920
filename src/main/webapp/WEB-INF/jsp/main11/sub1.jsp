<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오전 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>implicit el objects</h1> <%--내가 만들지 않았지만 암묵적으로 있는 객체. 기본적으로 몇개 있음 --%>
<p>${pageScope}</p> <%--jsp가 정의한 객체를 찾음. --%>
<p>${param}</p> <%--param을 자주 씀 --%>
<p>${header}</p>
<hr>

<h1>param el객체 </h1>
<p>request parameter</p>
<%--
예) name=sin&age=33
("name", "son")
("age", "33)
두 entry를 param 맵에 넣어둠
--%>

<%--주소에 query String하면 나옴 --%>
<%-- http://localhost:8080/main11/sub1?name=son&age=44&email=naver.com --%>
<p>\${param.name} : ${param.name}</p>
<p>\${param.age} : ${param.age}</p>
<p>\${param.email} : ${param.email}</p>




</body>
</html>
