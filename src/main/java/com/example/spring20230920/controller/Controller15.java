package com.example.spring20230920.controller;

import jakarta.servlet.http.HttpServletRequest; //javax가 jakarta로 바뀜
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("main15")
public class Controller15 {

    @GetMapping("sub1")
    public void method1(){
    }

    @GetMapping("sub2")
    public void method2(HttpServletRequest request, HttpSession session) { //HttpSession session : session객체를 서버로부터 받음
        //session에 저장하는 정보는 session attribute
        System.out.println();
        System.out.println("request = " + request.getRemoteHost());
        System.out.println("session = " + session.getId());
        System.out.println();
    }

    @GetMapping("sub3")
    public void method3(
            @RequestParam(value ="name", defaultValue = "") String name, //값이 없으면 저장이 안됨
            HttpSession session,
            HttpServletRequest request) {
        if(!name.isBlank()) {
            session.setAttribute("username", name); //넣을때
        }
        Object username = session.getAttribute("username");//꺼낼떄

        if( username != null) {
            System.out.println();
            System.out.println("request = " + request.getRemoteHost());
            System.out.println("username = " + username);
        }
    }

    @GetMapping("sub4")
    public void method4(){

    }

    @PostMapping ("sub5") //get방식이 아니라 주소창에 바로 /main15/sub5라고 치면 나타나지 않음
    public void method5(String name, HttpSession session) { //sub4에서 주는 name을 String name이 받음. HttpSession session(임시저장소)에 넣음. 같은 브라우저에서 요청하는거면 다른페이지에서도 쓰기 위해 사용
        session.setAttribute("username", name); //jsp에서 어트리뷰트를 꺼내서 씀

    }

    @GetMapping("sub6")
    public void method6() {

    }

    @GetMapping("sub7")
    public void method7() {

    }

    @PostMapping("sub8")
//    public void method8(String foods, HttpSession session) {
    public void method8(@RequestParam("foods") List<String> foods, HttpSession session) {
        session.setAttribute("food", foods); //foods에 object는 다 넣을 수 있음.
    }

    @GetMapping("sub9")
    public void method9() {
        //sub8에서 넣어놓은 session을 꺼내서 sub9.jsp에서 쓰면 됨
    }

    @GetMapping("sub10")
    public void method10(Model model, HttpSession session ) { //모델 세션 둘다 어트리뷰트를 넣을수 있음
        model.addAttribute("modelAttr1", "탕후루");
        session.setAttribute("sessionAttr1", "마라탕");

        model.addAttribute("attr1", "돈까스");
        session.setAttribute("attr1", "커피");
        //jsp에서 돈까스가 나옴. 왜 세션이 아닌 모델에 있는 attr1을 먼저 갖다쓸까? > 좁은 영역인 model을 먼저 갖다쓰기 때문
        // request> comtroller> model> 모델에 있는 어트리뷰트를 뷰가 꺼내 씀. 모델은 하나의 리퀘스트만 사용
        //  여러 request가 같은 세션 사용> controller> session . session은 여러개사용하니까 더 넓은 영역

    }

    @GetMapping("sub11")
    public void method11(Model model, HttpSession session) {
        model.addAttribute("items", List.of("두식", "봉석"));
        session.setAttribute("items", List.of("피자", "햄버거", "돈까스"));
    }








}
