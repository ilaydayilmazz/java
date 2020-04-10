package com.i.hibernate;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i.entity.Kurs;
import com.i.entity.Ogretmen;
import com.i.entity.OgretmenDetay;


public class HibernateOneToMany {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		Ogretmen ogr= new Ogretmen(null,"zey","can","zeyc@glmail.com");
		ogr.addKurs(new Kurs("java",600, ogr));
		ogr.addKurs(new Kurs("db",300, null));
		ogr.addKurs(new Kurs("web",200, null));
		
		
		session.beginTransaction();

	
		session.save(ogr);
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
