package com.example.spring20230920;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MyApp15 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp15.class, args);
        MyClass29 myClass29 = context.getBean("myClass29", MyClass29.class);
        MyClass28 myClass28 = context.getBean("MyClass28", MyClass28.class);

        System.out.println("myClass29 = " + myClass29);
        System.out.println(myClass28.getField()); //29와 28에서 꺼내온 것은 같은 객체여야함


    }
}



//우리가 만든클래스가 아니라면 Bean만드는 메소드 만들어줘야함
@Configuration
class Configuration2 {
    @Bean
    public MyClass29 myClass29() {
        return new MyClass29();
    }

    @Bean
    public MyClass28 myClass28() {
        MyClass28 myClass28 = new MyClass28();
        //빈의 메소드 활용해야함. myClass29는 새 객체가 아니라 같은 객체임
         myClass28.setField(myClass29()); // 재정의된 싱글톤 패턴을 작성한 결과를 여기에 넣음
        return myClass28;
    }
}



class MyClass29 {

}


class MyClass28 {
    private MyClass29 field; //dependency가 있어서 주입해야함.

    public MyClass29 getField() {
        return field;
    }

    public void setField(MyClass29 field) {
        this.field = field;
    }
}

