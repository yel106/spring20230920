package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("study")
public class StudyController01 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method2() {

    }
    @PostMapping("sub1")
    public String method1(@RequestParam( value= "id", defaultValue = "1") Integer id,
                        Model model) throws SQLException {
        String sql = """ 
                SELECT FirstName, LastName
                FROM orders o 
                JOIN employees e
                    ON o.EmployeeID = e.EmployeeID
                WHERE o.CustomerID = ? 
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,  id); // "id"라고 쓴 것을 id라고 바꿔야함

        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();
        try(connection; statement; resultSet) {
            while(resultSet.next()) {
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");

                list.add(Map.of("firstName", firstName, "lastName", lastName));
            }
            model.addAttribute("list", list);
        }
            return "/study/sub1";
    }


}
