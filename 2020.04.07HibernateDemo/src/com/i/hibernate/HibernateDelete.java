package com.i.hibernate;

import java.util.List;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i.entity.Departments;
import com.i.entity.Jobs;

public class HibernateDelete {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Departments.class)
				.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		
	session.beginTransaction();
	
	Departments dept= session.get(Departments.class, 290);
	session.delete(dept);

		session.getTransaction().commit();
		
		
		/*session.beginTransaction();
		
		session.createQuery("delete Departments where id=300").executeUpdate();
		
			session.getTransaction().commit();
		*/
	}

}
