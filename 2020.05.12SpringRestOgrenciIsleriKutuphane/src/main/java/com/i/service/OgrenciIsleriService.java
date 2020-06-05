package com.i.service;

import java.util.List;

import com.i.domain.OgrenciIsleri;

public interface OgrenciIsleriService {

	public List<OgrenciIsleri> getOgrenciIsleri();
	
	public OgrenciIsleri getOgrenci(int id);

	public void saveOgrenci(OgrenciIsleri ogrenci);

	public OgrenciIsleri getOgrencifromOgrNo(int ogrNo);

	

}
