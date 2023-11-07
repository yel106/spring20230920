package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto34Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyDao10 {

    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE CustomerID= 6
            """)
    String select();


    @Select("""
            SELECT 
                customerId,
                customerName,
                contactName,
                address,
                city,
                postalCode,
                country
            FROM customers
            WHERE CustomerID =8
            """)
    MyDto34Customer getCustomer();
}
