package com.example.spring20230920.controller;

import com.example.spring20230920.dao.DentalDao;
import com.example.spring20230920.domain.dentalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("dental")
@RequiredArgsConstructor
public class DentalController {

    private final DentalDao dentalDao;

    @GetMapping("index")
    public void method1() {
    }

    @GetMapping("patient") //조회용. index에서 patient 페이지로 갔을때 단순히 보여주는 화면
    public void method2() {

    }

    @PostMapping("patient")  //patient에서 '등록'버튼을 눌러서 crud로 가고 ,
                                // crud에서 새 환자정보 입력하면 post 방식으로 받는 용도
    public void insert(dentalDto dto) {
        dentalDao.insert(dto);
    }



    //jsp에서 dto작성할수 있는 form만들기.
    @GetMapping ("insert")
    public void method4() {

    }

    @GetMapping("delete")
    public void method5() {

    }

    @PostMapping("delete")
    public String deleteBychartNumber(@RequestParam("chartNumber") int chartNumber) {
        dentalDao.deleteBychartNumber(chartNumber);
        return "/dental/delete";
    }

    @GetMapping("update")
    public void method6() {

    }

    @PostMapping("update")
    public String update(dentalDto dto) {
        dentalDao.update(dto);
        return "/dental/update";
    }

    @GetMapping("select")
    public void method7() {
    }

    @PostMapping("select")
    public String select(dentalDto dto, Model model) {
        List<Map<String, Objects>> list = dentalDao.selectBychartNumber(dto);
        model.addAttribute("patientList", list);
        return "redirect:/dental/select";
    }


}
