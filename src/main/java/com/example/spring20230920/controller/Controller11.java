package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main11")
public class Controller11 {
    @RequestMapping("sub1")
    public void method1() {

    }

    @RequestMapping("sub2")
    public void method2() {

    }

    @RequestMapping("sub3")
    public void method3() {

    }
    @RequestMapping({"sub4", "sub5", "sub6"}) /*배열로 받을수 있어서 { } 중괄호 써야함 */
    public void method4() {

    }
    @RequestMapping("sub7")
    public void method5(@RequestParam(value = "show", defaultValue="false") Boolean show,
            Model model){ /*param은 주소의 show를 보고 Boolean에 넣어줌 */
        if(show) {
            List<MyDto9> list = new ArrayList<>();
            list.add(new MyDto9("31", "son", "hm", "football", "010"));
            list.add(new MyDto9("32", "lee", "ki", "paris", "011"));
            list.add(new MyDto9("33", "김", "두식", "서울", "018"));
            list.add(new MyDto9("34", "최", "봉석", "인천", "017"));
            list.add(new MyDto9("35", "이", "지영", "경기", "02"));

            model.addAttribute("moving", list);

        }

    }
}
