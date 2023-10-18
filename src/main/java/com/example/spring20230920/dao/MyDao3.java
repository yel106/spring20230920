package com.example.spring20230920.dao;

import com.example.spring20230920.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface MyDao3 {

    // 1행 1열
    @Select("""
            SELECT CustomerName FROM  customers
            WHERE CustomerID =1
            """)
    String select1();  //customerName에 맞춰서 타입 씀


    @Select("""
    SELECT price FROM products
    WHERE ProductID =1
    """)
    Double select2(); //price에맞춰 Duble로 해도 되고, String으로 해도 됨


    //1번 직원LastName
    @Select("""
    SELECT LastName FROM employees
    WHERE EmployeeID = 1
    """)
    String select3();

    //2번 직원 생일
    @Select("""
    SELECT BirthDate FROM employees
    WHERE EmployeeID = 2
    """)
    LocalDate select4();


    // 행 여러개, 열 하나
    @Select("""
    SELECT DISTINCT Country FROM customers
    ORDER BY 1
    """)
    List<String> select5(); //여러행이니까 List로 다음


    @Select("""
    SELECT BirthDate FROM employees
    ORDER BY EmployeeID
    """)
    List<LocalDate> select6();

    @Select("""

    SELECT Price FROM products
    ORDER BY 1
    """)
    List<Double> select7();


    // 하나의 행, 3개의 열
    @Select("""
            SELECT CustomerID, CustomerName, Address
            FROM customers
            WHERE CustomerID =1
    """)
    Map<String, Object> select8(); //여러개의 열이니까 Map으로 받음. String엔 컬럼명이 들어가고, Object엔 Value가 들어감
    // 순서보장 X


    @Select("""
            SELECT p.ProductName 상품, p.Price 가격, c.CategoryName 카테고리이름
            FROM categories c JOIN products p
            ON p.CategoryID = c.CategoryID
            WHERE p.ProductID = 1
            """)
     Map<String, Object> select9();


    @Select("""
            SELECT EmployeeID, LastName, FirstName 
            FROM employees
            WHERE EmployeeID = 1
            """)
            //3개의 열, 하나의 행. Map도 되고, 프로퍼티가 있는 자바빈으로 받아도 됨
    MyDto19 select10(); //프로퍼티가 MyDto19에 있어야함. 프로퍼티 이름은 조회된 employeeID 로 해야함. 프로퍼티 만들때 대소문자는 구분 안함.
    // 도메인 패키지에 MyDto19만듦


    @Select("""
            SELECT ProductName name, price, CategoryName
            FROM products p JOIN categories c ON p.CategoryID = c.CategoryID
            WHERE ProductID = 1
            """)
    MyDto20 select11(); //자바 빈 properties이용.
    // 프로퍼티와 내가 조회한 SELECT문의 컬럼명이 일치하지 않을수도 있음. 그럴땐? SELECT문 뒤에 별칭을 줘서 프로퍼티스 이름과 같게 하면 됨
    // 별칭을 잘 활용하자




    @Select("""
            SELECT CustomerID, CustomerName name, Country
            FROM customers
            WHERE CustomerID = 2;
            """)
    MyDto21 select12();


    @Select("""
    SELECT ProductID id, ProductName name, Price
    FROM products
    WHERE CategoryID = 2
    ORDER BY Price
    
    """)
    List<Map<String, Object>> select13();


    @Select("""
            SELECT p.ProductName, od.Quantity, p.Price
            FROM orders o JOIN orderdetails od
            ON o.OrderID = od.OrderID
            JOIN products p 
            ON p.ProductID = od.ProductID
            WHERE o.OrderDate = '1996-07-04'
    """)
    List<Map<String, Object>> select14();


    @Select("""
            SELECT p.ProductName , od.Quantity, p.Price
            FROM orders o JOIN orderdetails od
            ON o.OrderID = od.OrderID
            JOIN products p 
            ON p.ProductID = od.ProductID
            WHERE o.OrderDate = '1996-07-04'
    """)
    List<MyDto22> select15();

    @Select("""
            SELECT o.OrderDate, p.ProductName, c.CategoryName, od.Quantity, p.Price
            FROM categories c JOIN products p
            ON c.CategoryID = p.CategoryID
            JOIN orderdetails od
            ON od.ProductID = p.ProductID
            JOIN orders o
            ON o.OrderID = od.OrderID
            WHERE p.CategoryID = 1
            ORDER BY o.OrderDate DESC , p.ProductName DESC 
    """)
    List<MyDto23> select16();


    @Select("""
            SELECT CustomerName FROM customers
            WHERE CustomerID = 100 
            """)
    String select17(); //100번째의 조회된 고객이 없다면? null로 나오는데 null인지 아닌지 판단해서 넣기


    @Select("""
            SELECT CustomerID FROM customers
            WHERE CustomerID = 100
            """)
    Integer select18(); //int쓰면 에러메시지: Mapper method 'com.example.spring20230920.dao.MyDao3.select18' attempted to return null from a method with a primitive return type (int).



    @Select("""
            SELECT CustomerID id, CustomerName name, Country 
            FROM customers
            WHERE CustomerID = 1
            """)
    MyDto24 select19();





    @Select("""
            SELECT CustomerID id, CustomerName name, Country 
            FROM customers
            WHERE CustomerID > 1
            """)
    /* where절이 하나의 레코드가 아니라면?
    * 처음 레코드만 들어갈지, 마지막 레코드만 들어갈지? -----> 오류가 남
    * Expected one result (or null) to be returned by selectOne(), but found: 90
    * 하나의 결과만 기대하고 썼는데 90개가 조회된 것. List를 썼어야함. MyDto24에만 담으면 안됨   */


    MyDto24 select20();
    //int말고 Integer참조타입 써야 null을 방지할수 있음




}
