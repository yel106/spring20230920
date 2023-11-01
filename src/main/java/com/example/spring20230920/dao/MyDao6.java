package com.example.spring20230920.dao;


import com.example.spring20230920.domain.MyDto37;
import com.example.spring20230920.domain.MyDto38;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface MyDao6 {

    @Insert("""

            INSERT INTO customers (CustomerName)
            VALUE (#{name})
            """)

    @Options(useGeneratedKeys = true, keyProperty = "id") // 자동으로 생성되는 마지막 pk 값을 얻을수 있음. MariaDB버전에 따라 이게 안되는 경우도 있음
    int insert1(MyDto37 dto);



    @Insert("""
            INSERT INTO employees (LastName)
            VALUES ( #{lastName})
            """)

    @Options(useGeneratedKeys = true, keyProperty = "id") //키가 들어갈 property명을 쓰면 됨
    int insert2(MyDto38 dto);


    @Insert("""
            INSERT INTO employees (lastName, FirstName)
            VALUES ( #{lastName}, #{firstName})
            """)

    @Options( useGeneratedKeys = true, keyProperty = "id")
    int insert3(MyDto38 dto);


    @Update("""
            UPDATE bank
            SET money = money -1000
            WHERE name = 'son'
            """)
    int update1();

    @Update("""
           UPDATE bank
            SET money = money + 1000
            WHERE name = 'kim'
            """)
    int update2();

    @Select("""
            SELECT *
            FROM bank
            ORDER BY name
            """)
    List<Map<String, Object>> select3();
}
