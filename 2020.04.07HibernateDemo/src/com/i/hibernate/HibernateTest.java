package com.i.hibernate;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i.entity.Departments;
import com.i.entity.Jobs;

public class HibernateTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Jobs.class)
				.buildSessionFactory();
	
		Session session= sessionFactory.getCurrentSession();

		
		Jobs jobs=new Jobs("TEST","TEST MUH",3000,5000);
		session.beginTransaction();
		session.save(jobs);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
