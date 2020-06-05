package com.i.SpringRestClient.domain;

import java.sql.Date;



public class Ogrenci {


	private int id;
	

	private String isim;
	

	private String soyisim;
	

	private int ogrenciNo;
	

	private Date mezuniyetTarihi;
	
	

	public Ogrenci() {
		super();
	}

	public Ogrenci(String isim, String soyisim, int ogrenciNo, Date mezuniyetTarihi) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
		this.ogrenciNo = ogrenciNo;
		this.mezuniyetTarihi = mezuniyetTarihi;
	}

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

	@Override
	public String toString() {
		return "Ogrenci [id=" + id + ", isim=" + isim + ", soyisim=" + soyisim + ", ogrenciNo=" + ogrenciNo
				+ ", mezuniyetTarihi=" + mezuniyetTarihi + "]";
	}
	
	
	
	
	
}
