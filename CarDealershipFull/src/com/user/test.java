package com.user;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class test {
	

	

	public static void main(String[] args) throws ParseException {
		
		System.out.println(toCamelCase("the-stealth-warrior"));
		
		
	}
	
	static String toCamelCase(String s){
	    
		String result = "";
	    
	    for(int i=0;i<s.length();i++){
	      
	      char focus = s.charAt(i);
	    
	      if( i != 0){
	        if(!Character.isLetter(focus)){
	          
	        } else if(Character.isLetter(focus) && !Character.isLetter(s.charAt(i-1))){
	          result += Character.toUpperCase(focus);
	        }else if(Character.isLetter(focus) && Character.isLetter(s.charAt(i-1))){
	          result += Character.toLowerCase(focus);
	        }
	      }else if (i == 0) {
	        if(!Character.isLetter(focus)){
	            
	        }else{
	          result+= focus;
	        }
	      }
	    }
	    return result;
	  
	  }
	

}
