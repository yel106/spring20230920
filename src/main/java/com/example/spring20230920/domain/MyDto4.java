package com.example.spring20230920.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
@Data  //롬복에 이거쓰면 Getter, Setter, ToString, equals, hashCode 다 포함됨
public class MyDto4 {
    private Boolean signed;
    private String email;
    private String gender;
}
