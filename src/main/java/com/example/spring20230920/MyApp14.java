package com.example.spring20230920;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp14 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp14.class, args);
        Object bean1 = context.getBean("myBean1");
        System.out.println("bean1 = " + bean1);

        Object bean2 = context.getBean("myBean2");
        System.out.println("bean2 = " + bean2);

        Configuration1 conf = context.getBean("configuration1", Configuration1.class);// 클래스의 이름이 빈의 이름
        MyClass27 obj1 = conf.myBean1();
        MyClass27 obj2 = conf.myBean2();

        System.out.println("obj1 = " + obj1);
        System.out.println("obj2 = " + obj2);
        System.out.println();
        System.out.println(conf.myBean1()); //@Bean붙은 메소드를 실행해서 객체를 여러번 만들어도 항상 같은 객체가 생성됨. 실제 그 인스턴스를 만들고
        //그 클래스를 감싼 하위클래스를 만들어서 bean이 붙은 메소드를 재정의함. conf.myBean1()은 재정의된 메소드라서 계속 같은 객체가 나오도록 보장함.
        // 싱글톤 패턴
        System.out.println(conf.myBean1());
        System.out.println(new MyClass27()); // new로 객체 생성할땐 다른 객체가 생성됨.
        System.out.println(new MyClass27());


        System.out.println("conf = " + conf); //Configuration1$$SpringCGLIB$$0이 Configuration1의 하위타입. 재정의 해서 싱글톤타입으로 객체가 만들어지도록 함
    }

}


//내가 만든 클래스가 아니여서 @Component 붙이지 못할 때?
//spring bean을 만드는 메소드를 가진 클래스를 이용 : Configuration 클래스
// Configuration 클래스(빈): 여기안에도 @component가 속해있음. 그래서 bean으로 만들어짐

@Configuration
class Configuration1 {

    @Bean //빈을 만드는 메소드
    public MyClass27 myBean1() {
        return new MyClass27(); // MyClass27 객체로 만들어서 리턴
    }

    @Bean
    public MyClass27 myBean2() {
        return new MyClass27();
    }
}

// 이 때 이름은 어떻게 결정되는가?
// @Component 라고 붙였을땐 빈의 이름이 클래스 이름을 lowerCamelCase로 바꾼것
// Configuration에서 스프링빈의 이름은메소드의 이름과 같음 = myBean1임
class MyClass27 {

}
