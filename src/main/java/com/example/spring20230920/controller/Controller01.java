package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller01 {
    @RequestMapping("/") //   '/' :이 경로로 요청이 왔을때 이 메소드가 일하게 하겠다고 하는것. 이렇게 하면스프링이 알아서해줌
    public void method1(){
        System.out.println("Controller01.method1");
    }

    @RequestMapping("/path1") //요청 경로에 따라서 apping하라 ., 어느 메소드가 실행되어야하는지 알려줌
    public void method2() {
        System.out.println("Controller01.method2");
    }
        // /path2로 요청 왔을때 일하는 메소드 작성
    @RequestMapping("/path2")
    public void method3(){
        System.out.println("Controller01.method3");
    }


}
