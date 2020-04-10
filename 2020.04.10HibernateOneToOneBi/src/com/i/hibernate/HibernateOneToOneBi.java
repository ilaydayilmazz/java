package com.i.hibernate;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i.entity.Ogretmen;
import com.i.entity.OgretmenDetay;


public class HibernateOneToOneBi {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		OgretmenDetay od = new OgretmenDetay("su","ssy","http://google.com/asdfy","izy");
		Ogretmen ogr= new Ogretmen(od,"ilay","zey","lyyy@gmail.com");
		session.beginTransaction();
		OgretmenDetay ogrDty = session.get(OgretmenDetay.class,8);

		session.save(od);
		session.save(ogr);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println(ogrDty);
		System.out.println(ogrDty.getOgretmen() );
	}

}
