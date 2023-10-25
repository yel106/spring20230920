package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao8;
import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto45;
import com.example.spring20230920.service.MyService2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("main39")
public class Controller39 {
    private final MyDao8 dao;

    private final MyService2 service;



    @GetMapping("sub0")
    public void method0() {

    }

    @GetMapping("sub1")
    @ResponseBody //ResponseEntity쓰면 @ResponseBody는 생략해도 됨. 스프링이 데이터타입을 보고 view로 볼건지, 응답본문으로 볼건지 판단함
    public ResponseEntity method1() {
        //ResponseEntity
        // : 응답코드, 응답본문 작성 가능한 객체

        return ResponseEntity.status(400).build(); //F12 네트워크를 보면 상태코드가 200인 것을 볼수 있음. 200이 아니면 다 실패한 것으로 뜸
    }

    @GetMapping("sub2")
    public ResponseEntity method2() {
//        return ResponseEntity.status(200).build();
//        return ResponseEntity.notFound().build(); //404로 쓰고 싶으면 notFound()쓰면됨, 400으로 쓰고 싶으면 badRequest()쓰면됨
//        return ResponseEntity.internalServerError().build(); //500번대 에러
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("sub3")
    public ResponseEntity method3() {
//        return ResponseEntity.notFound().build(); //400번대 에러
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("sub4")
    public ResponseEntity<MyDto45> method4(Integer id) { //ResponseEntity는 generic type이고, type parameter<T>를 가지고 있음. 본문의 타입을 결정함
        MyDto45 data =dao.selectProductById2(id);
//        return ResponseEntity.status(200).body(data); 주석 처리한 건 ResponseEntity.ok(data)와 같은 말
//        return ResponseEntity.ok().body(data);
        if( data ==null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(data);
        }
    }

    @GetMapping("sub5")
    public ResponseEntity method5() {
        if( Math.random() > 0.5) {
            return ResponseEntity.ok().build(); //200번대 응답
        }else  {
            return ResponseEntity.internalServerError().build(); //500번대 응답
        }
    }

    @PostMapping("sub6")
    public ResponseEntity method6(@RequestBody MyDto33Employee dto) {
        //json으로 온걸 자바 객체로 바꿔서 써야함
        if (service.validate(dto)) {
            int rows = service.add(dto);
            if (rows == 1) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }







}
