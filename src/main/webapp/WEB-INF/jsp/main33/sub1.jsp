<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-20
  Time: 오후 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>파일 업로드</h3>

<%--파일전송 form 요소
method="post" enctype="multipart/form-data"를 꼭 써야함
옛날엔 텍스트위주로만 html을 전송했어서 파일 보내려면 설정을 해줘야함--%>
<form action="/main33/sub2" method="post" enctype="multipart/form-data">
    <div>
        name
        <input type="text" name="name">
    </div>
    <div>
        age
        <input type="text" name="age">
    </div>
    <div>
        file
        <input type="file" name="myfile">
    </div>
    <div>
        <input type="submit" value="전송">
    </div>
</form>



</body>
</html>
