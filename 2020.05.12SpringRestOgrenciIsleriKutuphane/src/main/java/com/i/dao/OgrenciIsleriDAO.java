package com.i.dao;

import java.util.List;

import com.i.domain.OgrenciIsleri;

public interface OgrenciIsleriDAO {

	List<OgrenciIsleri> getOgrenciIsleri();
	
	OgrenciIsleri getOgrenci(int id);

	void saveOgrenci(OgrenciIsleri ogrenci);

	OgrenciIsleri getOgrencifromOgrNo(int ogrNo);

	

	

}
