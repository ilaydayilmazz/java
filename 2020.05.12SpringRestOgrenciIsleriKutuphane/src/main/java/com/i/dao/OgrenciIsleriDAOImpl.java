package com.i.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.i.domain.OgrenciIsleri;
@Repository
public class OgrenciIsleriDAOImpl implements OgrenciIsleriDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<OgrenciIsleri> getOgrenciIsleri() {
		
		List<OgrenciIsleri> ogrenciIsleri;
		Session session= sessionFactory.getCurrentSession();
		Query<OgrenciIsleri> query= session.createQuery("from OgrenciIsleri order by ad",OgrenciIsleri.class);
		ogrenciIsleri=query.getResultList();
		return ogrenciIsleri;
		
	}


	@Override
	public void saveOgrenci(OgrenciIsleri ogrenci) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(ogrenci);
		
	}

	@Override
	public OgrenciIsleri getOgrencifromOgrNo(int ogrNo) {
		Session session=sessionFactory.getCurrentSession();
		Query<OgrenciIsleri> query= session.createQuery("from OgrenciIsleri where ogrenciNo=:ogrNumber and"  
				+" ogrencilikDurumu=:aktiflik",OgrenciIsleri.class);
		query.setParameter("ogrNumber", ogrNo);
		query.setParameter("aktiflik", 1);
		List<OgrenciIsleri> resultList= query.getResultList();
		if(!resultList.isEmpty()) {
			return resultList.get(0);
		}
		else {
			return null;
		}
	}


	@Override
	public OgrenciIsleri getOgrenci(int id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(OgrenciIsleri.class, id);
	}

}
