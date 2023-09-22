package com.example.spring20230920.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main1")  //이 메소드의 경로는 /main1/sub1이다.  여기서 슬래쉬도 없애도 됨
public class Controller02 {
    // http://localhost:8080/main1/sub1
    @RequestMapping("/sub1")  ///main1/보통 같은경로는 같은 컨트롤러 안에 둠. 앞에 슬래쉬 없애도 됨
    public void method1(){
        System.out.println("Controller02.method1");
    }

    // /main1/sub2 메소드 작성
    @RequestMapping("/sub2")
    public void method2(){
        System.out.println("Controller02.method2");
    }


    // /main1/sub3 요청에 일하는 method3() 작성
    @RequestMapping("sub3")
    public void mehtod3() {
        System.out.println("Controller02.mehtod3");
    }




}
