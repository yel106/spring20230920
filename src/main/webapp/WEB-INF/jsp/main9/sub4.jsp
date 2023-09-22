<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${myMap}</h3>
<

<hr>
<h3>${phones.phone1}</h3>
<h3>${caps["us"]}</h3>
<h3>${foods["2nd"]}</h3>


<%--key이름을 써주면  value가 나옴--%>

<h3>${attr3.name}</h3>
<h3>${attr3["name"]}</h3>
<%--<h3>${attr3.my name}</h3>     띄어쓰기 하려면 []중괄호 안에 써야함--%>
<h3>${arrt3["my name"]}</h3>
<%--<h3>${arrt3.your-name}</h3>    -연산자 못쓰니까 [] 중괄호 안에 써야함--%>

<h3>${myMap["son"]}</h3>
<h3>${myMap["lee"]}</h3>
<h3>${myMap["kim"]}</h3>
<hr>

<%--두 가지 문법이 있음. 위처럼 []쓰는 경우도 있고, .(온점)찍기--%>
<h3>${myMap.son}</h3>
<h3>${myMap.lee}</h3>
<h3>${myMap.dim}</h3>

<hr>

<h3>${cityMap.seoul}</h3>
<h3>${cityMap.busan}</h3>
<h3>${color.red}</h3>
<h3>${color.blue}</h3>
<h3>${color["black"]}</h3>


</body>
</html>
