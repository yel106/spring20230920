package com.example.spring20230920;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp13 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp13.class, args);

    }
}


@Component //스프링빈을 만듦. 객체
class MyClass26 {


    @PostConstruct //di(의존성 주입)이 완료 후 바로 실행됨
    public void method1() {
        System.out.println("MyClass26.method1");
    }
}
