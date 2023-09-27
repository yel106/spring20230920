<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-27
  Time: 오전 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--el에서 attribute에 접근하면 좁은 영역에서부터 찾는다: 그래서 모델과 세션 둘다 어트리뷰트가 attr1인데 모델의 어튜리뷰트가 나옴--%>
<%--page영역 <request(model) 영역 < session영역 < application영역--%>
<h1>\${modelAttr1} : ${{modelAttr1}}</h1>
<h1>\${requestScope.modelAttr1} : ${requestScope.modelAttr1}</h1>
<h1>\${sessionAttr1} : ${{sessionAttr1}}</h1>

<%--모델에 같은 어트리뷰트 없으니까 세션에서 꺼내서 돈까스 출력함--%>
<h1>\${attr1} : ${attr1}</h1>

<h>\${sessionScope.attr1} : ${sessionScope.attr1}</h> <%--세션의 어트리뷰트를 이미 가지고 있음--%>
</body>
</html>
