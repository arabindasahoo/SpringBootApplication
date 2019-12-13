package com.themlyf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AdminId")
	private Integer id;
	
	@Column(name = "AdminName")
	@NotEmpty
	private String name;
	
	@Column(name = "AdminEmail")
	@NotEmpty
	private String email;
	
	@Column(name = "AdminPhone")
	@NotEmpty
	private String phone;
	
	@Column(name = "AdminGender")
	@NotEmpty
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "AdminDob")
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "AdminDoj")
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date doj;
	
	@Column(name = "AdminPassword")
	@NotEmpty
	private String password;
	
	@Column(name = "AdminMaritalStatus")
	@NotEmpty
	private String maritalStatus;
	
	@Column(name = "AdminCountry")
	@NotEmpty
	private String country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}