package com.i.dao;

import java.util.List;

import com.i.domain.Ogrenci;

public interface OgrenciDAO {

	List<Ogrenci> getOgrenciler();

	Ogrenci getOgrenci(int ogrenciId);

	void saveOgrenci(Ogrenci ogrenci);

	int deleteOgrenci(int ogrId);

}
