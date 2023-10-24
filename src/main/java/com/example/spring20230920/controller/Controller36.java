package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao7;
import com.example.spring20230920.domain.MyDto39;
import com.example.spring20230920.domain.MyDto40;
import com.example.spring20230920.domain.MyDto41;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.EditorAwareTag;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("main36")
@RequiredArgsConstructor
public class Controller36 {


    private final MyDao7 dao;
    @GetMapping("sub1")
    public void method1() {


    }

    // axios.get("/main36/sub2", {params: {id: 7}})     -> F12열어서 콘솔에 입력하면 나옴
    // 요청하면 답이  /main36/sub2?id=5로 옴
    @GetMapping("sub2")
    public void method2(Integer id) {
        Map<String, Object> data = dao.selectByCustomerId(id);//다오한테 일시킴 . 응답받은걸 data라는 곳에 담음
        System.out.println("data = " + data);
    }


    // js 코드?: axios.get("/main36/sub3", {params: {id: 2}}) 써서 콘솔 열어서 실행해보기
    /*
    request메소드로 보내는경우
    axios.request({
       url: "/main36/sub3",
       method: "get",
       params: {id:2}
    */
    // /main36/sub3?id=2
    @GetMapping("sub3")
    public void method3(Integer id) {
        Map<String, Object> data =dao.selectByEmployeeId(id);
        System.out.println("data = " + data);
    }


    /*
     axios.post("/main36/sub4", {
            lastName: "손",
            firstName: "흥민",
            birthDate: "2020-02-02"
            }, {
               headers: {
                    "content-type": "application/x-www-form-urlencoded"
                    }
              })
    */
    // post방식 /main36/sub4
    // lastName=손&firtstName=흥민&birthDate=2020-02-02
    @PostMapping("sub4")
    public void method4(String lastName,
                        String firstName,
                        LocalDate birthDate) {
        int i = dao.insertEmployee(lastName, firstName, birthDate);
        System.out.println(i + "개 데이터가 잘 입력됨");
    }


    //브라우저 개발자도구 콘솔에 axios 코드 작성 후 실행
    /*
        axios.post("/main36/sub5", {
                name: "라면",
                price: 150.00,
                category: 3
                }, {
                    headers: {
                     "content-type": "application/x-www-form-urlencoded"
                     }
                })
    */
    // /post방식으로 /main36/sub5
    // name=라면&price=150.00&category=3
    @PostMapping("sub5")
    public void method5(String name,
                        Double price,
                        Integer category) {
        int r = dao.insertProduct(name, price, category);
    }


    /*
    axios.delete("/main36/sub6")   .이걸 F12콘솔창에 찍으면 프린트 찍힘
    */
//    @RequestMapping(method = RequestMethod.DELETE, value = "sub6") >
    @DeleteMapping("sub6") //위에 주석처리한 것과 같은 결과를 나타냄.
    public void method6() {
        System.out.println("Controller36.method6");

    }


    /*
    axios.delete("/main36/sub7")을 콘솔에 요청하면 스프링을 이걸 받아서 method7을 실행함
    * */
    @DeleteMapping("sub7")
    public void method7() {
        System.out.println("Controller36.method7");
    }


    /*
    axios.delete("/main36/sub8?name=son")  아래 방식으로 해도 됨
    axios.delete("/main36/sub8", {
        params: {
            name: "son"
            }
    })
    */
    @DeleteMapping("sub8")
    public void method8(String name) {
        System.out.println("name = " + name);
    }




    /*
     axios.delete("/main36/sub9/son")  -> {name}에 son이 들어간다는 뜻
     * */
    // PathVariable: 경로에 포함된 데이터
    @DeleteMapping("sub9/{name}") //param과 같게 써야함
    public void method9(@PathVariable("name") String n) {
        System.out.println("n = " + n);
    }


    /*
    axios.delete("/main36/sub10/3")
    axios.delete("/main36/sub10/5")
    axios.delete("/main36/sub10/7")
    * */
    // delete방식으로 main36/sub10 요청이 왔을때 일하는 메소드 작성
    // 3, 5, 7은 메소드 아규먼트로 받아서 콘솔에 출력하도록
    @DeleteMapping("sub10/{id}")
    public void method10(@PathVariable("id") Integer id) { //RequestParam처럼 셋의 이름이 같다면 @PathVariable("id")에서 id는 생략해도 됨
        System.out.println("id = " + id);
    }


    /*
    axios.delete("/main36/sub11/1")
    axios.delete("/main36/sub11/3")
    axios.delete("/main36/sub11/5")
    * */
    @DeleteMapping("sub11/{pid}")
    public void method11(@PathVariable Integer pid) {
        int c = dao.deleteByProductId(pid);
        System.out.println(c + "개 데이터 삭제됨" );
    }

    /*
    axios.delete("/main36/sub12/1")
    axios.delete("/main36/sub12/3")
    axios.delete("/main36/sub12/5")
    */
    @DeleteMapping("sub12/{id}")
    public void method12(@PathVariable Integer id) {
        int i = dao.deleteByCustomerId(id);
        System.out.println(i + "개 데이터 삭제됨");
    }



    /*
    axios.put("/main36/sub13") 으로 요청하면
    put방식으로 /mian36/sub13으로 감
    */
//    @RequestMapping(method= RequestMethod.PUT, value = "sub13")
    @PutMapping("sub13") //위에 쓴거랑 같은 결과가 나옴
    public void method13() {
        System.out.println("Controller36.method13");
    }



    /*
    axios.put("/main36/sub14", {
        name: "son",
        address: "korea"
     }, {
        headers: {
            "content-type" : "application/x-www-form-urlencoded"
        }
     })
     */
    // put방식으로 /main36/sub14
    // name=son&address=korea
    @PutMapping("sub14")
    public void method14(String name, String address) {
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }



    /*
    axios.put("/main36/sub15", {
        city: "seoul",
        age: 78,
        score: 3.14
        }, {
        headers: {
            "content-type" : "application/x-www-form-urlencoded"
        }
     });
    */
//    @PutMapping("sub15")
//    public void method15(String city, Integer age, Double score) {
//        System.out.println("city = " + city);
//        System.out.println("age = " + age);
//        System.out.println("score = " + score);
//    }

    // 위에껄 MyDto39로 받은것.
    @PutMapping("sub15")
    public void method15(MyDto39 dto) {
        System.out.println("city = " + dto.getCity());
        System.out.println("age = " + dto.getAge());
        System.out.println("score = " + dto.getScore());
    }




    /*
    axios.put("/main36/sub16", {
        id: 3,
        name: "햄버거",
        category: 2,
        price: 5000.00
        }, {
           headers: {
            "content-type" : "application/x-www-form-urlencoded"
        }
     });
    * */
    @PutMapping("sub16")
    public void method16(MyDto40 dto) {
        int rows = dao.updateProduct(dto);
        System.out.println(rows + "개 데이터 업데이트 됨");
    }


    /*
    axios.put("/main36/sub17", {
            lastName: "lee",
            firstName: "kangin",
            birthDate: "2020-01-01",
            id: 5
    }, {
            headers: {
                "content-type" : "application/x-www-form-urlencoded"
            }
     });
    */
    @PutMapping("sub17")
    public void method17(MyDto41 dto) {
        int rows = dao.updateEmployee(dto);
        System.out.println(rows + "개 업데이트 됨");
    }






















}
