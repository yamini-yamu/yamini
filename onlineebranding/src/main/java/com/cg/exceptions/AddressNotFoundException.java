package com.cg.exceptions;

public class AddressNotFoundException extends RuntimeException {
String msg;
	
	public AddressNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
		
	}

}
