package com.example.spring20230920.controller;


import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RequestMapping("main22")
@Controller
public class Controller22 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(Integer page) throws SQLException {
        String sql = """
                SELECT customerId id,
                       customerName name
                FROM customers
                ORDER BY id
                LIMIT ?, ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

//        statement.setInt(1, 0); // 1페이지
//        statement.setInt(1, 10); // 2페이지
//        statement.setInt(1, 20); // 3페이지
        statement.setInt(1, (page - 1) * 10);
        statement.setInt(2, 10); //LIMIT의 ?(물음표)를 채워줘야함. 2번째부터 10개

        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {
            System.out.println("고객 목록");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");

                System.out.println(id + ":" + name);

            }
        }
    }

    // 페이지당 7개 씩 공급자 목록 조회 (공급자 번호 순)
    // /main22/sub2?p=2
    @GetMapping("sub2")
    public void method2(@RequestParam(value = "p", defaultValue = "1") Integer page,
                        Model model) throws SQLException {
        String sql = """
                SELECT supplierId id,
                       supplierName name
                FROM suppliers
                ORDER BY id
                LIMIT ?, ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, (page - 1) * 7);
        statement.setInt(2, 7);

        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();
        try (connection; statement; resultSet) {
//            System.out.println(page + "페이지 공급자 목록");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                list.add(Map.of("id", id, "name", name));

//                System.out.println(id + " : " + name);
            }
        }

        String sql1 = """
                SELECT COUNT(*)
                FROM suppliers
                """;
        Connection connection1 = dataSource.getConnection();
        Statement statement1 = connection1.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);

        try (connection1; statement1; resultSet1) {
            if (resultSet1.next()) {
                int countAll = resultSet1.getInt(1);
                // 마지막 페이지 번호
                int lastPageNumber = ((countAll - 1) / 7) + 1;

                model.addAttribute("lastPageNumber", lastPageNumber);
            }
        }
            // view jsp가서 써야하니까 모델에 담음
            model.addAttribute("supplierList", list);

    }


    // /main22/sub3?p=2
    // 2페이지 고객목록을 jsp에 테이블 형식 (id, name)출력
    // page 번호로 링크 생성
    // 1페이지에 5개씩
    @GetMapping("sub3")
    public void method3(@RequestParam(value = "p", defaultValue = "1") Integer page,
                        Model model) throws SQLException {
        String sql = """
                SELECT CustomerID id, CustomerName name
                FROM customers
                ORDER BY id
                LIMIT ?, 5
                """;
        String sql1 = """
                SELECT COUNT(*) FROM customers
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (page -1) * 5 );
        ResultSet resultSet = statement.executeQuery();

        Statement statement1 = connection.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);


        //Split into declaration and assignment해서 변수를 또 사용할수 있게 함
                int lastPageNumber = 1;
        try( connection; statement; statement1; resultSet; resultSet1) {
            // sql1에 있는 것이 레코드 하나니까 while문 안쓰고 if문 사용
            if (resultSet1.next()) {
                int countAll = resultSet1.getInt(1);
                // 마지막 페이지 수 = ( (전체 컬럼 수 -1) / n )+ 1
                lastPageNumber = (countAll - 1) / 5 + 1;

                //jsp에서 어트리뷰트 네임인 lastPageNumber을 꺼내서 씀
                model.addAttribute("lastPageNumber", lastPageNumber);


                List<Map<String, Object>> list = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id"); //별칭 id라고 정했음
                    String name = resultSet.getString("name");

                    list.add(Map.of("id", id, "name", name));
                }
                    model.addAttribute("customerList", list);
            }

            model.addAttribute("currentPage", page);

            //왼쪽페이지, 오른쪽 페이지 넘버 계산하기
            int leftPageNumber = (page -1) / 5 *5 + 1;
            int rightPageNumber = leftPageNumber + 4;
            // 이전페이지 넘버는 left페이지 기준으로 계산 됨
            int prevPageNumber = leftPageNumber - 5;
            int nextPageNumber = rightPageNumber + 1;

            // 18페이지가 끝인데 20페이지까지 나오니까
            // right페이지와 마지막 페이지중에 더 작은 수를 사용하겠다는 뜻
            rightPageNumber = Math.min(rightPageNumber, lastPageNumber);

            // view에서 써야하니까 model에 넣어둠
            model.addAttribute("prevPageNumber", prevPageNumber);
            model.addAttribute("nextPageNumber", nextPageNumber);
            model.addAttribute("leftPageNumber", leftPageNumber);
            model.addAttribute("rightPageNumber", rightPageNumber);
        }

    }

}