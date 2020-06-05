package com.i.dao;

import java.util.List;

import com.i.domain.Kutuphane;
import com.i.domain.OgrenciIsleri;

public interface KutuphaneDAO {

	List<Kutuphane> getKutuphane();

	Kutuphane getKitap(int id);

	void saveKitap(Kutuphane ktp);

	OgrenciIsleri getOgrenci(int indeks);


}
