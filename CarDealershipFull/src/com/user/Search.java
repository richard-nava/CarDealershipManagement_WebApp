package com.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Search implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Search() {}
	
	public ArrayList<Car> getInventory() {
		
		final String path = "/Users/richardnava/Documents/dealership-files/";

		System.out.println("We are in getInventory");
		//read file
		String content = "";
		try {
			
			File carFile = new File(path + "Car_Lot.txt");
			Scanner reader = new Scanner(carFile);
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				//System.out.println("first " + data);
				content += data; 
			}
	
			reader.close();
		}catch(FileNotFoundException e) {
			
			//System.out.println("error");
			e.printStackTrace();
		}
		//System.out.println("second " + content);
		
		//split file into cars
		String[] eachCar = content.split("--");
		
		ArrayList<Car> lot = new ArrayList<>();
		
		//add cars into ArrayList Lot
		try {
		for(int i=0;i<eachCar.length; i++) {
			
			
			String[] carParams = eachCar[i].split(",");
			//System.out.println(carParams[4].toString());
			//System.out.println(carParams[9].toString());
			
			double newPrice = Double.parseDouble(carParams[4]);
			
			
			int newYear = Integer.parseInt(carParams[5]);
			int newMpg = Integer.parseInt(carParams[6]);
			int newHwy = Integer.parseInt(carParams[7]);
			boolean newUsed = Boolean.parseBoolean(carParams[8]);
			int newMiles = Integer.parseInt(carParams[9]);
			String dateAdded = carParams[10];
			boolean saleStatus = Boolean.parseBoolean(carParams[11]);
			
			Car newCar = new Car(carParams[0],carParams[1],carParams[2],
							carParams[3],newPrice,newYear,newMpg,
							newHwy,newUsed,newMiles,dateAdded,saleStatus);
			
			lot.add(newCar);
			
			
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			
			
		}
		
		for(Car var:lot) {
			
			System.out.println(var.toString());
		}
		
		return lot;
	}
	
	
	public ArrayList<Car> searchBy(String searchParam, String keyVal, ArrayList<Car> lot) {
		
		System.out.println("We are in search by method");
		ArrayList<Car> newLot = new ArrayList<>();
		ArrayList<Car> toRemove = new ArrayList<>();
				
		
		try {
		switch(keyVal) {
		
		case "model":
			for(Car var:lot) {
				
				if( !searchParam.equalsIgnoreCase(var.getModel())){
							
					toRemove.add(var);
		
				}
				
			}
			
			for(Car var:lot) {
				
				newLot.add(var);
				System.out.println(var.toString());
			}
			
			newLot.removeAll(toRemove);
			break;
		case "make":
			for(Car var:lot) {
				
				if(!searchParam.equalsIgnoreCase(var.getMake())){
							
					toRemove.add(var);
		
				}
				
			}
			
			for(Car var:lot) {
				
				newLot.add(var);
				System.out.println(var.toString());
			}
			
			newLot.removeAll(toRemove);
			break;
		case "color":
			for(Car var:lot) {
				
				if(!searchParam.equalsIgnoreCase(var.getColor())){
							
					toRemove.add(var);
		
				}
				
			}
			
			for(Car var:lot) {
				
				newLot.add(var);
				System.out.println(var.toString());
			}
			
			newLot.removeAll(toRemove);
			break;
		case "year":
			
			int paramYear = Integer.parseInt(searchParam);
			
			for(Car var:lot) {
				
				if(paramYear != var.getYear()){
							
					toRemove.add(var);
		
				}
				
			}
			
			for(Car var:lot) {
				
				newLot.add(var);
				System.out.println(var.toString());
			}
			
			newLot.removeAll(toRemove);
			
			
			
			break;
		default:
			for(Car var:lot) {
				
				newLot.add(var);
				
			}
			break;
		
		}
		
		for(Car var: newLot) {
			
			if(var.isForSale() == false) {
				
				toRemove.add(var);
			}
			
		}
		}catch(IndexOutOfBoundsException e) {
			
			
		}
		
		newLot.removeAll(toRemove);
		return newLot;
		
		
	
		
		
	}
 
	public ArrayList<Car> carDescription(String vin, ArrayList<Car> lot) {
		
		ArrayList<Car> newLot = new ArrayList<>();
 		
		
		for(Car var : lot) {
			
			if(var.getVin().equals(vin)) {
				
				newLot.add(var);
			}
			
		}
		
		return newLot;
		
	}
	
	public ArrayList<Car> getSoldInventory(){
		final String path = "/Users/richardnava/Documents/dealership-files/";

		System.out.println("We are in getSoldInventory");
		//read file
		String content = "";
		try {
			
			File carFile = new File(path + "Car_Transactions.txt");
			Scanner reader = new Scanner(carFile);
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				//System.out.println("first " + data);
				content += data; 
			}
	
			reader.close();
		}catch(FileNotFoundException e) {
			
			//System.out.println("error");
			e.printStackTrace();
		}
		//System.out.println("second " + content);
		
		//split file into cars
		String[] eachCar = content.split("--");
		
		ArrayList<Car> lot = new ArrayList<>();
		
		//add cars into ArrayList Lot
		
		try {
		for(int i=0;i<eachCar.length; i++) {
			
			
			String[] carParams = eachCar[i].split(",");
		
			for(int j=0;j<carParams.length;j++) {
				
				System.out.println(carParams[j].toString());
			}
			
			/* double newPrice = Double.parseDouble(carParams[4]);
			
			
			int newYear = Integer.parseInt(carParams[5]);
			int newMpg = Integer.parseInt(carParams[6]);
			int newHwy = Integer.parseInt(carParams[7]);
			boolean newUsed = Boolean.parseBoolean(carParams[8]);
			int newMiles = Integer.parseInt(carParams[9]);
			int daysInLot = Integer.parseInt(carParams[10]);
			boolean saleStatus = Boolean.parseBoolean(carParams[11]);
			
			Car newCar = new Car(carParams[0],carParams[1],carParams[2],
							carParams[3],newPrice,newYear,newMpg,
							newHwy,newUsed,newMiles,daysInLot,saleStatus);
							
							*/
			
			// make model vin year color price datepurch buyer
			
			String make = carParams[0];
			String model = carParams[1];
			String vin = carParams[2];
			int year = Integer.parseInt(carParams[3]);
			String color = carParams[4];
			double price = Double.parseDouble(carParams[5]);
			String datePurchased = carParams[6];
			
			String[] buyerParams = carParams[7].split(" ");
			String fname = buyerParams[0].toString() ;
			String lname = buyerParams[1].toString() ;
			String email = buyerParams[2].toString() ;
			String phone = buyerParams[3].toString() ;
			String street = buyerParams[4].toString() + buyerParams[5].toString() + buyerParams[6].toString();
			String state = buyerParams[7].toString();
			String city = buyerParams[8].toString();
			String zip = buyerParams[9].toString();
			
			BuyerAddress address = new BuyerAddress(street, city, state, zip);
			Buyer buyer = new Buyer(fname, lname, email, phone, address);
			
			Car newCar = new Car(make,model,vin,year,color,price,datePurchased,buyer);
			
			
			lot.add(newCar);
			
		}
		
		for(Car var:lot) {
			
			System.out.println(var.toString());
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}
		return lot;
	}
	
		
		
	
}
