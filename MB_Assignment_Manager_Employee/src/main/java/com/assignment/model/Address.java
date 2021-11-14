package com.assignment.model;

import javax.persistence.Entity;

/**
 * @author Rajeev.Loghade Entity class : Address
 */
@Entity(name = "Address")
public class Address {

	private String state;
	private String city;
	private String street;
	private String pinCode;

	public Address() {
		super();
	}

	public Address(String state, String city, String street, String pinCode) {
		super();
		this.state = state;
		this.city = city;
		this.street = street;
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", street=" + street + ", pinCode=" + pinCode + "]";
	}

}
