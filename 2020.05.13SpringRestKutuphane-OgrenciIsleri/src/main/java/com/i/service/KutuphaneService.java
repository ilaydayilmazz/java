package com.i.service;

import java.util.List;

import com.i.domain.Kutuphane;
import com.i.domain.OgrenciIsleri;

public interface KutuphaneService {

	public List<Kutuphane> getKutuphane();

	public Kutuphane getKitap(int id);

	public void saveKitap(Kutuphane ktp);

	public OgrenciIsleri getOgrenci(int indeks);

	

}
