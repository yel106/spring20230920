<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-11-01
  Time: 오후 7:34
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
<form action="/dental/delete" method="post">  -<%--이 경로로 가는 메소드를 컨트롤러에 만들어야함 --%>
    <h1>환자 정보 삭제하기</h1>
    <div>
        차트번호 <input type="text" name="chartNumber" placeholder="삭제할 차트번호 입력"> <button>삭제</button>
    </div>

</form>

</body>
</html>
