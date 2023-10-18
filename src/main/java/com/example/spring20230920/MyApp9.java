package com.example.spring20230920;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp9 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp9.class, args);
        MyClass16 myClass16 = context.getBean("myClass16", MyClass16.class);
        MyClass15 myClass15 = context.getBean("myClass15", MyClass15.class);

        System.out.println("myClass16 = " + myClass16);
        System.out.println("myClass15.getField() = " + myClass15.getField());

    }
}

@Component
class MyClass16 {

}

@Component
@RequiredArgsConstructor // final 필드를 아규먼트로 받는 생성자 만들어 주는 lombok annotation
class MyClass15 {
    private final MyClass16 field; // final때문에 생성자 만들어야함 . @RequiredArgsConstructor 붙이면 생성자 따로 안 만들어도 됨
    // 필드에 값을 줘야되는데, 값을 주려면 생성자를 만들어야함
    // 생성자주입은 값을 영원히 변경하지 않을 때 쓰고, set메소드로는 값이 변경될 수 있을때 씀


    public MyClass16 getField() {
        return field;
    }
}
