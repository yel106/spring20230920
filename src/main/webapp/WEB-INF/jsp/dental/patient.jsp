<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-31
  Time: 오후 8:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title></title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
    <h1 style="text-align: center">환자 정보 시스템</h1>

    <style>
         table {
             /*border-collapse: collapse;*/
             width: 70%;
             height: 400px;
             margin: auto;
             border: 0px solid black;

         }
         tr, th {
             border: 0px solid black;
             text-align: center;
             display: flex;
             justify-content: space-between;
         }
    </style>


    <form action="/dental/insert" >
    <table>
        <tr>
            <button>등록</button>
            <th>차트번호</th>
            <th>환자성명</th>
            <th>주민등록번호</th>
            <th>보험구분</th>
            <th>최종내원일</th>
        </tr>
    </table>
    </form>


    <form action="/dental/delete">
        <button>삭제</button>
    </form>

    <form action="/dental/update">
        <button>수정</button>
    </form>


    <form action="/dental/select">
        <button>조회</button>
    </form>
</body>
</html>
