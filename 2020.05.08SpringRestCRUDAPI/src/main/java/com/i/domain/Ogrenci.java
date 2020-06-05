package com.i.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OGRENCI")
public class Ogrenci {

	@Id
	@Column(name ="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ogr-seq")
	@SequenceGenerator(name = "ogr-seq",sequenceName = "OGRENCI_SEQ", allocationSize = 1)
	private int id;
	
	@Column(name ="ISIM")
	private String isim;
	
	@Column(name ="SOYISIM")
	private String soyisim;
	
	@Column(name ="OGRENCI_NO")
	private int ogrenciNo;
	
	@Column(name ="MEZUNIYET_TARIHI")
	private Date mezuniyetTarihi;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public int getOgrenciNo() {
		return ogrenciNo;
	}

	public void setOgrenciNo(int ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}

	public Date getMezuniyetTarihi() {
		return mezuniyetTarihi;
	}

	public void setMezuniyetTarihi(Date mezuniyetTarihi) {
		this.mezuniyetTarihi = mezuniyetTarihi;
	}
	
	
	
	
	
}
