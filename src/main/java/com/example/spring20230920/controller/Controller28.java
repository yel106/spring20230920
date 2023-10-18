package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main28")
@RequiredArgsConstructor // 생성자 안만들어도 생성자 주입 자동으로 해줌
public class Controller28 {

    private final MyDao2 dao;

    //@RequiredArgsConstructor 썼으니까 생성자 생성할 필요 없음
//    public Controller28(MyDao2 dao) {
//        this.dao = dao;
//    }

    @GetMapping("sub1")
    public void method1(Integer id) throws Exception {
        String name = dao.select(id);
        System.out.println("name = " + name);

    }
}
