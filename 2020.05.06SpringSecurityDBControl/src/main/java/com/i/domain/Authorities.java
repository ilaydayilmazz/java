package com.i.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AUTHORITIES")
public class Authorities {

	@Id
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Users users;
	
	@Column(name="AUTHORITY")
	private String authority;

	public Authorities() {
		super();
	}

	public Authorities(Users users, String authority) {
		super();
		this.users = users;
		this.authority = authority;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
}
