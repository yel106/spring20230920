package com.example.spring20230920.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MyDto41 {
    private String lastName;
    private String firstName;
    private LocalDate birthDate; //LocalDate대신 String써도 됨. json에는 날짜 타입 없음
    private Integer id;
}
