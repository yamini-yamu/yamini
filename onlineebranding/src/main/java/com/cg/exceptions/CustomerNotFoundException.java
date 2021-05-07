package com.cg.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	
String msg;
	
	public CustomerNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
		
	}
	

}
