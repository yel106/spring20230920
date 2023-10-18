package com.example.spring20230920;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp12 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp12.class, args);
        Object bean = context.getBean("myClass25");
        Object bean1 = context.getBean("myClass24");
        Object bean2 = context.getBean("myClass23");

        MyClass25 o1 = (MyClass25) bean;

        System.out.println(bean1.hashCode()); // int값 출력
        System.out.println(bean2.hashCode()); // int값 출력 (1)
        System.out.println(o1.getField().hashCode()); //int값 출력 (1). 위랑 같은값 출력되도록

        // getField로 가져오는값이 private MyInterface3 field. 값을 넣으려면
        // 생성자주입 또는 setter로 메소드주입
    }
}



interface MyInterface3 {
    public void method1();
}


@Component
class MyClass23 implements MyInterface3{
    public void method1() {

    }
}


@Component
class MyClass24 implements MyInterface3{
    public void method1() {

    }
}


@Component
//@RequiredArgsConstructor
class MyClass25 {
    private MyInterface3 field;

    //메소드 주입
//    @Autowired
//    public void setField(@Qualifier("myClass23") MyInterface3 field) { //MyClass23이 같도록 해야함
//        this.field = field;
//    }

    // 생성자 주입 방법
    public MyClass25(@Qualifier("myClass23") MyInterface3 field) {
        this.field = field;
    }

    public MyInterface3 getField() {
        return field;
    }
}
