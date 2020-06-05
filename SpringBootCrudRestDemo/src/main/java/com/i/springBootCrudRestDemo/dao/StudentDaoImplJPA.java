package com.i.springBootCrudRestDemo.dao;

import com.i.springBootCrudRestDemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository("studentDaoImplJPA")
public class StudentDaoImplJPA  implements StudentDao{

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Student> queryAll() {
        return entityManager.createQuery("from Student",Student.class).getResultList();
    }

    @Override
    public Student queryById(int studentId) {
        return entityManager.find(Student.class,studentId);
    }

    @Override
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public int delete(int studentId) {

      entityManager.remove(queryById(studentId));
      return  1;
    }
}
