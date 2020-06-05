package com.i.service;

import java.util.List;

import com.i.domain.Kurs;

public interface KursService {

	public 	List<Kurs> getKurslar();

	public Kurs getKurs(int kursId);

	public void addKurs(Kurs kurs);

	public void updateKurs(Kurs kurs);

	public int deleteKurs(int kursid);

}
