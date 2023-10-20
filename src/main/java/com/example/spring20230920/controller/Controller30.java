package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao4;
import com.example.spring20230920.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        String name = dao.select1(id); //n번 id 고객의 이름을 알수있도록
        System.out.println("name = " + name);

    }


    @GetMapping("sub2")
    public void method2(Double from, Double to) {
        List<String> names = dao.select2(from, to); // 두개의 파라미터 받게 함
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

        int row = dao.insert2(emp);
        System.out.println(row + "행이 입력됨");
    }

    // /main30/sub11?id=5
    @GetMapping("sub11")
    public void method11(Integer id) { //파라미터 여기에 써줌
        int rows = dao.delete1(id);
        System.out.println(rows + "개 행이 지워짐");
    }

    // /main30/sub12?pid=3
    //3번 상품이 삭제되는 메소드 완성
    @GetMapping("sub12")
    public void method12(Integer pid) {
        int rows = dao.delete2(pid);
        System.out.println("rows = " + rows + "개 행 지워짐");
    }


    // /mina30/sub13?id=2
    @GetMapping("sub13")
    public void method13(Integer id, Model model) {
        // 직원 조회
        MyDto33Employee employee = dao.select8(id);

        model.addAttribute("employee", employee);

    }
   /*
   public String method13() {
        }

        return "/main30/sub14" 라고 하면 sub14.jsp로 가게 되는데
        지금 public void method13() 으로 되어있고 리턴하는 것이 없음.
        그럴땐 @GetMapping("sub13")에 쓴 sub13.jsp파일을  무조건 보여줌
   */


    @PostMapping("sub14")
    public String method14(MyDto33Employee employee, RedirectAttributes rttr) { //수정한것을 자바빈에서 받음
        // 직원 수정. 수정한것을 자바빈에서 받음
        int rows= dao.update1(employee);

        // 모델에 추가
        if ( rows ==1) {
            rttr.addFlashAttribute("message", "정보가 수정되었습니다.");
        } else {
            rttr.addFlashAttribute("message", "정보 수정에 실패하였습니다.");
        }

        // 쿼리스트링 추가
        rttr.addAttribute("id", employee.getId());

        return "redirect:/main30/sub13";
    }


    // GET /main30/sub15?id=3
    @GetMapping("sub15")
    public void method15(Integer customerId, Model model) {
        MyDto34Customer customer = dao.select15(customerId);
        model.addAttribute("customer", customer);
    }

    // 3번 고객 조회 -> view로 포워딩
    // POST /main30/sub16
    // 고객 정보 수정 -> /main30/sub15?id= 으로 redirect
    @PostMapping("sub16")
    public String method16(MyDto34Customer customer, RedirectAttributes rttr) {
        int update = dao.update2(customer);
        if( update ==1) {
            System.out.println("업데이트 되었습니다.");
        } else {
            System.out.println("실패하였습니다.");
        }
        rttr.addAttribute("CustomerId", customer.getCustomerId());
        return "redirect:/main30/sub15";
    }

}
