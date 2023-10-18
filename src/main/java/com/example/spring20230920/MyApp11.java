package com.example.spring20230920;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

public class MyApp11 {

}


interface MyInterface2 {
    public void method2();
}


//@Component
class MyClass21 implements MyInterface2 {
    //구현체는 메소드 재정의 해야함. 오버라이딩
    public void method2() {}

}


// 변경해야할때 어노테이션을 MyClass21에서 22로 옮겨주기만 하면 코드를 변경하지 않고 간단하게 바꿀수 있음
// dependency를 자유롭게 교체할 수 있음
@Component
class MyClass22 implements MyInterface2 {
    public void method2() {

    }
}
@Component
@RequiredArgsConstructor
class MyClass20 {
    private final MyInterface2 field;

    public void method2() {
        field.method2(); //다형성 때문에 인스턴스의 메소드가 실행됨
    }
}
