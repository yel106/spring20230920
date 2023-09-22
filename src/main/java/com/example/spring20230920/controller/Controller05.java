package com.example.spring20230920.controller;


import jakarta.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main5")
public class Controller05 {

    // /main5/sub1?name=lee&age=33&address=paris
    @RequestMapping(value = "sub1", params = {"adderess", "age"}) //adderess라는 param이 있을때만 됨
    //, consumes = "application/json"
    public void method1(String name, Integer age, String address) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("address = " + address);
    }

        //required가 false임. 그래서 안써도 메소드가 실행이 되는데 @RequestMapping메소드 중에 request parameter를 true로 만드는 element를 찾기
        //parameter가 있어야만 실행하는 메소드를 찾기.
//    @RequestMapping(value = "sub2", params = {"name", "age", "address"} )
//    public void method2(String name, Integer age, String address) {
//        System.out.println("name = " + name);
//        System.out.println("age = " + age);
//        System.out.println("address = " + address);
//        }


    
        //콘트롤러가 서비스에 넘겨줌
//       service.method(name, age, address);

    // /main5/sub2?name=lee&age=44&address=paris
    @RequestMapping("sub2")
    public void method2(String name, Integer age, String address) {
        Person5 o1 = new Person5();
        o1.setName(name); //String name을 여기서 name이 받음 
        o1.setAge(age);
        o1.setAddress(address);
        System.out.println(o1);
//        service.action(o1);


    }
    
    //생략한것
    // /main5/sub3?name=lee&age=44&address=paris
    @RequestMapping("sub3")
    public void method3(Person5 person5) {
        System.out.println("person5 = " + person5);
    }
    
    
    // /main5/sub4?email=ab@gamil.com&married=true&age=33&info=programmer
    //하나의 객체가 다 받을수 있도록 method4(Student5 s) 작성. 
    //class Student5 작성
    
    @RequestMapping("sub4")
    public void method4(Student5 s) { //클래스 안의 info필드명과 매치되는게 아니라 getInfo메소드명과 매치되는것
        System.out.println("s = " + s);
    }


    
}

class Person5 {
    private String name; //request parameter 와 field의 이름이 같진 않아도 됨. 메소드와 이름이 같아야함
    private Integer age;
    private String address;

    @Override
    public String toString() {
        return "Person5{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class Student5 {
    private String email;
    private Boolean married;
    private Integer age;
    private String info; //리퀘스트 parameter가 info고 information으로 필드명이 바뀌어도 동작됨

    @Override
    public String toString() {
        return "Student5{" +
                "email='" + email + '\'' +
                ", married=" + married +
                ", age=" + age +
                ", info='" + info + '\'' +
                '}';
    }

    public String getEmail() { //request parameter와 set메소드명이 일치해야함. property
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}