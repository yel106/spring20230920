package com.example.spring20230920.dao;

import com.example.spring20230920.domain.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper //마이바티스가 어노테이션 보고 얘로 클래스 만들어서 스프링 빈 만들어야된다는걸 앎
public interface MyDao4 {

    // @Select는 어노테이션 바로 밑에 있는 String select1(int customerId);를 인식함
    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE CustomerID = #{customerId} 
            """)
        /*물음표를 마이바티스에게 어떻게 알릴까? #{}이용 */

    String select1(int customerId);

    /*파라미터가 customerId하나면 이름이 일치하지 않아도 됨.
    2개이상이면 이름을 꼭 맞춰서 써야함 */

    @Select("""
        SELECT ProductName
        FROM products
        WHERE price BETWEEN #{from} AND #{to}
        """)
    List<String> select2(Double from, Double to);
    /*파라미터 fdfdf로 잘못쓰면 찾을수 없다고 뜸
     * 에러메시지 ex) Parameter 'fdfdf' not found. Available parameters are [from, to, param1, param2]
     * */














    @Select("""
            SELECT DISTINCT ProductName
            FROM products p JOIN orderdetails od
            ON p.ProductID = od.ProductID
            JOIN orders o 
            ON o.OrderID = od.OrderID
            WHERE o.OrderDate BETWEEN #{from} AND #{to}
            ORDER BY ProductName
            """)
//    List<String> select3(LocalDate from, LocalDate to);
    List<String> select3(@Param("from") LocalDate from, @Param("to") LocalDate to); //@Param("from)을 안쓰면 오류가 나는 경우도 있음. @Rebuild project해야할수도 있음.


    @Select("""
            SELECT ProductName
            FROM products
            WHERE price BETWEEN #{min} AND #{max}
            """)
    List<String> select4(MyDto25 dto);




    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE Country = #{country1} OR Country = #{country2}
            """)
    List<String> select5(MyDto26 dto);



    @Select("""
        SELECT COUNT(OrderID)
        FROM orders
        WHERE OrderDate BETWEEN #{dto1.from} AND #{dto2.to}  /* 자바빈 하나면 프로퍼티만 쓰면되는데 두개이상이면 자바빈.프로퍼티명 으로 써야함*/
        """)
    Integer select6(MyDto27 dto1, MyDto28 dto2);


















    @Select("""
            SELECT customerName
            FROM customers
            WHERE customerName LIKE #{dto2.keyword}
            LIMIT #{dto1.from}, #{dto1.rows}
            """)
    List<String> select7(MyDto29 dto1, MyDto30 dto2);


    @Insert("""
            INSERT INTO customers (CustomerName, Country)
            VALUES ( #{name}, #{country})
            """)
    int insert1(Mydto31 dto);  // 원래 excuteUpdate를 사용했었는데 마이바티스에서는 어떤걸 리턴해야할까? int.


    @Insert("""
            INSERT INTO employees (LastName, FirstName)
            VALUE (#{lastName}, #{firstName})
            """)
    int insert2(MyDto32 emp);


}
