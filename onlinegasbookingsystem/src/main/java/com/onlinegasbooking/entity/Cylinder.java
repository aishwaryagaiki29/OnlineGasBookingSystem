package com.onlinegasbooking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cylinder")
public class Cylinder {

	@Id
	@GeneratedValue
	private Integer cylinderTypeId;
	private String cylinderType;//exception
	@Digits(integer=1,fraction = 2)
	private Float weight;
	private Float price;

	@OneToOne
	private SurrenderCylinder surrendercylinder;

	@OneToOne(mappedBy="cylinder")
	@JsonIgnore
	private Customer customer;

	public Cylinder() {
		super();
	}

	public Cylinder(Integer cylinderTypeId, String cylinderType, Float weight, Float price,
			SurrenderCylinder surrendercylinder, Customer customer) {
		super();
		this.cylinderTypeId = cylinderTypeId;
		this.cylinderType = cylinderType;
		this.weight = weight;
		this.price = price;
		this.surrendercylinder = surrendercylinder;
		this.customer = customer;
	}

	public Integer getCylinderTypeId() {
		return cylinderTypeId;
	}

	public void setCylinderTypeId(Integer cylinderTypeId) {
		this.cylinderTypeId = cylinderTypeId;
	}

	public String getCylinderType() {
		return cylinderType;
	}

	public void setCylinderType(String cylinderType) {
		this.cylinderType = cylinderType;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public SurrenderCylinder getSurrendercylinder() {
		return surrendercylinder;
	}

	public void setSurrendercylinder(SurrenderCylinder surrendercylinder) {
		this.surrendercylinder = surrendercylinder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
