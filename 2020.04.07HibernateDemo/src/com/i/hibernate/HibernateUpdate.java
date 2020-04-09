package com.i.hibernate;

import java.util.List;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i.entity.Departments;
import com.i.entity.Jobs;

public class HibernateUpdate {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Departments.class)
				.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		
		session.beginTransaction();
	
	Departments dept= session.get(Departments.class, 20);
	dept.setDepartment_name("Marketing");

		session.getTransaction().commit();
		
		
	/*	session.beginTransaction();
		
		session.createQuery("update Departments set department_name='PAZARLAMA' where id=20").executeUpdate();
		
			session.getTransaction().commit();
		*/
	}

}
