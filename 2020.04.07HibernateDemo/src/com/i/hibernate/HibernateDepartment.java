package com.i.hibernate;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i.entity.Departments;
import com.i.entity.Jobs;

public class HibernateDepartment {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Departments.class)
				.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
	
		Departments department= new Departments("software",200,1700);
		session.beginTransaction();
		session.save(department);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
