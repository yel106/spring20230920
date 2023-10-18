package com.example.spring20230920.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//큰 프젝은 이게 인터페이스지만 우리는 그냥 클래스로 만들것
@Component
@RequiredArgsConstructor //필드의 생성자를 통해 주입
public class MyDao1 {

    private final DataSource dataSource;

//    public MyDao1(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    public String select(int i) throws SQLException {
        //파라미터로 받은 고객 정보를 리턴함
        String sql  = """
                SELECT * FROM customers
                WHERE customerId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try (connection; statement) {
            statement.setInt(1, i);
            ResultSet resultSet = statement.executeQuery();
            if ( resultSet.next())  {
                return resultSet.getString("customerName");
            }
        }
        return null;
    }
}
