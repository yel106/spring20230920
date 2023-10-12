package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto18Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main25")
public class Controller25 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(@RequestParam(value= "id", required = false) Integer customerId) throws SQLException {

        if( customerId ==null) {
            System.out.println("삭제할 id를 넣어주세요");
            return;
        }

        String sql= """
                DELETE FROM customers
                WHERE customerId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try( connection; statement) {
            statement.setInt(1,  customerId); // 1번 아이디 삭제
            int rows = statement.executeUpdate(); //insert, delete, update 하는 경우 excuteUpdate메소드 사용

            if (rows == 1) {
                System.out.println(rows + "개 레코드가 잘 지워짐");

            } else {
                System.out.println("지워지지 않음");
            }
        }
    }



    @GetMapping("sub2")
    public void method3() {

    }

    @PostMapping("sub2")
    public void method2(@RequestParam(value = "pid", required = false) Integer number) throws SQLException {
        if( number == null) {
            System.out.println("삭제할 ID 입력하기 ");
        }

        String sql = """
                DELETE FROM products
                WHERE productID = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, number);
        int count = statement.executeUpdate();
        if(count==1) {
            System.out.println("잘 지워짐");
        } else {
            System.out.println("안 지워짐");
        }





    }

    @GetMapping("sub4")
    public void method4() throws SQLException {
        String sql = """
                UPDATE shippers
                SET
                    shipperName = ?,
                    phone = ?
                WHERE
                    shipperID = ?    
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setString(1, "이강인");
            statement.setString(2, "01077778888");
            statement.setInt(3, 1);

            int rows = statement.executeUpdate();
            if (rows == 1) {
                System.out.println("잘 변경됨");
            } else {
                System.out.println("뭔가 잘못 됨");
            }

        }
    }

    @GetMapping("sub5") //조회 후 수정 할수 있도록 함
    public void method5(@RequestParam("id") Integer shipperId, Model model) throws SQLException {
        String sql = """
                SELECT * FROM shippers
                WHERE shipperId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setInt(1, shipperId);

            ResultSet resultSet = statement.executeQuery();

            try (resultSet) {
                if (resultSet.next()) {
                    model.addAttribute("shipper", Map.of("shipperId", resultSet.getInt("shipperId"),
                            "shipperName", resultSet.getString("shipperName"),
                            "phone", resultSet.getString("phone")));
                }

            }

        }

    }


    @PostMapping("sub5")
    public String method6(
            @RequestParam("id") Integer shipperId,
            @RequestParam("name") String shipperName,
            @RequestParam("phone") String phone,
            RedirectAttributes rttr
    ) throws SQLException {
        String sql = """
                UPDATE shippers
                SET shipperName = ?,
                    phone = ?
                WHERE
                    shipperId = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try (connection; statement) {
            statement.setString(1, shipperName);
            statement.setString(2, phone);
            statement.setInt(3, shipperId);

            int rows = statement.executeUpdate();

            if (rows == 1) {
                System.out.println("잘 변경됨");
            } else {
                System.out.println("문제 생김");
            }

        }

        rttr.addAttribute("id", shipperId);
        return "redirect:/main25/sub5";
    }

    @GetMapping("sub7")
    public void method7(@RequestParam(value = "id", required = false) Integer employeeId, Model model) throws SQLException {
        if (employeeId == null) {
            return;
        }
        String sql = """
                SELECT * FROM employees
                WHERE employeeId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setInt(1, employeeId);

            ResultSet resultSet = statement.executeQuery();

            try (resultSet) {
                if (resultSet.next()) {
                    String lastName = resultSet.getString("lastName");
                    String firstName = resultSet.getString("firstName");
                    LocalDate birthDate = resultSet.getTimestamp("birthDate").toLocalDateTime().toLocalDate();
                    String photo = resultSet.getString("photo");
                    String notes = resultSet.getString("notes");

                    model.addAttribute("employee", Map.of("lastName", lastName,
                            "firstName", firstName,
                            "birthDate", birthDate,
                            "photo", photo,
                            "notes", notes,
                            "employeeId", employeeId));

                }
            }
        }

    }

    @PostMapping("sub7")
    public String method8(@RequestParam("id") Integer employeeId,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("firstName") String firstName,
                        @RequestParam("birthDate") LocalDate birthDate,
                        @RequestParam("photo") String photo,
                        @RequestParam("notes") String notes,
                        RedirectAttributes rttr,
                        Model model
                        ) throws SQLException {
        String sql = """
                UPDATE employees
                SET LastName = ?,
                    firstName = ?,
                    birthDate= ?,
                    photo = ?,
                    notes = ?
                WHERE employeeId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try( connection; statement) {
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setDate(3, Date.valueOf(birthDate));
            statement.setString(4, photo);
            statement.setString(5, notes);
            statement.setInt(6, employeeId);

            int rows = statement.executeUpdate();
            if( rows ==1 ) {
                System.out.println("  잘 됨 ");
            } else {
                System.out.println("문제 있음");
            }

        }
        model.addAttribute("employee", Map.of("lastName", lastName, "firstName", firstName,
                "birthDate", birthDate, "photo", photo, "notes", notes));
        rttr.addAttribute("id", employeeId);
        return "redirect:/main25/sub7";

    }

    // MyDto18 만들어서 하는 방법
//    @PostMapping("sub7")
//    public String method8(MyDto18Employee employee, RedirectAttributes rttr) throws SQLException {
//        String sql = """
//                UPDATE employees
//                SET
//                    lastName = ?,
//                    firstName = ?,
//                    photo = ?,
//                    birthDate = ?,
//                    notes = ?
//                WHERE
//                    employeeId = ?
//                """;
//        Connection connection = dataSource.getConnection();
//        PreparedStatement statement = connection.prepareStatement(sql);
//        try (connection; statement) {
//            statement.setString(1, employee.getLastName());
//            statement.setString(2, employee.getFirstName());
//            statement.setString(3, employee.getPhoto());
//            statement.setTimestamp(4, Timestamp.valueOf(employee.getBirthDate().atStartOfDay()));
//            statement.setString(5, employee.getNotes());
//            statement.setInt(6, employee.getId());
//
//            int rows = statement.executeUpdate();
//
//            if (rows == 1) {
//                rttr.addFlashAttribute("message", "직원 정보가 변경되었습니다.");
//            } else {
//                rttr.addFlashAttribute("message", "직원 정보가 변경되지 않았습니다.");
//            }
//
//        }
//
//        rttr.addAttribute("id", employee.getId());
//
//        return "redirect:/main25/sub7";
//    }


    @GetMapping("sub9")
    public String method9(RedirectAttributes rttr) {
        // Controller의 request handler 메소드의 리턴이
        // void(또는 null 리턴)이면 view의 이름으로 해석

        //String.이면 view의 이름으로 해석
        // "redirect:" 접두어가 붙으면
        // 응답코드가 302이고 location 응답헤더의 값이 접두어 이후의 값으로 셋팅

        // http:// 세션을 사용하기보다는 RedirectAttributes 이용하는게 안전함

        // addFlashAttribute는 아무거나 넣을수 있음
        // 쿼리스트링에 request parameter로 붙음. /main25/sub9치면 주소에 value가 붙어서 나옴
        rttr.addAttribute("abc", "def");
        rttr.addAttribute("address", "seoul");

        //모델에 붙임( session을 잠깐 거침)
        rttr.addFlashAttribute("email", "abc@gmail.com");

        return "redirect:main25/sub10"; //location응답헤더
    }

    @GetMapping("sub10")
    public void mehtod10(Model model){
        Object email = model.getAttribute("email");
        System.out.println("email = " + email);
        System.out.println("메소드 10 도착");
    }


}
