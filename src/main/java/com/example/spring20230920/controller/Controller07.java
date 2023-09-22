package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main7")

public class Controller07 {
    // (RequestMapping) Handler Method

    @RequestMapping("sub1")
    public String method1()  { //return value가 스트링인경우 리턴을 view name으로 함
        System.out.println("Controller07.method1");


        return "view1"; //리턴받은 스트링을 뷰의 이름으로 간주
        // 반환값 String으로 하고 jsp 이름으로 리턴함, 이 이름을 가진 view를 찾으려고 함. 폴더명과 확장자명을 붙일수있게 설정해야함
        //main > resources> applicationproperties에서 설정
        // spring.mvc.view.prefix=/WEB_INF/jsp/
        //spring.mvc.view.suffix=.jsp 추가
        //경로를 써줌으로써 return에 view name만 쓰면 경로를 찾아가도록 해줌

    }

    @RequestMapping("sub2")
    public String method2() {
        System.out.println("Controller07.method1");

        return "html2"; //
    }


    // void return 타입: 요청경로가 view name이 됨
    // 요청경로: /main7/sub3
    // view name: /main7/sub3
    // 실제 jsp 경로: /WEB-INF/jsp/main7/sub3.jsp

    @RequestMapping("sub3")
    public void method3() {
        System.out.println("Controller07.method3");
    }

    // /WEB-INF/jsp/main7/html4.jsp
    @RequestMapping("sub4")
    public String method4(){
        return "/main7/html4";
    }
    // /WEB-INF/jsp/main7/sub5.jsp
    @RequestMapping("sub5")
    public void method5() {

    }

}
