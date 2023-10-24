package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao7;
import com.example.spring20230920.domain.MyDto41;
import com.example.spring20230920.domain.MyDto42;
import com.example.spring20230920.domain.MyDto43;
import com.example.spring20230920.domain.MyDto44;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("main37")
@RequiredArgsConstructor
public class Controller37 {

    private final MyDao7 dao;


    /*
    axios.post("/main37/sub1", '{"name": "jones"}', {
        headers: {
            "content-type" : "application/json"
        }
    })
     // json형식의 데이터. 스트링형식. 뒤에 config는 쓸 필요없음
     문자열이라서 바깥에 ''쓰고, property에는 "" 붙임


      axios.post("/main37/sub1", {name: "jones"})
       위에 쓴 것과 같은 결과. 이 코드는 자바스크립트 객체만 작성
       스프링한테 headers 써서 json이라고 알려줘야함
      */


    /*
    직렬화 serialize
    js object 를 json text로 바꾸는것

    파싱 parse
    json text를 js object로 바꾸는것
     */
    @PostMapping("sub1")
    public void method1(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
    }



    /*
    js object
    axios.post("/main37/sub2", {name: "lee", age: 33, score: 8.9})
     */

    /*
    직렬화 되는 경우 . 제이슨 형식의 스트링 데이터 json text
    '{"name": "lee", "age": 33, "score": 8.9}'

    -> 파싱
    java map에서는
    {name: "lee", age: 33, score: 8.9} 가 됨
     */
    @PostMapping("sub2")
    public void method2(@RequestBody Map<String, Object> map) { //리퀘스트 바디가 파싱해줌
        System.out.println("map = " + map);
    }


    /*
    axios.put("/main37/sub3", {
    city: "seoul",
    name: "son",
    email: "son@naver.com"
    })
     */
    @PutMapping("sub3")
    public void method3(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
    }


    /*
    axios.post("/main37/sub4", {
        city: "paris",
        age:30,
        married: true,
        car: null,
        home: {  //또 다른객체는 javaBean 이나 Map으로 받을수 있음
            address: "seoul",
            price: 1000
        },
        foods: [
            "pizza",
            "burger",
            "부침개"
        ]
    })
     */
    @PostMapping("sub4") //city라는 property를 자바빈에서 찾음.
    public void method4(@RequestBody MyDto42 dto) {
        System.out.println("dto = " + dto);
    }


    //js로 ajax 요청하는 코드 실행
    /*
    axios.post( "/main37/sub5", {
        country: "seoul",
        score: 100.00,
        skills: ["css", "html"],
        phone: "010-8888-7777"
       })
     */
    @PostMapping("sub5")
    public void method5(@RequestBody MyDto43 dto) {
        System.out.println("dto.getCounty() = " + dto.getCountry()); //String
        System.out.println("dto.getScore() = " + dto.getScore()); //Double
        System.out.println("dto.getSkill() = " + dto.getSkills()); //List<String>
        System.out.println("dto.getPhone() = " + dto.getPhone());
         }


    /*
    axios.post("/main37/sub6", {
        name: "son",
        email: ["son@gmail.com", "hm@gmail.com"],
        home: {
            first: "seoul",
            second: "london"
        },
        price: 35.11,
        weight: 77.6,
        married: true
        })
     */
    @PostMapping("sub6")
    public void method6(@RequestBody MyDto44 dto) {
        System.out.println("dto.getName() = " + dto.getName());
        System.out.println("dto.getWeight() = " + dto.getWeight());
        System.out.println("dto.getPrice() = " + dto.getPrice());
        System.out.println("dto.getEmail() = " + dto.getEmail());
        System.out.println("dto.getHome() = " + dto.getHome());
        System.out.println("dto.getMarried() = " + dto.getMarried());
    }



    /*
    axios.put("/main37/sub7", {
          id: 3,
          lastName: "kim",
          firstName: "minjae",
          birthDate: "1999-01-01"
    })
     */
    @PutMapping("sub7")
    public void method7(@RequestBody MyDto41 dto) {
        dao.updateEmployee(dto);
        System.out.println(dto.getId() + "번 직원 수정됨");

    }


}
