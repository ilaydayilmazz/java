package com.i.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Kurs")
public class Kurs {
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(name="kurs_seq",sequenceName="KURS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="kurs_seq")
	private int id;
	


	@Column(name="kurs_adi")
	private String kurs_adi;
	
	@Column(name="saat")
	private int saat;
	
	
	@ManyToOne
	@JoinColumn(name="ogretmen_id")
	private Ogretmen ogretmen;


	public Kurs(String kurs_adi, int saat, Ogretmen ogretmen) {
		super();
		this.kurs_adi = kurs_adi;
		this.saat = saat;
		this.ogretmen = ogretmen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

	public int getSaat() {
		return saat;
	}

	public void setSaat(int saat) {
		this.saat = saat;
	}

	public String getKurs_adi() {
		return kurs_adi;
	}

	public void setKurs_adi(String kurs_adi) {
		this.kurs_adi = kurs_adi;
	}

	public Kurs() {
		super();
	}

	@Override
	public String toString() {
		return "Kurs [id=" + id + ", kurs_adi=" + kurs_adi + ", saat=" + saat + ", ogretmen=" + ogretmen.getId() + "]";
	}

	


	
	
}
