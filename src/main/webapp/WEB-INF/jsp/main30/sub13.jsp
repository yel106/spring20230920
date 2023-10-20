<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-19
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>직원 조회</h3>
<form action="/main30/sub13"> <%-- form에서 이벤트가 발생해야 액션을 함. 버튼이 submit제출하는 속성이 있음. 버튼이 name=을 url에 제출함 . getMethod를 가지고--%>
    <%-- 버튼을 누르는 순간 내가 쓴 id가 sub13으로 들어감. 13으로 들어오는 것을 받아줄수있는 메소드가 있는지 봐야함 . name과 파라미터명이 같아야함.
     --%>
    <input type="text" name="id" placeholder="직원번호">
    <button>조회</button>
</form>
<hr>


<h3>직원 수정</h3>
<form action="/main30/sub14" method="post"> <%-- 본인----> 서버에 main30/sub14의 내용을 담은 http메서드를 서버에 던지는것 --%>
    <%-- 서버는 응답하는 객체를 우리에게 다시 보내줌 --%>
<%--    div*5>input[name]--%>

    <div>
        <input type="text" name="id"  value="${employee.id}" readonly> <%--id는 변경되면 안 됨--%>
    </div>
    <div>
        <input type="text" name="lastName" value="${employee.lastName}">
    </div>
    <div>
        <input type="text" name="firstName" value="${employee.firstName}">
    </div>
    <div>
        <input type="date" name="birthDate" value="${employee.birthDate}">
    </div>
    <div>
        <input type="text" name="photo" value="${employee.photo}">
    </div>
    <div>
        <textarea name="notes" id="" cols="30" rows="10">${employee.notes}</textarea>
    </div>
    <div>
        <button>수정</button> <%--버튼누르는 순간 submit, 수정된 employee 객체가 담김. 그래서 처리할수 있는 메서드가 컨트롤러30 sub14에 있으면
        메소드는 employee객체를 받아서 update()메소드에 employee를 넣은 후 실행함. 그리고 redirect를 줘서
        그 페이지에 보일 수 있도록 함 --%>
    </div>

    <div>
        <h4>${message}</h4>
    </div>

</form>
</body>
</html>
