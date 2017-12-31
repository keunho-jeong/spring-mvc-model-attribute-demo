package com.yandj.springdemo.domain;

import java.io.Serializable;

public class Address implements Serializable {
	
	private static final long serialVersionUID = 3070871862329263294L;
	private String street;
	private String city;
	private String zipCode;
	
	public Address() {
		super();
	}
	public Address(String city, String zipCode) {
		super();
		this.city = city;
		this.zipCode = zipCode;
	}
	public Address(String street, String city, String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zipCode=" + zipCode + "]";
	}
	
}
