<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-24
  Time: 오후 4:11
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
<div>

<button onclick="ajax1()">button1</button>
<script>
    function ajax1() {
        axios.get("/main38/sub1");
    }
</script>
</div>

<div>
    <button onclick="ajax2()">button2</button>
    <script>
        function ajax2() {
            axios.get("/main38/sub2")
                .then(function (response) {
                    console.log("응답 받은 후 해야하는 일");
                    console.log(response.data);  //response에 들어가는게 api에서 Reponse schema에 있음
                    console.log(response.status);
                    console.log(response.statusText);
                    console.log(response.headers);
                    console.log(response.config);
                });
        }
    </script>
</div>

<div>
    <button onclick="ajax3()">button3</button>
    <script>
        function ajax3() {
            axios.get("/main38/sub3")
                .then(function (res) {
                        console.log(res.data);
                        console.log(res.data.age); //age는 data의 property라서 꺼내 쓸 수 있음
                        console.log(res.data.name); //자바스크립트에서는 ; 생략해도 됨
            });
        }
    </script>
</div>

<div>
    <button onclick="ajax4()">button4</button>
    <script>
        function ajax4() {
            // get /main38/sub4
            //응답된 json 데이터를 js object로  파싱해서
            // "seoul", 3000, "son", "1999-03-03"이 출력되도록 하기 . 파싱된 자바스크립트 object를 이용하면 됨
            axios.get("/main38/sub4")
                .then(function (re) {
                        console.log(re.data.city);
                        console.log(re.data.price);
                        console.log(re.data.list[0]);
                        console.log(re.data.birth);
                });
        }
    </script>
</div>

<div>
    <input type="text" id="input1" value="7">
    <button onclick="ajax5()">button5</button>
    <script>
        function ajax5() {
            const pid = document.querySelector("#input1").value;
            axios.get("/main38/sub5?id=" + pid)
                .then(function (response){
                    const product = response.data;
                    console.log(product.ProductId);
                    console.log(product.ProductName);
                    console.log(product.Unit);
                    console.log(product.Price);

                });
        }
    </script>
</div>
</body>
</html>
