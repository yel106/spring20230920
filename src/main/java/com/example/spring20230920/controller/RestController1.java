package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao10;
import com.example.spring20230920.domain.MyDto18Employee;
import com.example.spring20230920.domain.MyDto34Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
//@ResponseBody //모든 메소드에 적용됨
@RestController // = @Controller + @ResponseBody
@RequiredArgsConstructor
@RequestMapping("api/main1")
public class RestController1 {

    private final MyDao10 dao;

    // http://localhost:8080/api/main1/sub1로 요청을 하면 return내용이 응답됨
    // 요청한 애한테 return값을 갖다줌
    @GetMapping("sub1")
//    @ResponseBody //이걸 붙여야 리턴값을 view로 인식하지 않음 -> 위에 썼으니까 생략해도 됨
    public String method1() {
        return "customer name!!";
    }

    // http://localhost:8080/api/main1/sub2
    // get요청시
    // 6번 고객의 customerName 응답  (Mapper 해야함. MyDao10으로 만들기 . 서비스없이 다오만 )
    @GetMapping("sub2")
//    @ResponseBody
    public String method2() {
        String customerName = dao.select();
        return customerName;
    };

    @GetMapping("sub3")
//    @ResponseBody
    public MyDto34Customer method3() {
        return dao.getCustomer();
    }


    // /api/main1/sub4?id=33
    @GetMapping("sub4")
//    @ResponseBody
    public ResponseEntity<MyDto34Customer> method4(Integer id) {
        MyDto34Customer customer = dao.getCustomerById(id);
        if( customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
//        return dao.getCustomerById(id);
    }

    //직원번호 선택하면 직원번호 입력되도록
    @GetMapping("sub5")
//    @ResponseBody
    public ResponseEntity<MyDto18Employee> method5(Integer id) {
        MyDto18Employee employee = dao.getEmployeeId(id);
        if( employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("sub6")
//    @ResponseBody
    public List<Integer> method6() {
        return dao.getCustomerIdList();
    }

    @GetMapping("sub7")
//    @ResponseBody
    public List<Integer> method7() {
        return dao.getEmployeeIdList();
    }
}
