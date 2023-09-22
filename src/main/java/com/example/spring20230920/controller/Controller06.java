package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto3;
import com.example.spring20230920.domain.MyDto4;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main6")
public class Controller06 {

    // /main6/sub1?name=son&address=paris. setName, setAddress가 만들어져 있기때문에
    //name, address가 obj에 들어감
    @RequestMapping("sub1")
    public void method1(MyDto3 obj) {
        System.out.println("obj = " + obj);
    }


    // /main6/sub2?signed=true&email=ab@gmail.com&gender=male
    @RequestMapping("sub2")
    public void method2(MyDto4 obj) {
        System.out.println("obj = " + obj);
    }

}
