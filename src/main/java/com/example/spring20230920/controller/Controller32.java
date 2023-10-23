package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao6;
import com.example.spring20230920.domain.MyDto37;
import com.example.spring20230920.domain.MyDto38;
import com.example.spring20230920.service.MyService1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("main32")
public class Controller32 {

    private final MyDao6 dao;
    private final MyService1 component1;

    @GetMapping("sub1")
    public void method1(MyDto37 dto) {
        dao.insert1(dto); //String name보다는 Dto를 이용하는것이 좋음. 자동생성되는 프라이머리 키인 id를 받아야하니까
        System.out.println("dto = " + dto);

    }


    // /main32/sub2?lastName=흥민
    @GetMapping("sub2")
    public void method2(MyDto38 dto) {
        dao.insert2(dto); //직원 테이블에 lastName 입력

        System.out.println("dto = " + dto); //직원의 번호(키)와  lastName 입력
    }


    @GetMapping("sub3")
    public void method3() {


    }

    @PostMapping("sub4")
    public String method4(MyDto38 dto, RedirectAttributes rttr) {
        dao.insert3(dto);

        rttr.addFlashAttribute("message", dto.getId() + "번 직원 등록이 완료되었습니다.");

        return "redirect:/main32/sub3";
    }


    @GetMapping("sub5")
    public void method5() {
        try {
            component1.tx1(); //tx1이 실행되고. 업데이트 실행되고나서 업뎃 실행되면 . 예외 발생해서 롤백 되어 그대로 10000원이 되도록 하는게 의도
        }finally {
        System.out.println("dao.select3() = " + dao.select3());
        }
    }

//    @Transactional      //업무에 동시에 처리되길 원하면 transactional 어노테이션을 붙여야함
//    // 메소드를 안에서 호출했으니 프록시를 거치지 않아서 우리의 의도대로 되지 않음. 콘트롤러나 서비스로 뺴야함
//    public void tx1(){
//        dao.update1();
////        int c = 1/0; //RuntimeException이 생기면 일을 하지 못함.
//
//        dao.update2();
//    }




}
