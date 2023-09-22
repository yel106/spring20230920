package com.example.spring20230920.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main8")
public class Controller08 {

    @RequestMapping("sub1")
    public void method1(Model model) { // 스프링이 메소드 리플렉션해서 모델에 잘 넣어줌
        model.addAttribute("attr1", "주예린"); //모델에 어트리뷰를 추가하기 위한것.
        //모델에 value1을 넣는데, attr1을 이름으로 담아둔것.
        // 꺼낼떄는 jsp 에서 <h1>${attr1}</h1>
        model.addAttribute("attr2", "아이폰"); //모델에 어트리뷰를 추가하기 위한것.

        // forward to  /WEB-INF/jsp/main8/sub1.jsp

    }

    @RequestMapping("sub2")
    public void method(Model model) {

        model.addAttribute("propone", "😉");
        model.addAttribute("propTWO", "😛");

    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        // view name: main8/sub3
        // 실제 jsp경로: /WEB-INF/jasp/main8/sub3.jsp
        model.addAttribute("myName","yelin");
        model.addAttribute("yourAddress","경기도");
        model.addAttribute("herEmail","naver.com");
    }

}
