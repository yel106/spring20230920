package com.example.spring20230920.dao;

import com.example.spring20230920.domain.dentalDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DentalDao {
    @Insert("""
            INSERT INTO dental.dental(차트번호, 환자성명, 주민등록번호, 보험구분, `최종 내원일`) 
            VALUE (#{chartNumber}, #{name}, #{id}, #{insurance}, #{visit})
            """)
    List<dentalDto> create(dentalDto dto);
}
