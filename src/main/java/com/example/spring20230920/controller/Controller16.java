package com.example.spring20230920.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main16")
public class Controller16 {

    @Autowired
    private ServletContext application; //어플리케이션 영역은 ServletContext파일

    @GetMapping("sub1")
    public void method1(Model model, HttpSession session) {
        //application이 제일 넓은 영역임
        model.addAttribute("modelAttr1", "추석");
        session.setAttribute("sessionAttr1", "강강술래");
        application.setAttribute("appAttr1", "보름달");

        //어트리뷰트 이름이 같으면 출력시 다르게 출력해야 나옴
        model.addAttribute("attr1", "송편");
        session.setAttribute("attr1", "윷놀이");
        application.setAttribute("attr1", "토끼");

    }

    @GetMapping("sub2")
    public void method2(HttpSession session) {
        Object count = session.getAttribute("count"); //세션에 접근할떄마다 count를 1 늘려줌
        if ( count ==null) {
            session.setAttribute("count", 0);
        } else {
            Integer countInt = (Integer) count;
            session.setAttribute("count", ++countInt);
        }

        Object appCount = application.getAttribute("count"); //어플리케이션은 값을 올리는거 말고 읽는 용도로만 사용
        if (appCount == null) {
            application.setAttribute("count", 0);
        } else {
            Integer countInt = (Integer) appCount;
            countInt++;
            application.setAttribute("count", countInt);
        }
    }

    @GetMapping("sub3")
    public void method3(Model model, HttpSession session) { //모델은 요청할떄마다 만들어지니까 sub3에서 만들어진 객체랑, sub4에서 만들어진 객체랑 다름
        model.addAttribute("modelAttr1", "보름달");
        session.setAttribute("sessionAttr1", "송편");

        System.out.println("Controller16.method3");
        System.out.println("System.identityHashCode(model) = " + System.identityHashCode(model)); //모델의 해쉬코드는 계속 달라짐
        System.out.println("System.identityHashCode(session) = " + System.identityHashCode(session)); //세션의 해쉬코드는 계속 같음

    }

    @GetMapping("sub4")
    public void method4(Model model, HttpSession session) {
        Object modelAttr1 = model.getAttribute("modelAttr1"); //이전 sub3의 모델에 넣어놨던거라 null이 나옴
        Object sessionAttr1 = session.getAttribute("sessionAttr1");

        System.out.println("modelAttr1 = " + modelAttr1);
        System.out.println("sessionAttr1 = " + sessionAttr1);
        System.out.println("System.identityHashCode(model) = " + System.identityHashCode(model));
        System.out.println("System.identityHashCode(session) = " + System.identityHashCode(session));
    }

    @GetMapping("sub5")
    public String method5() {
        return "/main16/sub5"; //String을 리턴하는건 view name이 됨
    }

    @GetMapping("sub6")
    public String method6() {

        // redirection
        //  다른 곳(location)으로 가!! 라는 응답임(response, 302 ->300번대인데 보통 302번)
        return "redirect:/main16/sub5"; // redirect: 뒤에 경로 써주면 됨
        //302번 요청을 받으면  location을 보고 두번쨰 요청을 함
    }

    @GetMapping("sub7")
    public String method7() {
        return "redirect:http://www.naver.com"; //sub7로 요청을 보냄 location인 네이버로 가라는 말
        //첫번째 요청에 따라 처음에 서버 7로 감. 응답이 302번이고 location이 네이버여서 두번째 요청을 네이버에 함
    }

    @GetMapping("sub8")
    public  String method8(String email) throws UnsupportedEncodingException {
        String processed = email + "precessed";
        String encodeProcessed = URLEncoder.encode(processed, "UTF-8"); //URLEncoder라는 클래스의 encode를 써야함
        // 이메일 형식의 @와 같은 특수문자는  깨지기 떄문에 encoding해야함
        return "redirect:/main16/sub9?p=" + processed; //url에 붙여 쓰는건 encoding해야함. 영문은 엔코딩 안해도 됨

        //보낼떄 session을 사용하거나 queryString을 사용하거나 redirectAttribute를 씀

        //p라는 리퀘스트 파라미터에 query String을 붙임
        // p를 sub9에서 받음
    }

