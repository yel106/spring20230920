package com.example.spring20230920.controller;


import com.example.spring20230920.dao.MyDao3;
import com.example.spring20230920.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("main29")
public class Controller29 {

    private final MyDao3 dao3;

    @GetMapping("sub1")
    public void method1() {
        String name = dao3.select1();
        System.out.println("name = " + name);

    }

    @GetMapping("sub2")
    public void method2() {
        Double price = dao3.select2();
        System.out.println("price = " + price);
    }

    @GetMapping("sub3")
    public void method3() {
        //1번 직원의 LastName 조회 후 출력
        String lastName = dao3.select3();
        System.out.println("lastName = " + lastName);

    }

    @GetMapping("sub4")
    public void method4() {
        // 2번 직원의 생일 조회 후 출력
        LocalDate BirthDate = dao3.select4(); //LocalDate, String 둘 다 가능
        System.out.println("BirthDate = " + BirthDate);
    }


    @GetMapping("sub5")
    public void method5() {
        List<String> countrys = dao3.select5();
        countrys.forEach(System.out::println);
    }

    @GetMapping("sub6")
    public void method6() {
        //직원들의 생일 조회
        List<LocalDate> births = dao3.select6();
        births.forEach(System.out::println);
    }

    @GetMapping("sub7")
    public void method7() {
        // 상품의 가격들 조회
        List<Double> priceList = dao3.select7();
        priceList.forEach(System.out::println);
    }

    @GetMapping("sub8")
    public void method() {
        Map<String, Object> row = dao3.select8(); //key, value 쌍으로 잘 들어감
        System.out.println("row = " + row);
    }

    @GetMapping("sub9")
    public void method9() {
        // 1번 상품의 상품명, 가격, 카테고리명
        Map<String, Object> rows = dao3.select9();
//        System.out.println("rows = " + rows);
        rows.entrySet().forEach(System.out::println);
    }

    @GetMapping("sub10")
    public void method10() {
        MyDto19 dto = dao3.select10();
        System.out.println("dto = " + dto);
    }

    @GetMapping("sub11")
    public void method11() {
        MyDto20 dto = dao3.select11();
        System.out.println("dto = " + dto);
    }

    @GetMapping("sub12")
    public void method12() {
        MyDto21 dto1 = dao3.select12();
        System.out.println("dto1 = " + dto1);
        // 2번 고객의 id, name 커스토머 네임, country 조회
        // MyDto21의 property는 id, name, country가 있도록 작성하기
    }

    @GetMapping("sub13")
    public void method13() {
        //여러 열이면 Map이나 자바bean 사용. List는 순서가 있음
        List<Map<String, Object>> rows = dao3.select13();

        // 향상된 for문 이용
        for (Map<String, Object> row : rows) {    //rows를 row로 받음
            System.out.println("row = " + row);
        }
    }

    @GetMapping("sub14")
    public void method14() {
        // 1996년 7월 4일에 주문된 상품명, 상품의 수량, 상품의 가격
        // orders, orderDetails, products 테이블 조회
        List<Map<String, Object>> orders = dao3.select14();

        orders.forEach(System.out::println);
//        for (Map<String, Object> order : orders) {
//            System.out.println("order = " + order);
//        }

    }

    @GetMapping("sub15")
    public void method15() {
        // 1996년 7월 4일에 주문된 상품명, 상품의 수량, 상품의 가격
        // orders, orderDetails, products 테이블 조회
        List<MyDto22> orders = dao3.select15();

        orders.forEach(System.out::println);
    }

    @GetMapping("sub16")
    public void method16() {
        //sub16 요청 시
        // 1번 카테고리 상품들이 주문된 날짜, 상품명, 카테고리명, 수량, 가격 조회되도록
        // 날짜, 상품명 순으로 정렬
        List<MyDto23> orders1 = dao3.select16();
        orders1.forEach(System.out::println);
        System.out.println("orders1.size() = " + orders1.size());
        }

    @GetMapping("sub17")
    public void method17() {
        String s = dao3.select17();
        System.out.println("s = " + s);
    }

    @GetMapping("sub18")
    public void method18() {
        Integer s = dao3.select18();
        System.out.println("s = " + s);
    }

    @GetMapping("sub19")
    public void method19() {
        MyDto24 dto = dao3.select19();
        System.out.println("dto = " + dto);
        //프로퍼티를 Mydto24에서 찾아쓴건데 만약 내가 property를 잘못 썼다면? null로 나옴
        // bean의 property명과 쿼리의 조회된 이름이 같아야함
    }

    @GetMapping("sub20")
    public void method20() {
        MyDto24 dto = dao3.select20();
        System.out.println("dto = " + dto);
    }











}
