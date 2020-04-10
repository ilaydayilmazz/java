package com.i.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OGRETMEN_DETAY")
public class OgretmenDetay {
	
	@Id
	@Column
	@SequenceGenerator(name="ogretmen_det_seq",sequenceName="OGRETMEN_DETAY_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ogretmen_det_seq")
	private int id;
	
	@OneToOne(mappedBy="ogretmenDetay")
	private Ogretmen ogretmen;

	@Column(name="expertise")
	private String expertise;
	
	@Column(name="hobby")
	private String hobby;
	
	@Column(name="website")
	private String website;

	@Column(name="fb_page")
	private String fbPage;

	

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

	public OgretmenDetay() {
		super();
	}

	public OgretmenDetay(String expertise, String hobby, String website, String fbPage) {
		super();
		this.expertise = expertise;
		this.hobby = hobby;
		this.website = website;
		this.fbPage = fbPage;
	}

	public String getFbPage() {
		return fbPage;
	}

	public void setFbPage(String fbPage) {
		this.fbPage = fbPage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "OgretmenDetay [id=" + id + ", ogretmen=" + ogretmen.getId() + ", expertise=" + expertise + ", hobby=" + hobby
				+ ", website=" + website + ", fbPage=" + fbPage + "]";
	}
	

	
}
