package com.i.hibernate;

import java.util.ArrayList;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.i.entity.Kurs;
import com.i.entity.Ogrenci;
import com.i.entity.Ogretmen;
import com.i.entity.OgretmenDetay;


public class HibernateManyToMany {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml") 
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Ogrenci.class)
				.addAnnotatedClass(Kurs.class)
				.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Ogretmen ogr=session.get(Ogretmen.class, 13);
		Ogrenci ogrenci=session.get(Ogrenci.class, 1);
		for (int i=0;i<ogrenci.getKurslar().size();i++) {
			System.out.println(ogrenci.getKurslar().get(i).getKurs_adi());
		}
		
		/*Kurs kurs = session.get(Kurs.class, 16);
		ogrenci.addKurs(kurs);
		session.save(ogrenci);*/
		
		/*Ogrenci ogrenci1=new Ogrenci("ila","yilmaz",111);
		Ogrenci ogrenci2=new Ogrenci("zey","ulas",122);
		kurs.addOgrenci(ogrenci1);
		kurs.addOgrenci(ogrenci2);
		session.save(kurs);*/

		session.getTransaction().commit();
		session.close();
		
		
	}

}
