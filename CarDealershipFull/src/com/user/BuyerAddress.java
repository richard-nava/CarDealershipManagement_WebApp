package com.user;

public class BuyerAddress {
	
	private String street, city, state, zip;
	
	public BuyerAddress(String street, String state, String city, String zip) {
		
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public BuyerAddress() {}

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return street +" "+ city +" "+ state +" "+ zip;
	}
	
	

}
