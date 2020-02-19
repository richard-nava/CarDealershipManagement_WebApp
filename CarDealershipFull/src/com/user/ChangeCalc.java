package com.user;

import java.util.Scanner;

public class ChangeCalc {
	
	public static double calculateTaxesSingle(double taxIn, double taxTotal) {
		
		
		double bracket37, bracket35, bracket32, bracket24, bracket22, bracket12, bracket10;
		
		if(taxIn < 9700) {
			
			// define amount paid in taxes for this bracket
			taxTotal = taxIn * 0.10;
				
		}
		else if(taxIn < 39475) {
			
			// immediately subtract the previous brackets from the current amount
			bracket10 = 970;
			taxIn = taxIn - 9700;
			
			// how much paid in taxes
			bracket12 = taxIn * 0.12; 
			
			// add previous brackets to the current bracket
			taxTotal = bracket12 + bracket10;
	
		}
		else if(taxIn < 84200) {
			bracket10 = 970;
			bracket12 = 3573;
			
			taxIn -= 9700+29775;
			
			bracket22 = taxIn * 0.22; 
			
			 taxTotal = bracket10 + bracket12 + bracket22;
			
		}
		else if(taxIn < 160725) {
			
			bracket10 = 970;
			bracket12 = 3573;
			bracket22 = 9839.5;
			
			taxIn -= 9700+29775+44725;
			bracket24 = taxIn * 0.24; 
			 taxTotal = bracket10 + bracket12 + bracket22 + bracket24;
					
		}
		else if(taxIn < 204100) {
			bracket10 = 970;
			bracket12 = 3573;
			bracket22 = 9839.5;
			bracket24 = 18366;
			
			taxIn -= 9700+29775+44725+76525;
			bracket32 = taxIn * 0.32;
			
			 taxTotal = bracket10 + bracket12 + bracket22 + bracket24 + bracket32;
			
			//return taxTotal;
			
		}
		else if(taxIn < 510300) {
			bracket10 = 970;
			bracket12 = 3573;
			bracket22 = 9839.5;
			bracket24 = 18366;
			bracket32 = 13880;
			
			taxIn -= 9700+29775+44725+76525+43375;
			bracket35 = taxIn * 0.35;
			
			taxTotal = bracket10 + bracket12 + bracket22 + bracket24 + bracket32 + bracket35;	
			
		}
		else if(taxIn > 510300) {
			bracket10 = 970;
			bracket12 = 3573;
			bracket22 = 9839.5;
			bracket24 = 18366;
			bracket32 = 13880;
			bracket35 = 152174.05;
			
			taxIn -= 9700+29775+44725+76525+43375+434783;
			bracket37 = taxIn * 0.37;
			
			 taxTotal = bracket10 + bracket12 + bracket22 + bracket24 + bracket32 + bracket35 + bracket37;
			
			//return taxTotal;

		}
		return taxTotal;
	
	}

	
	
	
	
	public static void main(String[] args) {
		
		double taxTotal=0;
		Scanner in = new Scanner(System.in);
		System.out.println("Input Total Amount Earned: ");
		double income = in.nextDouble();
		//System.out.println(calculateTaxesSingle(income));
		System.out.println(calculateTaxesSingle(income,taxTotal));
		
	}
	

}


//return taxTotal;
