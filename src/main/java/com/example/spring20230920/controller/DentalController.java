package com.example.spring20230920.controller;

import com.example.spring20230920.dao.DentalDao;
import com.example.spring20230920.domain.dentalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("dental")
@RequiredArgsConstructor
public class DentalController {

    private final DentalDao dentalDao;

    @GetMapping("index")
    public void create(dentalDto dto) {
        List<dentalDto> patientList = dentalDao.create(dto);
    }

    @GetMapping("patient")
    public void method2() {

    }

    @GetMapping("crud")
    public void method3() {

    }

}
