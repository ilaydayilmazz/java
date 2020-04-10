package com.i.hibernate;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i.entity.Kurs;
import com.i.entity.Ogretmen;
import com.i.entity.OgretmenDetay;


public class HibernateOneToManyDML {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		
		
		
		session.beginTransaction();
		
		Ogretmen ogr= session.get(Ogretmen.class, 13);
		/*Kurs k;
		for(int i= 0; i<ogr.getKurslar().size() ;i++) {
				
		System.out.println(ogr.getKurslar().get(i));
		}*/
		
		Kurs k = ogr.getKurslar().get(0);
		
		ogr.getKurslar().remove(0); //ogretmenden cikartildi
		//session.remove(k); kurslardan cikarildi
		
		Kurs k2 = ogr.getKurslar().get(0);
		k2.setKurs_adi("DB2");
		//session.save(k2);
		
		session.save(ogr);
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
