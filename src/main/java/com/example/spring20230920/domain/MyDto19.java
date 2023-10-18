package com.example.spring20230920.domain;

import lombok.Data;

@Data
public class MyDto19 {
    private Integer employeeId;
//    private Integer employeeid; //대소문자 구분 안해서 다 소문자로 써도 상관없음.
    private String lastName;
    private String firstName;
//    private String firstNAME; //상관은 없지만 되도록 lowerCamelCase방식으로 쓰기

}
