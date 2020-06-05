package com.i.springboot.thymeleafDemo.controller;

import com.i.springboot.thymeleafDemo.model.Student;
import com.i.springboot.thymeleafDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/list")
    public String listStudents(Model model){
   model.addAttribute("students" , studentService.listAll());
   return "student-list";
    }

    @GetMapping("/add")
    public String showFormEmpty(Model model){
     Student std= new Student("a","b",2);
     model.addAttribute("student",std);
     return "student-form";
    }

    @GetMapping("/update/{studentId}")
    public String showFormforUpdate(Model model, @PathVariable("studentId") int studentId){
        Student std= studentService.get(studentId);
        model.addAttribute("student",std);
        return "student-form";
    }


    @PostMapping("/save")
   public String saveForm(@ModelAttribute ("student") Student std){
    studentService.save(std);
    return "redirect:/list";
    }

    @GetMapping("/delete/{studentId}")
    public String delete(@PathVariable("studentId") int studentId){
        studentService.delete(studentId);
        return "redirect:/list";
    }




}
