package com.i.springboot.thymeleafDemo.service;

import com.i.springboot.thymeleafDemo.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl  implements  StudentService {

    List<Student> studentList;
    int nextStudentId=1;

    @PostConstruct
    public void fillStudentList(){
        studentList= new ArrayList<>();
        studentList.add(new Student("aa","b",nextStudentId++));
        studentList.add(new Student("ca","d",nextStudentId++));
        studentList.add(new Student("fa","g",nextStudentId++));

    }

    @Override
    public List<Student> listAll() {
        return studentList;
    }

    @Override
    public Student get(int studentId) {
        for (Student std:
             studentList) {

            if (std.getStudentId()==studentId)
                return std;
        }
        return null;
    }

    @Override
    public Student save(Student student) {
        if (student.getStudentId()==null){
            student.setStudentId(nextStudentId++);
            studentList.add(student);
        }
       else{
            for (Student std: studentList
                 ) {
                if (std.getStudentId()==student.getStudentId()){
                    studentList.add(student);
                    studentList.remove(std);
                    break;
                }

            }
        }
        return student;
    }

    @Override
    public int delete(int studentId) {
        for (Student std:
                studentList) {
            if (std.getStudentId()==studentId){
                studentList.remove(std);
                return 1;
            }
        }
        return 0;
    }
}
