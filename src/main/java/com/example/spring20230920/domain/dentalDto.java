package com.example.spring20230920.domain;

import lombok.Data;

import java.util.Date;

@Data
public class dentalDto {
    private Integer chartNumber;
    private String name;
    private String id;
    private String insurance;
    private Date visit;
}
