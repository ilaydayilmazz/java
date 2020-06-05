package com.i.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
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
@Table(name="KUTUPHANE")
public class Kutuphane {


	@Id
	@Column(name ="ID")
	private int id;
	
	@Column(name ="KITAP_ADI")
	private String kitapAdi;
	
	@Column(name ="YAZAR")
	private String yazar;
	
	@Column(name ="VERILIS_TARIHI")
	private Date verilisTarihi;
	
	@Column(name ="TESLIM_TARIHI")
	private Date teslimTarihi;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OGRENCI_ID")
	private OgrenciIsleri ogrenciIsleri;

	public Kutuphane() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}

	public Date getVerilisTarihi() {
		return verilisTarihi;
	}

	public void setVerilisTarihi(Date verilisTarihi) {
		this.verilisTarihi = verilisTarihi;
	}

	public Date getTeslimTarihi() {
		return teslimTarihi;
	}

	public void setTeslimTarihi(Date teslimTarihi) {
		this.teslimTarihi = teslimTarihi;
	}

	public OgrenciIsleri getOgrenciIsleri() {
		return ogrenciIsleri;
	}

	public void setOgrenciIsleri(OgrenciIsleri ogrenciIsleri) {
		this.ogrenciIsleri = ogrenciIsleri;
	}
	
	
	
	
}
