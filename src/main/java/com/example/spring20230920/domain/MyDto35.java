package com.example.spring20230920.domain;

import lombok.Getter;

public class MyDto35 {
    private String id;

    @Getter
    private String uRL;

    // 프로퍼티명: id
    public String getId() {
        return id;
    }

    //만약 uRL이라고 쓰면?
    //롬복에 의해서는 getURL 이라고 만들어짐.
    // 그리고 URL 처럼 앞에 두글자가 대문자면 property명이 url이 아니라 URL이 됨
    public String getuRL() {
        return uRL;
    }
}
