package com.cg.exceptions;

public class UserNotFoundException extends RuntimeException {
	

	String msg;
	public UserNotFoundException(String msg)
	{
		this.msg=msg;
	}
	
    @Override
    public String getMessage()
    {
    	return msg;
    }

}
