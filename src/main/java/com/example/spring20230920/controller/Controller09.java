package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto7;
import com.example.spring20230920.domain.MyDto8;
import com.example.spring20230920.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

    @RequestMapping("sub3")
    public void method3(Model model) {
        model.addAttribute("names", List.of("예린", "지민", "윤정"));

        model.addAttribute("list1", List.of("강아지","고양이","햄스터"));
        model.addAttribute("mapList1", List.of("1", "2", "3", "4"));
        model.addAttribute("cities", List.of("부산", "서울", "대전", "경주"));
    }

    @RequestMapping("sub4")
    public void method4(Model model) {
        // map( key값, value값)
        var map1 = Map.of("son", 7, "lee", 20, "kim", 90);
        model.addAttribute("myMap", map1);

        var map2 = Map.of("seoul", 1, "busan", 2);
        model.addAttribute("cityMap", map2);

        var map3 = Map.of("red", "빨강", "blue", "파랑", "black", "검정" );
        model.addAttribute("color", map3);

        //띄어쓰기나 '-' 허용이 안됨
        var map4 = Map.of(
                "name", "두식",
                "my name", "봉석",
                "your-name", "희수"
        );
        model.addAttribute("attr3", map4);

    }

    @RequestMapping("sub5")
    public void mehtod5(Model model) {
        var map1 = Map.of("phone1", "iphone", "phone2", "galaxy");
        var map2 = Map.of("korea", "seoul", "us", "ny");
        var map3 = Map.of("1st", "hamburger", "2nd", "pizza");

        model.addAttribute("korea", "us");
        model.addAttribute("phones", map1);
        model.addAttribute("caps", map2);
        model.addAttribute("foods", map3);

    }

    @RequestMapping("sub6")
    public void method6(Model model) {
        model.addAttribute("attr1", new Object());
        model.addAttribute("attr2", new Scanner(System.in)); //넣진 않겠지만 뭐든 넣을수 있다.
        model.addAttribute("attr3", new MyDto7());

    }

    @RequestMapping("sub7")
    public void method8(Model model) {
        MyDto8 o1 = new MyDto8();
        o1.setFood("pizza");
        o1.setComputer("intel");
        o1.setBirthDate("2020-010-01");

        model.addAttribute("person1", o1);

    }

    @RequestMapping("sub8")
    public void method9(Model model) {
        MyDto9 o1 = new MyDto9();
        o1.setId("YL");
        o1.setFirstName("YELIN");
        o1.setLastName("JOO");
        o1.setClassName("Class");
        o1.setPhoneNumber("010");

        model.addAttribute("student", o1);
    }
}


