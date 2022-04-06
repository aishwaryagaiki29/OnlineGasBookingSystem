package com.onlinegasbooking.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*******************************
 *          @author: Vaishnavi Patil       
 *          @version: 1.0   
 *          Description: It contains the fields for Gas Booking such as gasBookingId, bookingDate,
 *          status,bill		                             
 *          Created at: 08-March-2022
 ********************************/
@Entity
@Table(name = "Gasbooking")
public class GasBooking {
	
	@Id
	@GeneratedValue
	private Integer gasbookingId;
	private LocalDate bookingDate;
	@NotNull
	private Boolean status;
	@NotNull
	private Float bill;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name="customer_gasbooking")
	private Customer customer;

	public GasBooking() {
		super();
	}

	public GasBooking(Integer gasbookingId, LocalDate bookingDate, Boolean status, Float bill, Customer customer) {
		super();
		this.gasbookingId = gasbookingId;
		this.bookingDate = bookingDate;
		this.status = status;
		this.bill = bill;
		this.customer = customer;
	}

	public Integer getGasbookingId() {
		return gasbookingId;
	}

	public void setGasbookingId(Integer gasbookingId) {
		this.gasbookingId = gasbookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Float getBill() {
		return bill;
	}

	public void setBill(Float bill) {
		this.bill = bill;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
