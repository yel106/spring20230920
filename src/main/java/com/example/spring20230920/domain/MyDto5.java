package com.example.spring20230920.domain;

import lombok.*;

//@ToString
//@EqualsAndHashCode

@NoArgsConstructor //파라미터 없는 생성자 만들떄 필요
//@RequiredArgsConstructor //필드가 파이널이면 초기화할수있는 기회가 생성자만들때.
@AllArgsConstructor //파이널이든 뭐든  상관없이 파라미터를 만듦

public class MyDto5 {
    private String name; //private final String name;로 하면 생성자에 파라미터 받는게 하나생김
    private Integer age; //이것도 final로 하면 생성자에 파라미터 받는게 2개 생김

}
