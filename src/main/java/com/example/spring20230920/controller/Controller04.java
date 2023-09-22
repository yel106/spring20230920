package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main4")
public class Controller04 {

    // /main4/sub1?name=son
    //Request 파라미터의 이름과  method parameter의 이름이 같으면
    // @RequestParam의 value element 생략가능
    // String name이라는 파라미터명이 대부분 같을것이기 떄문에 @RequestParam("name")에서 name안써도 됨

    @RequestMapping("sub1")
    public void method1(@RequestParam String name ) {
        System.out.println("name = " + name);
    }

    //  /main4/sub2?address=seoul&email=abc@gamil.com&age=44
    @RequestMapping("sub2")
    public void method2(@RequestParam String address,
                        @RequestParam String email,
                        @RequestParam Integer age) {
        System.out.println("address = " + address);
        System.out.println("mail = " + email);
        System.out.println("age = " + age);
    }


    //@RequestParam 어노테이션 생략가능
    // /main4/sub3?name=son&married=true
    @RequestMapping("sub3")
    public void method3(String name, Boolean married) { //생략해서 쓰면 required가 true가 아님. required parameter 디폴트 값이 원래 true
                                    //true면 null값이 들어가지 못함. true가 아니라는게 null값이 들어갈 수 있다는 것. 값을 입력 안하면 null이 나옴
        System.out.println("name = " + name);
        System.out.println("married = " + married);
    }

    // /main4/sub4?check=true&email=abc@naver.com&age=55     //age를 안쓰면 null값이 나옴
    @RequestMapping("sub4")
    public void method4(Boolean check, String email, Integer age) {
        System.out.println("check = " + check);
        System.out.println("email = " + email);
        System.out.println("age = " + age);
    }
}