    @GetMapping("sub9")
    public void method9(String p) {
        System.out.println("p = " + p);
    }

    @GetMapping("sub10")
    public String method10(String name, HttpSession session) {
        String processed = name + " 처리 결과";
        session.setAttribute("processedValue", processed);

        return "redirect:/main16/sub11";
    }

    @GetMapping("sub11")
    public void method11(HttpSession session) {     //session은 가능한한 직접적으로 건들지 않는게 좋음.
        Object processedValue = session.getAttribute("processedValue");
        System.out.println("processedValue = " + processedValue);
    }

    @GetMapping("sub12")
    public String method12(String address, RedirectAttributes rttr) {
        String processed = address + "처리결과";

        rttr.addFlashAttribute("processedValue", processed); //processed가 attributeValue자리
        //session을 사용하긴 하는데 세션을 잠깐 반짝 거쳐가는 두번째 요청이 일어난 직후에 세션에서 사라짐.
        return "redirect:/main16/sub13"; //다른곳으로 보냄 . 요청한걸 13에서도 사용하고 싶음. 원래 컨트롤러에서 model을 썼는데
        //리다이렉트에서는 못씀. sub12, 13의 요청이 다르기때문에 model도 서로 다르기 때문. sub13에서 모델을 model.getattribute해도 같은 값이 안나옴
        // HttpSession을 쓰면 12, 13에서 사용하는 세션이 같아서 이용할 수 있음
        //하지만 세션을 사용하는건 그닥 안전하지 않음
        // 안전하게 사용할수 있는게 RedirextAttributes 객체임.
        //addFlashAttribute를 사용한 다음 리다이렉트한 sub13에서 model을 사용해서 꺼내면 안전하게 이용할 수 있음.

    }

    @GetMapping("sub13")
    public void method13(Model model) {
        Object processed = model.getAttribute("processedValue"); //모델에서 꺼낸것. 꺼내면 processed가 나옴
        //스프링이 리다이렉트할때 addFlashAttribute에 있는 것을 Model에 넣어줌
        System.out.println("processed = " + processed);
        //jsp 에서 ${processedValue} 라고 쓰면 값이 나오는데
        //jsp안 쓰고 값을 바로 출력하기 위해서 이렇게 쓴 것.
    }


    //첫 요청을 /main16/sub14로 보냈을때 sub15로 가고
    @GetMapping("sub14")
    public String method14(RedirectAttributes redirect) { //일회성 메세지에 사용. model을 상속받으며, 저장과 운반기능이 있음
        // /main15/sub15 요청할 때
        // foodList라는 attribute를 꺼낼 수 있게 코드작성하기
        //HttpSession쓰고 List.of써도 됨

        redirect.addFlashAttribute("foodList", List.of("김밥", "떡볶이", "피자"));
        //일회성 운반, session에 있던걸 꺼내면서, 모델은 한번쓰면 죽음. session은 리다이렉트까지는 가서 넣어줌.
        return "redirect:/main16/sub15";
    }

    @GetMapping("sub15")
    public void method15(Model model) {
        System.out.println(model.getAttribute("foodList"));
    }

    @GetMapping("sub16")
    public String method16(RedirectAttributes rttr) {
        rttr.addFlashAttribute("flashAttr", "모델에 붙음");
        rttr.addAttribute("attr1", "쿼리스트링에 붙음");
        rttr.addAttribute("address", "서울 신촌");

        return "redirect:/main16/sub17";

    }


    @GetMapping("sub17")
        public void method17() {
        System.out.println("Controller16.method17");
        }

}
