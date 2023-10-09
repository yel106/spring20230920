package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
@RequestMapping("main21")
public class Controller21 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() throws SQLException {
        String sql = """
                SELECT customerName AS name,   /*대소문자 구별은 버전에 따라 할수도 있고 안 할 수도 있음*/
                       country
                FROM customers
                WHERE CustomerID <= 3
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        try ( connection; statement; resultSet) {
            System.out.println("고객 목록");
            while (resultSet.next()) {
//                String name= resultSet.getString(1);
//                String country = resultSet.getString(2);

                //같은 메소드에 parameter가 다른경우 컬럼명을 써줌. SELECT절에 있는것을 쓰면 됨
                String name= resultSet.getString("name");
                String country = resultSet.getString("country");

                System.out.println(name + ":" + country);

            }
        }
    }

    @GetMapping("sub2")
    public void method2() throws SQLException{
        String sql = """
                SELECT CONCAT(lastName, ', ', firstName) AS fullName,
                        EmployeeID,
                       BirthDate AS birth,
                       Notes AS 'DESC'
                FROM employees
                """;
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        try( connection; statement; resultSet) {
            System.out.println("#직원 목록");
            while(resultSet.next()) {
                String name = resultSet.getString("fullName"); //columnIndex:1로 섞어서 써도 되는데 가능한 일관성있게 쓰는것이 좋음
                String birth = resultSet.getString("birth"); //query가 변경될수 있기때문에 columnLabel을 쓰는게 좋음
                String desc = resultSet.getString("desc");

                System.out.println(name + " : " + birth + " : " + desc);
            }
        }
    }





}
