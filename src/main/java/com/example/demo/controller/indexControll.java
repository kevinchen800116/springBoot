package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.student;
import com.example.demo.service.studentService;


@RestController
public class indexControll {
    public studentService service;

    // @Autowired
    public indexControll(studentService service) {
        this.service = service;
    }

 
    @GetMapping("/")
    public ModelAndView index(){
        System.out.println("index查看");
        // DB取值查詢
        Iterable<student> user = service.getStudent();
        // 創建對應的html頁面
        ModelAndView modelAndView=new ModelAndView("index");
        // 將查詢的值塞入頁面內
        modelAndView.addObject("user", user);

        return modelAndView;
    }

}
