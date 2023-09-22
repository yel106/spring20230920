package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("main2")
public class Controller03 {
    //url에 대한 설명
    // https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Web_mechanics/What_is_a_URL



    // /main2/sub1?address=seoul     address(네임)=seoul(value) 를 리퀘스트에 담음. address를 request에 담으면 seoul이 튀어나옴
    @RequestMapping("sub1")
    public void method1(WebRequest request){ //받을 객체를 파라미터로 명시해줌.
        System.out.println("Controller03.method1");

        String address = request.getParameter("address");
        System.out.println("address = " + address);
    }

    // /main2/sub2?name=son&address=london
    @RequestMapping("sub2")
    public void method2(WebRequest request) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }


    // /main2/sub3?name=손흥민
    @RequestMapping("sub3") //controller가 파라미터 받을때 아예 String name으로 받으면 됨 어노테이션ㅇ롬 명시
    public void method3(@RequestParam("name") String name) {
        System.out.println("name = " + name);
    }

     // /main2/sub4?name=김두식&address=서울
    //parameter를 2개 이상 쓰고싶은 경우
    @RequestMapping("sub4")
    public void method4(@RequestParam("name") String name,
                        @RequestParam("address" ) String address) {
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }

    // /main2/sub5?email=abc@gmail.com&gender=남자&number=010-9999
    @RequestMapping("sub5")
    public void method5(@RequestParam("email") String email,  //requestparameter email을 String email에 넣는다는 말
                        @RequestParam("gender") String gender,
                        @RequestParam("number") String number) {  //요청정보가 다 String으로 이루어져있음
        System.out.println("email = " + email);
        System.out.println("gender = " + gender);
        System.out.println("number = " + number);
    }

    //요청정보를  STring말고 다른 타입으로 하고싶다면?
    @RequestMapping("sub6")
    public void method6(@RequestParam("name") String name,
                        @RequestParam("age") String age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        Integer a = Integer.valueOf(age); //age값이 인티저로 변경될거 같아서 인티저로 변경한다면


    }

    //  http://localhost:8080/main2/sub7?name=%EB%82%98&age=40
    @RequestMapping("sub7")
    public void method7(@RequestParam("name")String name,
                        @RequestParam("age") Integer age) { //인티저로 변경해서 사용가능. age가 인티저로 변경될수 있는 값이여야지 사십 이라고 쓰면 안됨
        System.out.println("name = " + name);
        System.out.println("age = " + age);

    }

    // /main2/sub8?address=seoul&married=false&age=66  스트링 boolean int 타입
    @RequestMapping("sub8")
    //@RequestParam 요청할때 parameter를 꼭 써야함. 기본타입 int는 null이 안되는데 참조형은 null값도 받을수 있어서 참조형 Integer로 썼음
    public void method8(@RequestParam("address")String address,
                        @RequestParam("married") Boolean married,
                        @RequestParam("age") Integer age) {
        System.out.println("address = " + address);
        System.out.println("married = " + married);
        System.out.println("age = " + age);

    }

    // /main2/sub9?name=son  //required가 true니까 파라미터 안쓰고 싶다면 required = false써주면 됨
    @RequestMapping("sub9")
    public void method9(@RequestParam(value = "name", required = false) String name) {
        //@RequestParam쓰고 파라미터를 안주면 경고문구가 뜨는데 파라미터 안쓰고 싶다면 required = false써주면 됨
        System.out.println("name = " + name);
    }

    // /main2/sub10?address=seoul&age=30
    // /main2/sub10?address=jeju  age를 넣어도 method10이여야하고, 안넣어도 10이여야함
    // method10 작성
    @RequestMapping("sub10")
    public void method10( @RequestParam("address") String address,
            @RequestParam(value= "age", required = false ) Integer age) { //Integer가 아니라 int로 한다면? null을 안받음
        System.out.println("address = " + address);
        System.out.println("age = " + age);

    }

    // /main2/sub11
    @RequestMapping("sub11")
    public void method11(@RequestParam(value = "age", defaultValue = "0") Integer age) {
        //defaultValue = "0" 이거 쓰면 값을 안줘도 됨
        System.out.println("age = " + age);
    }



}
