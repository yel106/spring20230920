<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>form 요소</h1>

  <form action="">
      <input type="text" name="param1"> <%--name attribute를 꼭 명시해야함 이게 쌍으로 쿼리스트링으로 넘어감 --%>
      <br>
      <input type="text" name="param2">
      <br>
      <%--select(option) , textarea--%>
      <button>전송</button>

  </form>

  <hr>

  <form>
      <%--전송버튼 클릭시
      ?name=lee$age=44&address=seoul&email=abc@gmail.com--%>
      <%--url을 표시할떈 %(encoding)이 표시되기도 함--%>
          <input type="text" name="name">
          <br>
          <input type="text" name="age">
          <br>
          <input type="text" name="address">
          <br>
          <input type="text" name="email">
      <button>전송</button>
  </form>

  <h3>action 속성: request 파라미터들을 어디로 보낼 지 결정</h3>
  <p>action 속성이 없거나 빈 문자열일 경우 현재경로</p>

  <form action="https://google.com/search">
      <input type="text" name="q">
      <br>
      <button>전송</button>
  </form>

  <form action="https://search.daum.net/search">
      <input type="text" name="q">
      <button>다음에서 검색</button>
  </form>

  <hr>
<h1>action 속성값: /로 시작하는 경우 (absolute) path가 결정됨</h1> <%--http://localhost:8080/main99/sub2?email=52에서 http://localhost:8080/main99/sub2까지는 결정됨--%>
  <form action="/main99/sub2">
      <input type="text" name="email">
      <button>전송</button>
  </form>
<%--전송버튼 클릭시 request parameter가 /main12/sub2로 전송되도록--%>
  <form action="/main12/sub2">
      <input type="text" name="age">
      <button>전송</button>
  </form>

  <hr>
<h1>action 속성 값: /도 아니고 protocol(scheme)이 아니면 현재페이지의 상대경로</h1>
<h1>path에서 마지막 / 기준</h1>
  <form action="main12/sub2"> <%--// main12앞에 슬래쉬 안쓰면 http://localhost:8080/main12/main12/sub2? 로 나옴--%>
      <input type="text" name="email">
      <button>전송</button>
  </form>

  <form action="sub3">
      <input type="text" name="address">
      <button>전송</button>
  </form>

<%-- .. : 한 경로 위--%>
  <form action="..">
      <input type="text" name="age">
      <button>전송</button>

  </form>
</body>
</html>
