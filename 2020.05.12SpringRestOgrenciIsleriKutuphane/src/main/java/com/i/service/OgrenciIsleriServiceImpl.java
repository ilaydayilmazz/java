package com.i.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.i.dao.OgrenciIsleriDAO;

import com.i.domain.OgrenciIsleri;
@Service
public class OgrenciIsleriServiceImpl implements OgrenciIsleriService {

	@Autowired
	private OgrenciIsleriDAO ogrenciIsleriDAO;
	
	
	@Override
	@Transactional
	public List<OgrenciIsleri> getOgrenciIsleri() {
		
		return ogrenciIsleriDAO.getOgrenciIsleri();
	}



	@Override
	@Transactional
	public void saveOgrenci(OgrenciIsleri ogrenci) {
		ogrenciIsleriDAO.saveOgrenci(ogrenci);
		
	}

	@Override
	@Transactional
	public OgrenciIsleri getOgrencifromOgrNo(int ogrNo) {
		
		return ogrenciIsleriDAO.getOgrencifromOgrNo(ogrNo);
	}



	@Override
	@Transactional
	public OgrenciIsleri getOgrenci(int id) {
		
		return ogrenciIsleriDAO.getOgrenci(id);
	}


	
}
