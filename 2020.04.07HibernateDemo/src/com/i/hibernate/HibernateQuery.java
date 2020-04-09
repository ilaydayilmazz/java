package com.i.hibernate;

import java.util.List;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i.entity.Departments;
import com.i.entity.Jobs;

public class HibernateQuery {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Departments.class)
				.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		
		session.beginTransaction();
	//obj field isimleri cq icin classdan alinir
	List<Departments> depts= session.createQuery("from Departments where location_id=1700") 
			.getResultList();
	
	for (Departments dept: depts) {
		System.out.println(dept.getDepartment_name());
	}
		session.getTransaction().commit();
	}

}
