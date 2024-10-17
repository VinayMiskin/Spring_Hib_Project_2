package com.sharzoid.controller;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
@Embeddable
public class Name {
	@NotBlank 
	@Length(max = 30, min = 3)
	private String fname;
	@NotBlank 
	@Length(max = 30, min = 3)
	private String lname;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return fname + " " + lname ;
	}
	
	
}
