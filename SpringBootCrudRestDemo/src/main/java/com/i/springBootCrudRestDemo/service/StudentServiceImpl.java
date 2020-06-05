package com.i.springBootCrudRestDemo.service;

import com.i.springBootCrudRestDemo.dao.StudentDao;
import com.i.springBootCrudRestDemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    @Qualifier("studentDaoImplJPA")
    private StudentDao studentDao;

    @Override
    @Transactional
    public List<Student> listAll() {
        return studentDao.queryAll();
    }

    @Override
    @Transactional
    public Student get(int studentId) {
        return studentDao.queryById(studentId);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    @Transactional
    public int delete(int studentId) {
        return studentDao.delete(studentId);
    }
}
