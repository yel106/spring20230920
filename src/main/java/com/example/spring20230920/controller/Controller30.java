package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao4;
import com.example.spring20230920.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.apache.coyote.http11.Constants.a;

@Controller
@RequiredArgsConstructor
@RequestMapping("main30")

public class Controller30 {
    private final MyDao4 dao;

    @GetMapping("sub1")
    public void method1(Integer id) {
        String name= dao.select1(id); //n번 id 고객의 이름을 알수있도록
        System.out.println("name = " + name);

    }


    @GetMapping("sub2")
    public void method2(Double from, Double to) {
        List<String > names = dao.select2(from, to); // 두개의 파라미터 받게 함
        names.forEach(System.out::println);
    }

    // /main30/sub3?from=1996-08-01&to=1996-08-31 이런식으로 요청
   @GetMapping("sub3")
   // from~to 날짜 사이에 주문된 상품명 출력( 정렬해서, 중복없이 조회)
    public void method3(LocalDate from, LocalDate to) {
        List<String> list = dao.select3(from, to);
        list.forEach(System.out::println);
       System.out.println("list.size() = " + list.size());
   }

//    /main30/sub4?min=1.00&max=80.00
   @GetMapping("sub4")
    public void method4(MyDto25 dto) {   //파라미터로 MyDto 쓰면 아래 MyDto25의 객체 생성 안해도 됨
//        MyDto25 dto = new MyDto25();
//        dto.setMin(1.00);
//        dto.setMax(80.00);
       List<String> list = dao.select4(dto);//MyDto25를 만들고 프로퍼티를 꺼내서 쓰는 방법
       System.out.println("list.size() = " + list.size());
   }



   // /main30/sub5?country1=germany&country2=france
   @GetMapping("sub5")
    public void method5(MyDto26 dto) {
        // country1 또는 country2에 사는 고객명 출력
        List<String> list = dao.select5(dto);
       list.forEach(System.out::println);
   }


//     /main30/sub6?from=1996-09-01&to=1996-09-30
   @GetMapping("sub6")
    public void method6(MyDto27 dto1, MyDto28 dto2) {  //파라미터가 두 개 넘어가는 경우
        // 리퀘스트 파람 from에는 dto1이 세팅되고, to에는 dto2가 세팅됨
        Integer num = dao.select6(dto1, dto2);
       System.out.println("num = " + num);
   }


   // /main30/sub7?page=2&rows=10&keyword=a
   @GetMapping("sub7")
    public void method7(MyDto29 dto1, MyDto30 dto2) {
//        dto1.setFrom((dto1.getPage() - 1) * dto1.getRows());
//        dto2.setKeyword("%" + dto2.getKeyword() + "%");

        List<String> names = dao.select7(dto1, dto2);
       System.out.println("dto1.getPage() = " + dto1.getPage());
        names.forEach(System.out::println);
   }

   // /main30/sub8?name=son&country=korea
   @GetMapping("sub8")
    public void method8(Mydto31 dto) {

       int row = dao.insert1(dto);
       System.out.println(row + "행이 입력되었습니다.");
   }

   // /main30/sub9
   @GetMapping("sub9")
    public void method9() {

   }

   @PostMapping("sub10")
    public void method10(MyDto32 emp) {

        int row= dao.insert2(emp);
       System.out.println(row + "행이 입력됨");
   }



}
