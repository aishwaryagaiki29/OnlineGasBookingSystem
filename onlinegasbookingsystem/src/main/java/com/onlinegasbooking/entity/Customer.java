package com.onlinegasbooking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class Customer {
	 @Id
	 @GeneratedValue
	 private Integer customerId;
	 @NotNull(message ="Please enter your aadhar details" )
	 private String aadharCard;
	 private String connectionStatus;
	 private String address;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinTable(name = "customer_cylinder")
	 private Cylinder cylinder;

	 @OneToOne
	 private Customer customer;

	public Customer() {
		super();
	}

	public Customer(Integer customerId, @NotNull(message = "Please enter your aadhar details") String aadharCard,
			String connectionStatus, String address, Cylinder cylinder, Customer customer) {
		super();
		this.customerId = customerId;
		this.aadharCard = aadharCard;
		this.connectionStatus = connectionStatus;
		this.address = address;
		this.cylinder = cylinder;
		this.customer = customer;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(String connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Cylinder getCylinder() {
		return cylinder;
	}

	public void setCylinder(Cylinder cylinder) {
		this.cylinder = cylinder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
