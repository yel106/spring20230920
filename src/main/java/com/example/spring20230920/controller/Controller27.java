package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("main27")
@RequiredArgsConstructor //필드의 생성자가 만들어짐. 그래서 오토와이어드 붙이지 않아도 됨
public class Controller27 {
    private final MyDao1 dao;


    // 컨트롤러가 다오에 일 시키고, 다오가 다시 컨트롤러에게 줌
    @GetMapping("sub1")
    public void method1(Integer id) throws SQLException {
        String select = dao.select(id);

        System.out.println("select = " + select);

    }
}
