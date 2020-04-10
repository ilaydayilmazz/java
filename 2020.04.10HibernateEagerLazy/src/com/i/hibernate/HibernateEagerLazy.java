package com.i.hibernate;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i.entity.Kurs;
import com.i.entity.Ogretmen;
import com.i.entity.OgretmenDetay;


public class HibernateEagerLazy {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		
		/*Ogretmen ogr= new Ogretmen(null,"i","y","yyi@gmail.com");
		ogr.setOgretmenDetay(new OgretmenDetay("l","yl","z","c"));
		ogr.addKurs(new Kurs("js",400, ogr));
		ogr.addKurs(new Kurs("css",300, null));
		ogr.addKurs(new Kurs("html",200, null));
		ogr.addKurs(new Kurs("mobil",100, null));
		*/
		session.beginTransaction();

		Ogretmen i= session.get(Ogretmen.class, 19);
		//kurslara referans yapildi
		i.getKurslar().size();
		
		//session.save(ogr);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println(i);
		System.out.println(i.getKurslar());
	}

}
