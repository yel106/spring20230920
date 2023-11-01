package com.example.spring20230920.dao;

import com.example.spring20230920.domain.dentalDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface DentalDao {
    @Insert("""
            INSERT INTO dental.dental(차트번호, 환자성명, 주민등록번호, 보험구분, `최종 내원일`) 
            VALUE (#{chartNumber}, #{name}, #{id}, #{insurance}, #{visit})
            """)
    int insert(dentalDto dto);


    @Delete("""
            DELETE FROM dental.dental
            WHERE 차트번호 = #{chartNumber}
            """)
    int deleteBychartNumber(@Param("chartNumber") int chartNumber);


    @Update("""
            UPDATE dental.dental
            SET 차트번호= #{chartNumber},
                환자성명= #{name}, 
                주민등록번호= #{id},
                보험구분= #{insurance},
                `최종 내원일`= #{visit}
            """)

    int update(dentalDto dto);



    @Select("""
            SELECT *
            FROM dental.dental
            WHERE 차트번호= #{chartNumber}
            """)
    List<Map<String, Objects>> selectBychartNumber(dentalDto dto);
}
