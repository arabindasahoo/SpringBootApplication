package com.themlyf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name="User_details")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private Integer id;
	
	@Column(name = "userName")
	@NotEmpty
	private String name;
	
	@Column(name = "userEmail")
	@NotEmpty
	private String email;
	
	@Column(name = "userPhone")
	@NotEmpty
	private String phone;
	
	@Column(name = "userDesignation")
	@NotEmpty
	private String designation;
	
	@Column(name = "userGender")
	@NotEmpty
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "userDob")
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "userDoj")
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date doj;
	
	@Column(name = "userPassword")
	@NotEmpty
	private String password;
	
	@Column(name = "userMaritalStatus")
	@NotEmpty
	private String maritalStatus;
	
	@Column(name = "userApproval")
	private Integer approval;
	
	@Column(name = "userCountry")
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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
	public Integer getApproval() {
		return approval;
	}
	public void setApproval(Integer approval) {
		this.approval = approval;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
