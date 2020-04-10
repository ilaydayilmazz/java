package com.i.hibernate;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.i.entity.Ogretmen;
import com.i.entity.OgretmenDetay;


public class HibernateOneToOneDeleteAll {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
	
		session.beginTransaction();
		OgretmenDetay ogrDty = session.get(OgretmenDetay.class, 9);
		session.delete(ogrDty);
		session.getTransaction().commit();
		session.close();

		
	}

}
