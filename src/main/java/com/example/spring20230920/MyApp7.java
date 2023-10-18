package com.example.spring20230920;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp7 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp7.class, args);
        System.out.println(context.getBean("myClass12"));
        System.out.println(context.getBean("myClass11", MyClass11.class).getDep());

    }
}
@Component
class MyClass12 {

}

@Component
class MyClass11 {
    private MyClass12 dep;

//    public MyClass11() {
//
//    }

//    @Autowired // 여기에 붙이면 생성자 주입이 됨. set메소드에 붙이면 메소드 주입
    // 기본생성자가 없고 사용자정의 생성자만 있다면 @Autowired를 생략해도 됨.
    public MyClass11(MyClass12 dep) {
        this.dep = dep;
    }

    public MyClass12 getDep() { //주입 잘 됐는지 get메소드로 확인해볼 것
        return dep;
    }
}

