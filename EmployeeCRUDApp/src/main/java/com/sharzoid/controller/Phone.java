package com.sharzoid.controller;

import javax.persistence.Embeddable;

import com.sharzoid.custom.annoations.PhoneNumber;

@Embeddable
public class Phone {
	
	private String countryCode;
	@PhoneNumber
	private String number;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return countryCode + "-" + number ;
	}
	
	

}
