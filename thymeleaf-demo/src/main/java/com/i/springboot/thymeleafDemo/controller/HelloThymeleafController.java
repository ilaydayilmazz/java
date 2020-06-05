package com.i.springboot.thymeleafDemo.controller;

import com.i.springboot.thymeleafDemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloThymeleafController {

    List<Student> studentList;

    @PostConstruct
    public void fillStudentList(){
        studentList= new ArrayList<>();
        studentList.add(new Student("aa","b",1));
        studentList.add(new Student("ca","d",2));
        studentList.add(new Student("fa","g",3));

    }

    @GetMapping("/hello")
    public String hello(Model model){

        model.addAttribute("tarih",new Date());
        model.addAttribute("isim", "ilayda");
        return "hellooo";
    }
   /* @GetMapping("/list")
    public String listStudents(Model model){
        model.addAttribute("students",studentList);
        return "student-list";
    }*/




}
