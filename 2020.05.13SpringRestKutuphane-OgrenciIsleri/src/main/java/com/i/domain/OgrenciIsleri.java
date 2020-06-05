package com.i.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="OGRENCI_ISLERI")
public class OgrenciIsleri {

	@Id
	@Column(name ="ID")
	private int id;
	
	@Column(name ="OGRENCI_NO")
	private int ogrenciNo;
	
	@Column(name ="AD")
	private String ad;
	
	@Column(name ="SOYAD")
	private String soyad;
	
	
	
	
	public OgrenciIsleri() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOgrenciNo() {
		return ogrenciNo;
	}

	public void setOgrenciNo(int ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	
	
	
	
}
