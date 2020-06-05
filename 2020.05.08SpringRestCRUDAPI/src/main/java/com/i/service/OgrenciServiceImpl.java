package com.i.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i.dao.OgrenciDAO;
import com.i.domain.Ogrenci;

@Service
public class OgrenciServiceImpl implements OgrenciService {

	@Autowired
	private OgrenciDAO ogrenciDAO;
	
	
	
	@Override
	@Transactional
	public List<Ogrenci> getOgrenciler() {
		
		return ogrenciDAO.getOgrenciler();
	}

	@Override
	@Transactional
	public Ogrenci getOgrenci(int ogrenciId) {
		
		return ogrenciDAO.getOgrenci(ogrenciId);
	}

	@Override
	@Transactional
	public void addOgrenci(Ogrenci ogrenci) {
		ogrenciDAO.saveOgrenci(ogrenci);
		
	}

	@Override
	@Transactional
	public void updateOgrenci(Ogrenci ogrenci) {
		ogrenciDAO.saveOgrenci(ogrenci);
		
	}

	@Override
	@Transactional
	public int deleteOgrenci(int ogrId) {
		return ogrenciDAO.deleteOgrenci(ogrId);
		
	}

}
