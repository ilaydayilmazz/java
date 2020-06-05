package com.i.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.i.domain.Ogrenci;
@Repository
public class OgrenciDAOImpl implements OgrenciDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Ogrenci> getOgrenciler() {
		
		List<Ogrenci> ogrenciler;
		Session session= sessionFactory.getCurrentSession();
		Query<Ogrenci> query= session.createQuery("from Ogrenci order by isim",Ogrenci.class);
		ogrenciler=query.getResultList();
		return ogrenciler;
	}

	@Override
	public Ogrenci getOgrenci(int ogrenciId) {
		
		Session session= sessionFactory.getCurrentSession();
		return session.get(Ogrenci.class, ogrenciId);
		
		
	}

	@Override
	public void saveOgrenci(Ogrenci ogrenci) {
		Session session= sessionFactory.getCurrentSession();	
		session.saveOrUpdate(ogrenci);
		
	}

	@Override
	public int deleteOgrenci(int ogrId) {
		Session session= sessionFactory.getCurrentSession();	
		Query query= session.createQuery("delete from Ogrenci "+"where id=:prmOgrId ");
		
		query.setParameter("prmOgrId",ogrId);
		
		return query.executeUpdate();
		
	}

}
