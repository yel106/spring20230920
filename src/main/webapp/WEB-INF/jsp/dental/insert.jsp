<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-31
  Time: 오후 8:46
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
<form action="/dental/patient" method="post">  -<%--이 경로로 가는 메소드를 컨트롤러에 만들어야함 --%>

    <div>
        차트번호 <input type="text" name="chartNumber">
    </div>
    <div>
        환자성명 <input type="text" name="name">
    </div>
    <div>
        주민등록번호 <input type="text" name="id">
    </div>
    <label for="insu">보험구분: </label>
    <select name="insurance" id="insu"> <%--name이 properties 이름이고, id는 자바스크립트,css쓸때 사용--%>
        보험구분
        <option value="급여">급여</option>
        <option value="비급여">비급여</option>
    </select>

    <div>
        최종내원일 <input type="date" name="visit">
    </div>
    <button>등록</button>
</form>

</body>
</html>
