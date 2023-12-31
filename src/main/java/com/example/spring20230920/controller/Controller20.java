package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto15;
import com.example.spring20230920.domain.MyDto16;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main20")
public class Controller20 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() {

    }


    @GetMapping("sub2")
    public String method2(String id, Model model) throws SQLException {
        // 쿼리 작성 (method6 참고)
        String sql = """
                SELECT CustomerID, CustomerName, Address, Country
                FROM customers
                WHERE CustomerID = ?
                """;

        System.out.println("sql = " + sql);

        // 쿼리 실행
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        List<MyDto15> list = new ArrayList<>();

        try (connection; statement; resultSet) {

            // 실행 결과 처리 (method6 참고, MyDto15 사용)
            while (resultSet.next()) {
                MyDto15 dto = new MyDto15();
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setAddress(resultSet.getString(3));
                dto.setCountry(resultSet.getString(4));

                list.add(dto);
            }
        }
        // 처리한 결과 model에 attribute로 넣고
        model.addAttribute("customerList", list);

        return "/main19/sub6";
    }

    @GetMapping("sub3")
    public void method3(String id) throws SQLException {
        String sql = """
                SELECT customerId, customerName, country
                FROM customers
                WHERE customerId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id);
//        statement.setInt(1, 3);

        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                System.out.println();
                System.out.println("고객 정보");
                System.out.println("id = " + resultSet.getString(1));
                System.out.println("name = " + resultSet.getString(2));
            }
        }
    }

//     /main20/sub4?pid=5
    @GetMapping("sub4")
    public void method4(Integer pid) throws SQLException {
        String sql = """
                SELECT productId, productName
                FROM products
                WHERE productId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pid);

        ResultSet resultSet = statement.executeQuery();


        try( connection; statement; resultSet) {
            while (resultSet.next()) {
                System.out.println();
                System.out.println("상품정보");
                System.out.println("상품 번호= " + resultSet.getInt(1));
                System.out.println("상품명 = " + resultSet.getString(2));
            }
        }
    }

    // /main20/sub5?country=spain
    //콘솔에 spain에 사는 고객이름 출력
    @GetMapping("sub5")
    public void method5(String country) throws SQLException {
        String sql= """
                SELECT CustomerName
                FROM customers
                WHERE country = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, country);
        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet) {
            while (resultSet.next()) {
                System.out.println("고객 성함=" + resultSet.getString(1));
            }
        }
    }

    @GetMapping("sub6")

    // localhost:8080/main20/sub6?c1=italy&c2=sweden
    public void method6(String c1, String c2) throws SQLException {
        String sql = """
                SELECT customerName, country
                FROM customers
                WHERE country = ? OR country = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);


        statement.setString(1, c1);  /* 1번 물음표에 c1이 들어감*/
        statement.setString(2, c2); /* 2번 물음표에 c2이 들어감*/

        ResultSet resultSet = statement.executeQuery();

        try(connection; statement; resultSet) {

            System.out.println();
            System.out.println("고객 목록");
            while (resultSet.next()) {
                String country = resultSet.getString(2);
                // resultSet 커서가 움직이면서 2번째 열에 있는 값을 String country변수가 받음.
                // 컬럼명인 "country" 써도 결과 같게 나옴
                String name = resultSet.getString(1); //컬럼명 "customerName" 써도 됨
                System.out.println(country + ":" + name);
            }
        }
    }

    @GetMapping("sub7")
    public void method7() {

    }

    @GetMapping("sub8")
    public void method8(Double min, Double max) throws SQLException {
    String sql = """
            SELECT ProductName
            FROM products
            WHERE Price <= ? AND Price >= ?
            """;

    Connection connection = dataSource.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql);

    statement.setDouble(1, min);
    statement.setDouble(2, max);
    ResultSet resultSet = statement.executeQuery();

    List<MyDto16> list = new ArrayList<>();
    try ( connection; statement; resultSet) {
        while (resultSet.next()) {
            MyDto16 dto = new MyDto16();
            dto.setId(resultSet.getString(1));
            dto.setName(resultSet.getString(2));
            dto.setUnit(resultSet.getString(3));
            dto.setPrice(resultSet.getInt(4));
        }
    }
}


    // /main20/sub9?country=spain&country=mexico
    @GetMapping("sub9")
    public void method9(@RequestParam("country") List<String> countryList) throws SQLException {
        String questionMarks = "";
        for (int i = 0; i < countryList.size(); i++) {
            questionMarks += "?";

            if( i<countryList.size()-1) {
                questionMarks += ", ";
            }
        }
        // 특정 국가에 속한 고객들 조회
        String sql = """
                SELECT *
                FROM customers
                WHERE country IN("""
                +
                questionMarks
                +
                """
                ) 
                """;
//        System.out.println("sql = " + sql);

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < countryList.size(); i++) {
            statement.setString(i + 1, countryList.get(i));

        }
        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {
            System.out.println("고객 목록");
            while(resultSet.next()) {
                String name= resultSet.getString(2);
                String country = resultSet.getString(7);

                System.out.println(name + ":" + country);
            }
        }
    }

    @GetMapping("sub10")
    public void method10(Model model) throws SQLException {
        // 공급자의 국가 목록 조회
        String sql = """
                SELECT DISTINCT country
                FROM suppliers
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> list = new ArrayList<>();
        try ( connection; statement; resultSet) {
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }

            model.addAttribute("countryList", list);
        }
    }

//    @GetMapping("sub11")
//    //국가로 공급자 조회
//    public void method11(String country, Model model) throws SQLException {
//        String sql= """
//                SELECT SupplierName
//                FROM suppliers
//                WHERE country =?
//                """;
//
//        Connection connection = dataSource.getConnection();
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, country);
//        ResultSet resultSet = statement.executeQuery(); // setString이 resultSet보다 위에 있어야 오류가 안 뜸.
//
//        List<String> list = new ArrayList<>();
//        try( connection; statement; resultSet) {
//            while( resultSet.next()) {
//                list.add(resultSet.getString(1));
//            }
//        }
//        model.addAttribute("countryList", list);
//    }

    @GetMapping("sub11")
    public void method11(@RequestParam("country") List<String> countryList) throws SQLException {
        // /main20/sub11?country=UK&country=USA
        // /main20/sub11?country=UK&country=Japan&country=USA

        String questionMarks = "";

        for (int i = 0; i < countryList.size(); i++) {
            questionMarks += "?";

            if (i < countryList.size() - 1) {
                questionMarks += ", ";          // ?,?,? 이런식으로 가는데 마지막이면 ,이 안붙어야하니까 if문으로 size()-1 조건을 붙임
            }

        }

        String sql = """
                             SELECT *
                             FROM suppliers
                             WHERE country IN (
                             """
                + questionMarks + ")";

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < countryList.size(); i++) {
            statement.setString(i + 1, countryList.get(i));
        }

        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {
            System.out.println("##########공급자 목록#########");
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String country = resultSet.getString(7);

                System.out.println(name + " : " + country);
            }
        }

    }

}
