<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-26
  Time: 오전 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>input 요소들</h3>
<form action="/main13/sub2">
<%--div*10>input[name=param$]--%>
<div>
    <input type="text" name="param1">
</div>
<div>
    <input type="password" name="param2">
</div>
<div>
    <input type="date" name="param3">
</div>
<div>
    <input type="button" name="param4" value="어떤 버튼">
</div>
<div>
    <input type="number" name="param5">
</div>
<div>
    <input type="submit" name="param6" value="회원가입">
</div>
<div>
    <input type="radio" name="param7">
</div>
<div>
    <input type="radio" name="param7"> <%--같은 인풋 엘리멘트가 있으면 하나만 선택하게 함 --%>
</div>
<div>
    <input type="checkbox" name="param9">
</div>
<div>
    <input type="checkbox" name="param9">
</div>
<div>
    <input type="hidden" name="param10" value="some value"> <%--히든은 사용자에게 보이진 않지만 전송하고 싶은 경우 --%>
</div>
<button>전송</button>
</form>

<form action="/main13/sub2">
    <div>
        <input type="text" name="param1" value="son">
    </div>
    <div>
        <input type="text" name="param2" placeholder="이름을 입력해주세요."> <%--placeholder: 입력되어야하는 값의 힌트--%>
    </div>
    <div>
        <input type="text" maxlength="5"> <%--글자 길이 제한 : 5글자--%>
    </div>
    <div>
        <input type="text" required>
    </div>

    <div>
        <input type="text" name="param3 "readonly value="son"> <%--읽기만 가능. 값 변경불가--%>
    </div>

    <div>
        <input type="text" name="param4" value="son" disabled> <%-- 전송 버튼 누르면 param3은 넘어가는데 param4는 안넘어감--%>
    </div>

    <div>
        <input type="text" pattern="\d{3}" name="param5"> <%--숫자 3개만 입력가능. 패턴이 다르면 입력할수 없음--%>
    </div>

<%--    div*2>input:c--%>
    <div>
        <input type="checkbox" name="param6" checked id=""> <%--checked: 기본을 체크된 상태로 둘 수 있음--%>
    </div>
    <div>
        <input type="checkbox" name="param6" id="">
    </div>

<%--    div*2>input:r--%>
    <div>
        <input type="radio" name="param7" id="">
    </div>
    <div>
        <input type="radio" name="param7" checked id="">
    </div>
    <div>
        <input type="file" multiple> <%--file선택하는 엘리먼트--%> <%--multiple:파일 하나말고 여러개 선택--%>
    </div>
    <button>전송</button>
</form>

<hr>

<form action="/main13/sub2">
    <label for="input1">  <%--for의 엘리먼트와 input id엘리먼트 이름이 같아야함. 주소에 커서를 두면 같이 이동--%>
        주소
    </label>
    <input id= "input1" type="text">
    <br>

<%--    div>div*3>label[for=check$]>lorem1^input:c#check$--%>
    <div>
        <div>
            <label for="check1">Lorem.</label> <%--라벨의 for와 체크박스의 id 이름을 같게함. 매치해서 잘 쓰임--%>
            <input type="checkbox" name="" id="check1">
        </div>
        <div>
            <label for="check2">Minus.</label>
            <input type="checkbox" name="" id="check2">
        </div>
        <div>
            <label for="check3">Blanditiis!</label>
            <input type="checkbox" name="" id="check3">
        </div>
    </div>

    <input type="submit" value="전송"> <%--button과 하는일은 비슷한데 종료 태그가 없음. input 엘리먼트에도 이미지 넣을 수 있음--%>
    <button>전송</button> <%--종료태그가 있어서 그림을 넣어도 되고, 문자열을 넣어도 됨--%>

</form>
</body>

</html>
