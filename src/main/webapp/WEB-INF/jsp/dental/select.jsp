<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-11-01
  Time: 오후 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
    <h1>차트 번호로 환자 조회</h1>
    <form action="/dental/select">
        조회할 환자의 차트번호 입력
        <input type="text" name ="chartNumber" placeholder="차트번호 입력"> <button>조회</button>
    </form>
        <p>${list}</p>
</body>
</html>
