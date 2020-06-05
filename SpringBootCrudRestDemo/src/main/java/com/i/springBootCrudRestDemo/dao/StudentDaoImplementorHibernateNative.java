package com.i.springBootCrudRestDemo.dao;

import com.i.springBootCrudRestDemo.model.Student;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class StudentDaoImplementorHibernateNative implements StudentDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> queryAll() {

        Session session = entityManager.unwrap(Session.class);
        List<Student> list= session.createQuery( "from Student",Student.class).getResultList();
        return list;
    }

    @Override
    public Student queryById(int studentId) {
        Session session= entityManager.unwrap(Session.class);
        return session.get(Student.class,studentId);
    }

    @Override
    public Student save(Student student) {
        Session session= entityManager.unwrap(Session.class);
        session.saveOrUpdate(student);
        return student;
    }

    @Override
    public int delete(int studentId) {
        Session session= entityManager.unwrap(Session.class);
        Student student= queryById(studentId);
        session.delete(student);
        return 1;
    }
}
