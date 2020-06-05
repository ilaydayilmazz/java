package com.i.dao;

import java.util.List;

import com.i.domain.Kurs;

public interface KursDAO {

	List<Kurs> getKurslar();

	Kurs getKurs(int kursId);

	void saveKurs(Kurs kurs);

	int deleteKurs(int kursid);



}
