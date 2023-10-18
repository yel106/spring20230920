package com.example.spring20230920;

import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.ApplicationContext;

public class MyApp5 {
    public static void main(String[] args) {
        // 우리가 직접 제어 (control) 스프링의 도움을 안받고 객체 생성
        MyClass8 obj8 = new MyClass8();
        MyClass7 obj7 = new MyClass7();
        obj7.setField1(obj8);

        obj7.method7(); //method7은 method8만 호출함.
    }
}

class MyClass8 {
    public void method8() {
        System.out.println("MyClass8.method8");
    }
    public void method9() {
        System.out.println("MyClass8.method9");
    }
}

class MyClass7 {
    private MyClass8 field1; // dependency (의존성)

    public MyClass7() {
    }

    public MyClass7(MyClass8 field1) {
        this.field1 = field1;
    }

    public void setField1(MyClass8 field1) {
        this.field1 = field1;
    }

    public void method7() { //객체 fiedl1이 있어야 MyClass8의 메소드를 실행할수 있음. field1에 dependency하는 중
        field1.method8();
    }


}
