package com.i.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.i.domain.Kutuphane;
import com.i.domain.OgrenciIsleri;
@Repository
public class KutuphaneDAOImpl implements KutuphaneDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Kutuphane> getKutuphane() {
		List<Kutuphane> kutuphane;
		Session session= sessionFactory.getCurrentSession();
		Query <Kutuphane> query= session.createQuery("from Kutuphane order by kitapAdi",Kutuphane.class);
		kutuphane=query.getResultList();
		return kutuphane;
	}


	@Override
	public Kutuphane getKitap(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Kutuphane.class, id);
	}


	@Override
	public void saveKitap(Kutuphane ktp) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ktp);
		
	}


	@Override
	public OgrenciIsleri getOgrenci(int indeks) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(OgrenciIsleri.class, indeks);
	}



}
