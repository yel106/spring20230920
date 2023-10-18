package com.example.spring20230920.domain;


import lombok.Data;

@Data
public class MyDto29 {
    private Integer page;
    private Integer rows;
    private Integer from; //필드랑 프로퍼티랑 같지 않을떄도 있음

    public Integer getFrom() {
        return (page-1)*10;
    }

}
