package com.example.spring20230920.domain;

import lombok.Data;

@Data
public class MyDto30 {
    private String keyword;


    //롬복은 이걸보고 getKeyword를 안 만듦
    public String getKeyword() {
        if (keyword == null) {
            return "%%";

        }
        return "%" + keyword + "%";
    }
}
