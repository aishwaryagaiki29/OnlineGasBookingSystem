package com.onlinegasbooking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {	
	@Id
	@GeneratedValue
	private Integer userId;
	private String userName;
	private String password;
	private String mobileNumber;
	private String email;
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Login(Integer userId, String userName, String password, String mobileNumber, String email,
			Customer customer) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.customer = customer;
	}

	public Login() {
		super();
	}
	
	@OneToOne
	@JoinTable(name ="login_customer")
	private Customer customer;
}
