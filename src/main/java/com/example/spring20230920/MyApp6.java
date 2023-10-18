package com.example.spring20230920;

import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.ApplicationContext;
        import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp6 {
    public static void main(String[] args) {
        // Inversion Of Control (IOC) . 제어의 역전
        // IOC Container
        org.springframework.context.ApplicationContext context = SpringApplication.run(MyApp6.class, args);

        MyClass9 myClass9 = context.getBean("myClass9", MyClass9.class);
        myClass9.method9();
        System.out.println("myClass9.getField1() = " + myClass9.getField1());

        Object myClass10 = context.getBean("myClass10");
        System.out.println("myClass10 = " + myClass10);
    }
}

@Component // myClass10
class MyClass10 {
    public void method10() {
        System.out.println("MyClass10.method10");
    }
}

@Component // myClass9
class MyClass9 {

    private MyClass10 field1; //필드에 dependency 하고있음 .

    public MyClass9() {
    }

    public MyClass9(MyClass10 field1) {  //여기에 @Autowired 붙이면 생성자 주입으로 됨. set에 붙인것은 메소드 주입
        this.field1 = field1;
    }

    @Autowired // Dependency Injection (DI, 의존성 주입). // 필드값을 setter에 넣어달라고 명시하는 어노테이션, injection
    public void setField1(MyClass10 field1) {
        this.field1 = field1;
    }

    public MyClass10 getField1() {
        return field1; 
    }

    public void method9() {
        field1.method10();
    }
}

