package com.i.hibernate;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i.entity.Ogretmen;
import com.i.entity.OgretmenDetay;


public class HibernateOneToOne {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
	
		OgretmenDetay ogrDty = new OgretmenDetay("javla","sinlema","http://google.coml","sdlf");
		Ogretmen ogr= new Ogretmen(ogrDty,"leylla","lely","ley@glmail.clom");
		session.beginTransaction();
		session.save(ogrDty);
		session.save(ogr);
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
