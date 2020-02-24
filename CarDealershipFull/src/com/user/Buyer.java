package com.user;

import java.io.Serializable;

public class Buyer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4135598089654228642L;
	private String firstName, lastName, wholeName, email, phoneNumber;
	BuyerAddress address;
	private int age; 
	private Car carPurchased = new Car();
	
	public Buyer () {
		
	}
	
	public Buyer (String firstName, String lastName, String email, String phoneNumber, BuyerAddress address) {
		
		this.address = address; 
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email; 
		this.phoneNumber = phoneNumber;
			
	}


	public BuyerAddress getAddress() {
		return address;
	}
	
	public void setAddress(BuyerAddress address){
		
		this.address = address; 
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getWholeName() {
		return wholeName;
	}
	public void setWholeName(String wholeName) {
		this.wholeName = wholeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Car getCarPurchased() {
		return carPurchased;
	}
	public void setCarPurchased(Car carPurchased) {
		this.carPurchased = carPurchased;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " " + email + " "
				+ phoneNumber + " " + address ;
	} 
	
	
}
