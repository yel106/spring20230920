package com.example.spring20230920.domain;

import lombok.Data;

import java.util.List;

@Data
public class MyDto10 {
    private String name;
    private Integer id;
    private List<String> foods; //property가 List
    private List<String> cars;


}
