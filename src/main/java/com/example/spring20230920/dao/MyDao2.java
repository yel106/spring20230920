package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//클래스를 만들고 @Component붙이면 스프링빈이 생성됨. 그걸 mybatis가 대신해줌
@Mapper
public interface MyDao2 {
    //파라미터명을 ${} 명시해주면 마이바티스가 물음표처럼 넣어줌
    @Select(("""
    SELECT LastName FROM employees
    WHERE EmployeeID= #{id}
"""))
    String select(Integer id);
}
