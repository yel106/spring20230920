<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-11
  Time: 오후 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- form: http메소드를 전송 . 원하는 경로로 전송--%>
<form action="/study/sub1" method="post">
<div>
    고객번호로 담당 직원이름 조회하기
<input type="text" name="id" placeholder="고객번호를 입력해주세요" value="">
    <div>
        <button>검색</button>
    </div>
    <div>
        <c:forEach items="${list}" var="list">      <%-- items에 넣을때 --%>
            <h3>${list.lastName} ${list.firstName}</h3>
        </c:forEach>
    </div>

</div>


</form>

</body>
</html>

