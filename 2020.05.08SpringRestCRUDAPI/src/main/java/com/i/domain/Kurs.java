package com.i.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="KURS")
public class Kurs {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "kurs_seq" )
	@SequenceGenerator(name ="kurs_seq",sequenceName ="KURS_SEQ" ,allocationSize =1  )
	private int id;
	
	@Column(name="KURS_ADI")
	private String kursAdi;
	
	@Column(name="SAAT")
	private int saat;
	
	@ManyToOne
	@JoinColumn(name="ogretmen_id")
	private Ogretmen ogretmen;

	
	
	
	public Kurs() {
		super();
	}

	public Kurs(String kursAdi, int saat, Ogretmen ogretmen) {
		super();
		this.kursAdi = kursAdi;
		this.saat = saat;
		this.ogretmen = ogretmen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKursAdi() {
		return kursAdi;
	}

	public void setKursAdi(String kursAdi) {
		this.kursAdi = kursAdi;
	}

	public int getSaat() {
		return saat;
	}

	public void setSaat(int saat) {
		this.saat = saat;
	}

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	} 
	
	
	
	
}
