package com.example.spring20230920.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyDto3 {
     //롬복.. 어노테이션 쓰면 getter직접 만들지 않아도 됨. 왼쪽에 structure 아이콘 누르면 보임

    private String name;

    private String address;

}
