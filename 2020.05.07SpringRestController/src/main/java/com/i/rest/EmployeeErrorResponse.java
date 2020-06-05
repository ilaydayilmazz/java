package com.i.rest;

public class EmployeeErrorResponse {
	
	private int status;
	private String message;
	
	public EmployeeErrorResponse() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
