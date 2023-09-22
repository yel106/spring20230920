package com.example.spring20230920.controller;


import com.example.spring20230920.domain.MyDto10;
import com.example.spring20230920.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main10")
public class Controller10 {

    @RequestMapping("sub1")
    public void method1(Model model) {
        MyDto9 o1 = new MyDto9();
        MyDto9 o2 = new MyDto9();

        o1.setFirstName("son");
        o2.setFirstName("lee");

        model.addAttribute("students", List.of(o1, o2));

        model.addAttribute("studentList", List.of(o1, o2, o1));

    }

    @RequestMapping("sub2")
    public void method2(Model model) {
        MyDto9 o1 = new MyDto9();
        MyDto9 o2 = new MyDto9();

        o1.setLastName("두식");
        o2.setLastName("봉석");

        model.addAttribute("personMap", Map.of("person1", o1, "person2", o2));

        model.addAttribute("people", Map.of("1st", o1, "2nd", o2));

    }

    @RequestMapping("sub3")
    //모델에 넣어둔 데이터를 꺼내기
    public void method3(Model model) {
        MyDto10 o1= new MyDto10();
        o1.setName("doosik");
        o1.setId(3);
        o1.setFoods(List.of("pizza", "burger", "milk"));
        o1.setCars((List.of("미니쿠퍼", "제네시스", "SM5")));
        model.addAttribute("person1", o1);
    }

    @RequestMapping("sub4")
    public void method4(Model model) {
        model.addAttribute("myList", List.of("tesla", "kia", "benz"));
    }

    @RequestMapping("sub5")
    public void method5(Model model) {
        model.addAttribute("foodList", List.of("떡볶이", "파스타", "피자", "샐러드"));
        model.addAttribute("names", List.of("두식", "봉석", "희수", "미현"));
    }

    @RequestMapping("sub6")
    public void method6(Model model) {
        //9Dto 참고
        List<MyDto9> list = new ArrayList<>();
        list.add(new MyDto9("31", "son", "hm", "football", "010"));
        list.add(new MyDto9("32", "lee", "ki", "paris", "011"));
        list.add(new MyDto9("33", "김", "두식", "서울", "018"));
        list.add(new MyDto9("34", "최", "봉석", "인천", "017"));
        list.add(new MyDto9("35", "이", "지영", "경기", "02"));

        model.addAttribute("moving", list);

    }






}
