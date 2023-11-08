package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto18Employee;
import com.example.spring20230920.domain.MyDto34Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

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
            WHERE CustomerID = #{id}
            """)
    MyDto34Customer getCustomerById(Integer id);

    @Select("""
            SELECT FirstName
            FROM employees
            WHERE EmployeeID =#{id}
            """)
    MyDto18Employee getEmployeeId(Integer id);



    @Select("""
            SELECT customerId
            FROM customers
            ORDER BY CustomerID
            """)
    List<Integer> getCustomerIdList();


    @Select("""
            SELECT EmployeeID
            FROM employees
            ORDER BY EmployeeID
            """)
    List<Integer> getEmployeeIdList();
}

