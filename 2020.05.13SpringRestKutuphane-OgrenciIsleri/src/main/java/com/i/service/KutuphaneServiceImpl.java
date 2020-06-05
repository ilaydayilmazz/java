package com.i.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i.dao.KutuphaneDAO;
import com.i.domain.Kutuphane;
import com.i.domain.OgrenciIsleri;
@Service
public class KutuphaneServiceImpl implements KutuphaneService {

	@Autowired
	private KutuphaneDAO kutuphaneDAO;
	
	
	@Override
	@Transactional
	public List<Kutuphane> getKutuphane() {
		
		return kutuphaneDAO.getKutuphane();
	}


	@Override
	@Transactional
	public Kutuphane getKitap(int id) {
		return kutuphaneDAO.getKitap(id);
	}


	@Override
	@Transactional
	public void saveKitap(Kutuphane ktp) {
		kutuphaneDAO.saveKitap(ktp);
		
	}


	@Override
	@Transactional
	public OgrenciIsleri getOgrenci(int indeks) {
		return kutuphaneDAO.getOgrenci(indeks);
	}



}
