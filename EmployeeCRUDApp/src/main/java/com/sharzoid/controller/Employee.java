package com.sharzoid.controller;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Employee {
	@Id @GeneratedValue
	private long id;
	@Valid @Embedded
	private Name name;
	@Past @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	@NumberFormat(pattern = "###,###.##")
	private Double salary;
	@Embedded @Valid
	private Address address;
	private String gender;
	
	@NotBlank(message = "Must not be empty")
	@Email
	private String email;
	@Embedded @Valid
	private Phone phoneNumber;
	
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	public Phone getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Phone phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + ", address=" + address
				+ ", gender=" + gender + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	public void copyEmployee(Employee e) {
		
		this.name = e.name;
		this.dob = e.dob;
		this.salary = e.salary;
		this.address = e.address;
		this.gender = e.gender;
		this.email = e.email;
		this.phoneNumber = e.phoneNumber;
		
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
