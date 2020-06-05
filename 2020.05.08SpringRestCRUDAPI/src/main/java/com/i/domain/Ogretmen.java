package com.i.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OGRETMEN")
public class Ogretmen {

	@Id
	@Column(name="ID" )
	private int id;
	
	@Column(name="FIRST_NAME" )
	private String firstName;
	
	@Column(name="LAST_NAME" )
	private String lastName;
	
	@Column(name="EMAIL" )
	private String email;
	
	/*@Column(name="OGRETMEN_DETAY_ID" )
	private int ogretmenDetayId;
*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

/*	public int getOgretmenDetayId() {
		return ogretmenDetayId;
	}

	public void setOgretmenDetayId(int ogretmenDetayId) {
		this.ogretmenDetayId = ogretmenDetayId;
	}
	*/
	
}
