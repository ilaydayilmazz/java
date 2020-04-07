package com.i.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class Departments {
	
	@Id
	@Column(name="department_id")
	@SequenceGenerator(name="dept_seq",sequenceName="DEPARTMENTS_SEQ", allocationSize=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dept_seq")
	private int department_id;
	
	@Column(name="department_name")
	private String department_name;
	
	@Column(name="manager_id")
	private int manager_id;
	
	@Column(name="location_id")
	private int location_id;
	

	public Departments( String department_name, int manager_id, int location_id) {
		super();
		
		this.department_name = department_name;
		this.manager_id = manager_id;
		this.location_id = location_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	
	
}
