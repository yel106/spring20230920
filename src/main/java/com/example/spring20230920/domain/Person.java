package com.example.spring20230920.domain;

public class Person {
    //필드는 상관없음.
    //NAME PROPERTY (GET, SET MEHTOD) =(읽기, 쓰기 가능)
    //age property( 읽기, 쓰기 가능)
    // address property 가 있음 (읽기, 쓰기 가능)


    private String name;
    private  Integer age;
    private  String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
