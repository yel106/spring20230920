package com.example.spring20230920.service;

import com.example.spring20230920.dao.MyDao6;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //서비스 안에 @Component가 포함되어 있음
@RequiredArgsConstructor
@Transactional  (rollbackFor = Exception.class) //서비스가 하나의 트랜잭션을 가지고있기 때문에
//메소드 하나에 어노테이션 달기보다는 서비스 클래스 전체에 어노테이션을 주면 됨
public class MyService1 {

    private final MyDao6 dao;
    //업무에 동시에 처리되길 원하면 transactional 어노테이션을 붙여야함
    // 메소드를 안에서 호출했으니 프록시를 거치지 않아서 우리의 의도대로 되지 않음. 콘트롤러나 서비스로 뺴야함
    public void tx1(){
        dao.update1();
//        int c = 1/0; //RuntimeException이 생기면 일을 하지 못함. 롤백돼서 아직도 10000원
        dao.update2();
    }






}
