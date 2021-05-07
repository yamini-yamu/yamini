package com.cg.services;

import com.cg.entities.User;

public interface LoginService {
	
public User addUser(User user);
	
	public User removeUser(int userId);
	
	public User validateUser(int  userId);
	
	public User signOut(User user);

}
