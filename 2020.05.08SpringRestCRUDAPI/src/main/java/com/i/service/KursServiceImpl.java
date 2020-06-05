package com.i.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i.dao.KursDAO;
import com.i.domain.Kurs;
@Service
public class KursServiceImpl implements KursService {

	@Autowired
	private KursDAO kursDAO;
	
	
	@Override
	@Transactional
	public List<Kurs> getKurslar() {
		
		return kursDAO.getKurslar();
	}


	@Override
	@Transactional
	public Kurs getKurs(int kursId) {
		
		return kursDAO.getKurs(kursId);
	}


	@Override
	@Transactional
	public void addKurs(Kurs kurs) {
		 kursDAO.saveKurs(kurs);
		
	}


	@Override
	@Transactional
	public void updateKurs(Kurs kurs) {
		 kursDAO.saveKurs(kurs);
		
	}


	@Override
	@Transactional
	public int deleteKurs(int kursid) {
		
		return kursDAO.deleteKurs(kursid);
	}

}
