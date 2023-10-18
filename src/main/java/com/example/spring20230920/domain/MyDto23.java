package com.example.spring20230920.domain;

import lombok.Data;

import java.time.LocalDate;
@Data
public class MyDto23 {
    private LocalDate orderDate;
    private String productName;
    private String categoryName;
    private Integer quantity;
    private String price;
}
