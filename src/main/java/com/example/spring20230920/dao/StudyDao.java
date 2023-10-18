package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Select;

public interface StudyDao {
    @Select("""
        SELECT productName FROM products
        WHERE ProductID= ${id} 
"""
    )
    String productName(Integer id);

}
