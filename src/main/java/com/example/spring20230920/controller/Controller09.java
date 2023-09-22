package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main9")
public class Controller09 {
    @RequestMapping("sub1")
    public void mehtod1(Model model) {
        model.addAttribute("attr1", "yel");
        model.addAttribute("attr2", 300);
        model.addAttribute("attr3", true);
        model.addAttribute("attr4", 3.14);

        // 모델 속성이 배열일 경우
        model.addAttribute("attr5", new String[]{"lee", "kim"});

        String[] myArr1 = {"korea", "seoul", "jeju"};
        model.addAttribute("yourArr6", myArr1); //jsp에서 꺼낼 때는 attributeName으로 꺼내야함


    }

    @RequestMapping("sub2")
    public void method1(Model model) {
        String[] Name = {"yelin", "jimin", "jisu"};
        model.addAttribute("myName", Name);

        String[] Email = {"naver.com", "gmail", "hanamil.net"};
        model.addAttribute("yourEmail", Email);

        String[] Address = {"서울특별시", "강원도", "경기도"};
        model.addAttribute("herAddress", Address);

    }
}

