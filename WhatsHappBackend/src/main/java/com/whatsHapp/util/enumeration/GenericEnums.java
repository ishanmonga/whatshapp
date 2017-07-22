package com.whatsHapp.util.enumeration;

public class GenericEnums {

	
	public enum EventType {
		 PAID(1), FREE(2);
		 
		 private int code;
		 
		 private EventType(int c) {
		   code = c;
		 }
		 
		 public int getCode() {
		   return code;
		 }

	}
	


}
