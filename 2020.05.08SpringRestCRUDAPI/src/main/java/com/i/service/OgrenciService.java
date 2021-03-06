package com.i.service;

import java.util.List;

import com.i.domain.Ogrenci;

public interface OgrenciService {

	public List<Ogrenci> getOgrenciler();
	public Ogrenci getOgrenci(int ogrenciId);
	public void addOgrenci(Ogrenci ogrenci);
	public void updateOgrenci(Ogrenci ogrenci);
	public int deleteOgrenci(int ogrId);
}
