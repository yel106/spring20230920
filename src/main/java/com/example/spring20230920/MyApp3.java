package com.example.spring20230920;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp3 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp3.class, args);
        MyClass4 bean = context.getBean("mybean4", MyClass4.class);// mybean4에서 객체를 꺼내볼수 있음
        MyClass5 bean1 = context.getBean("myClass5", MyClass5.class);
        System.out.println("bean = " + bean); // 빈이 있다는 것을 확인해볼 수 있음
        System.out.println("bean1 = " + bean1);

        Object bean2 = context.getBean("controller02"); //controller02의 객체가 있는지 확인
        System.out.println("bean2 = " + bean2);

        Object bean3 = context.getBean("myApp3");
        System.out.println("bean3 = " + bean3);


    }


}

@ Component() // spring bean의 이름을 명시하지 않으면 클래스이름 -> (소문자로시작)lowerCamelCase로 바꾼게 곧 빈의 이름이 된다.
class MyClass5 {  //이름 명시하지 않을 경우 빈의 이름은 myClass5이다.

}

@ Component("mybean4") //인스턴스가 스프링에 의해서 객체가 만들어짐. 그게 스프링 빈이다.
class MyClass4 {

}