package com.i.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.i.domain.Kurs;

@Repository
public class KursDAOImpl implements KursDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Kurs> getKurslar() {
		
		List<Kurs> kurslar;
		Session session=sessionFactory.getCurrentSession();
		Query<Kurs> query= session.createQuery("from Kurs order by kurs_adi",Kurs.class);
		kurslar=query.getResultList();
		return kurslar;
		
	}


	@Override
	public Kurs getKurs(int kursId) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Kurs.class,kursId);
	}


	@Override
	public void saveKurs(Kurs kurs) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(kurs);
		
	}


	@Override
	public int deleteKurs(int kursid) {
	Session session=sessionFactory.getCurrentSession();
	Query  query= session.createQuery("delete from Kurs "+"where id=:prmkursid " );
	query.setParameter("prmkursid", kursid);
	return query.executeUpdate();
	
	}

}
