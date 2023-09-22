<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach begin="0" end="3" var="i"><%--var의 i와 아래에서 쓴 i가 일치하면 됨--%>
    <p> food: ${foodList[i]}</p> <%--food: 이걸 쓰면 food가 하나씩 받음--%>
</c:forEach>

<c:forEach items="${names}" var="name">
    <p>${name}</p>
</c:forEach>

<hr>

<style>
    .box {
        border: 1px solid black;
        margin: 5px;
        padding: 10px;
        display: flex;
        justify-content: space-between;
    }
    .box> div {
        border: 2px solid orange;
    }
</style>
<%--varStatus: 반복문의 상태 --%>
<c:forEach begin="0" end="3" var="n" varStatus="status"> <%--반복문 몇개 가지고 있는지 명시해줌 --%>
<%--    div.box>div.content1+div.content--%>
    <div class="box">
        <div class="content1">
            n: ${n}
        </div>
        <div class="content2">
            <div>count: ${status.count}</div> <%--status.end나  begin, coutn, last등등 사용가능. count는 이 반복문이 몇번쨰인가--%>
            <div>index: ${status.index}</div>
            <div>current: ${status.current}</div>
            <div>first: ${status.first}</div>
            <div>last: ${status.last}</div>
        </div>

    </div>

</c:forEach>

<hr>
<%--배열 이용해서 확인해보기--%>
<c:forEach items="${names}" var="name" varStatus="status">
    <div class="box">
        <div>name: ${name}</div>
        <div>
            <div>count: ${status.count}</div>
             <div>index: ${status.index}</div>
             <div>current: ${status.current}</div>
             <div>first: ${status.first}</div>
             <div>last: ${status.last}</div>
        </div>
    </div>
</c:forEach>

<hr>

<c:forEach items="${foodList}" var="item" varStatus="status">
        <li>${status.count} : ${item}</li>
</c:forEach>


</body>
</html>
