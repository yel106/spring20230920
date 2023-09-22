package com.example.spring20230920.domain;

public class Student {
    //email property (읽기, 쓰기), getEmail을 없애면 읽기는 안되고 쓰기만 가능
    //info preperty , info -> information로 바꾸면 information property가 있는것 (읽기, 쓰기)


    private String email;
    private  String info;

//    public String getEmail() {
//        return email;
//    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInformation() {
        return info;
    }

    public void setInformation(String info) {
        this.info = info;
    }
}
