package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao8;
import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto45;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main38")
@RequiredArgsConstructor
public class Controller38 {

    private final MyDao8 dao;

    @GetMapping("sub0")
    public void method() {

    }

    /*
    axios.get("/main38/sub1")
     */
    @GetMapping("sub1") //이제 이 요청경로를 view로 해석하지 말고, 응답 자체가 본문이 되도록
    @ResponseBody
    public String method1() {

        return "/main38/sub1"; //예전엔 리스폰스 바디가 없으면 view로 해석이 됐는데 리스폰스 바디가 붙으면 리턴 경로 자체가 뷰가 아닌 본문이 되도록 함
        // F12눌러서 응답부분 확인해보면 html이 아니라 요청경로 자체가 들어가있음
    }


    @GetMapping("sub2")
    @ResponseBody
    public String method2() {
        try {
            Thread.sleep((5000)); //쓰레드 해놔서 5초 후에 콘솔에 찍힘
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return "hello world";
    }


    /*
    axios.get("/main38/sub3")
     */
    @GetMapping("sub3")
    @ResponseBody
    public Map<String, Object> method3() {
        // {"name": "son", "age", 30}
        return Map.of("name", "son", "age", 30);

    }

     /*
        axios.get("/main38/sub4")
        * */
    @GetMapping("sub4")
    @ResponseBody
    public Map<String, Object> method4() {

        // {"city": "seoul", "price":3000,
        //      list: ["son", "lee", "kim"], "birth": "1999-03-03"}
        return Map.of("city", "seoul", "price", 3000,
                "list", List.of("son", "lee", "kim"), "birth", "1999-03-03" );
    }


    /*
    axios.get("/main38/sub5?id=8")
     */
    @GetMapping("sub5")
    @ResponseBody
    public Map<String, Object> method5(Integer id) {
        return dao.selectProductById(id);
    }

    /*
    axios.get("/main38/sub6?id=7")
     */
    @GetMapping("sub6")
    @ResponseBody
    public MyDto33Employee method6(Integer id) {
        return dao.selectByEmployeeId(id);
    }

    /*
    axios.get("/main38/sub7?id=33")
    33번 상품의 정보를 json으로 응답
    프로퍼티 id(상품 아이디)
    price(상품 가격)
    category(카테고리명) 조인해야함
    unit(단위)가 json으로 응답될수 있도록 하기
     */
    // 7번째 메소드와 45번쨰 dto, dao.selectByProductId2 만들기
    @GetMapping("sub7")
    @ResponseBody
    public MyDto45 method7(Integer id) {
        return dao.selectProductById2(id);
    }













}
