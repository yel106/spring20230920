<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오전 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr>
<h3>${caps.korea} : seoul</h3>
<h3>${caps["korea"]} : seoul</h3>
<%--윗줄 처럼 쓰면 배열 안의 value값을 인식함--%>
<hr>

<%--아래 두줄은 결과가 같음--%>
<h3>${caps[korea]} : ny</h3> <%--korea는 value값이 us임. 그래서 caps의 us는 value값이 ny라고 나오는것 --%>
<%--caps[key값]: value값을 꺼내옴--%>
<h3>${caps["us"]} : ny</h3>

<hr>
<h3>${caps[us]}</h3>
<%--controller9에 us가  아닌 "us" 스트링으로 되어있어서 안뜨는 것--%>

<hr>

<h3>${phones.phone1}</h3>
<h3>${phones.phone2}</h3>
<h3>${caps.korea}</h3>
<h3>${caps.us}</h3>
<h3>${foods["1st"]}</h3>
<h3>${foods["2nd"]}</h3>
</body>
</html>
