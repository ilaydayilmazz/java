package com.i.springBootCrudRestDemo.rest;

import com.i.springBootCrudRestDemo.model.Student;
import com.i.springBootCrudRestDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return studentService.get(studentId);
    }

    @GetMapping("")
    public List<Student> getStudents(){
        return studentService.listAll();
    }

    @PostMapping("")
    public Student add(@RequestBody Student student){

        student.setId(0);
        return studentService.save(student);
    }
    @PutMapping("")
    public Student update(@RequestBody Student student){

        return studentService.save(student);
    }

    @DeleteMapping("/{studentId}")
    public int delete(@PathVariable int studentId){

        return studentService.delete(studentId);
    }

}
