package com.example.spring20230920;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class MyApp10 {


}

interface MyInterface1 {

}

@Component // 생성자를 통해 인스턴스가 주입됨
class MyClass18 implements MyInterface1 {

}

@Component
class MyClass19 implements MyInterface1 {

}

@Component
// @RequiredArgsConstructor
class MyClass17 {
    private final MyInterface1 field; //값을 주려면 인터페이스를 구현해야함

    public MyClass17(@Qualifier("myClass18")  MyInterface1 field) { //주입 될수 있는 빈이 여러개라면 주입된 빈의 어떤건지 빈의 이름을 Qualifier로 알려줘야함. 구현체 둘 중에 뭔지
        this.field = field;
    }
}