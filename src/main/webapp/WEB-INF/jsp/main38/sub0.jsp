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

<div>
    <button onclick="ajax6()">button6</button>
    <script>
        function ajax6() {
            axios.get("/main38/sub2")
                .then(function () {
                    console.log("응답 완료 후 실행");
                })
                .then(function () {
                    console.log("그 다음 실행")
                })
                .then(function () {
                    console.log("또 그 다음 실행")
                });
        }
    </script>
</div>
<div>
    <button onclick="ajax7()">button7</button>
    <script>
        function ajax7() {
            axios.get("/main38/sub2")
                .then(function () {
                    console.log('첫 함수')
                    return "abcd";
                })
                .then(function (param) {
                    console.log('두번째 함수')
                    console.log(param)
                    return 345;
                })
                .then(function (param) {
                    console.log(param)
                })
        }
    </script>
</div>
<div>
    <button onclick="ajax8()">button8</button>
    <script>
        function ajax8() {
            axios.get("/main38/sub2")
                .then(param => {
                    console.log("첫함수일함")
                    return param.data;
                })
                .then(function (param) {
                    console.log("두번째함수 일함")
                    console.log(param)
                })
        }
    </script>
</div>
<div>
    <button onclick="ajax9()">button9</button>
    <script>
        function ajax9() {
            axios.get("/main38/sub2")
                .then(response => response.data)
                .then(data => console.log(data));
        }
    </script>
</div>

<div>
    <button onclick="ajax10()">button10</button>
    <script>
        function ajax10() {
            //arrow function으로 바꾸기
            axios.get("/main38/sub4")
                .then(response => response.data)
                .then(data => console.log(data.list[1]))
        }
    </script>
</div>

<div>
    <button onclick="ajax11()">button11</button>
    <script>
        function ajax11() {
            axios.get("/main38/sub4")
                .then(response => response.data)
                .then(({price, birth, list, city}) => console.log(price)); //3000 data대ㅔ신 구조분해 할당함. 할당할땐 ( ) 를 추가로 써줘야함
        }
    </script>
</div>

<div>
    <button onclick="ajax12()">button12</button>
    <script>
        function ajax12() {
            axios.get("/main38/sub4")
                .then(({data}) => console.log(data.price) );
        }
    </script>
</div>

<div>
    <button onclick="ajax13()">button13</button>
    <script>
        function ajax13() {
            axios.get("/main38/sub4")
                .then(response => response.data)
                .then( ({price, city, country = "korea"}) => {
                    console.log(price); //3000
                    console.log(city); //seoul
                    console.log(country); //korea
                })
        }
    </script>
</div>




<%----------------------------------------------------------------%>
<script>
    // 구조 분해 할당
    // destructuring assignment
    // =은 대입연산자 . 다른곳에 할당하려고 함

    let a= {
        name: "son",
        age: 30
    };

    console.log(a.name);
    console.log(a.age);

    let myName = a.name;
    let myAge = a.age;
    console.log(myName);
    console.log(myAge);

    let {name, age} = a; //destructuring assignment  a가 가지고 있는 프로퍼티를 name, age에 넣음
    console.log(name); //son 출력
    console.log(age); //30 출력

    let b = {
        city: "seoul",
        country : "korea"
    };

    // console.log(b.city);
    // console.log(b.country);
    let {city, country} = b; //구조분해 할당을 해야 city, country라고 쓸 수 있음
    console.log(city);
    console.log(country);

    let c = {
        email: "abc@naver.com",
        price: 300
    };

    // let {email, price} = c; //모든 프로퍼티를 분해할당 하지 않아도 됨.
    let {email} = c; //이렇게 하나만 해도 되고 price는 분해할당 되지 않을수 있음.

    let d = {
        name2: "lee",
        address: "paris",
        age: 77
    };
    let {name2, address} = d; //2개의 프로퍼티 값만 분해할당 가능

    let e = {
        city2: "seoul", //같은 이름의 변수를 두번 선언하지 못해서 2를 붙임
        country2: "korea"
    };
    let {city2, country2, category} = e; //e가 가지고있는 city, country 프로퍼티는 있는데 category는 없기 때문에 undefined로 나옴
    console.log(city2); //seoul
    console.log(country2) //korea
    console.log(category) //undefined

    let f= {
        name3: "kim",
        city3: "busan"
    }
    let {name3, city3= "인천", address3 ="신촌"} = f; //address3 프로퍼티가 없을때 기본값 주고싶으면 = "" 으로 주면됨, city3는 부산이기 때문에 인천이 아니라 부산이 나옴
    console.log(name3)
    console.log(city3)
    console.log(address3)

    let g = [30, 40, 50];
    let [h, i, j] = g;  //h에 30, i에 40, j에 50이 들어감.
    console.log(h);
    console.log(i);
    console.log(j);

    let [k,l] =g; //k에 30, i에 40이 들어감, 50을 안들어가게 할 수동 ㅣㅆ음
    console.log(k);
    console.log(l);

    let [m, ...n] = g; // 나머지 모두다 할당하겠다는게 ...n
    console.log(m); //30
    console.log(n); //40, 50이 들어가있음

    let [...o] = g;
    console.log(o); //g라는 배열을 그대로 다 받겠다고 하면 [30, 40, 50]이 다 들어감
</script>
<%------------------------------------------------------------------------------------%>





</body>
</html>
