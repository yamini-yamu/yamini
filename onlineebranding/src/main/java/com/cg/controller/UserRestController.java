package com.cg.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.User;
import com.cg.services.LoginService;


@RestController
@RequestMapping("/onlineshopping")

public class UserRestController {
	
	@Autowired(required = true)
	LoginService loginService;

	Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@PostMapping("/user")
	public User adduser(@RequestBody User user) {
		
		logger.info("User addUser()");
		
		return loginService.addUser(user);
	}

	@GetMapping("/user/{userId}")
	public User validateuser(@PathVariable("userId") int userId) {
		
		logger.info("User removeUser()");
		
		return loginService.validateUser(userId);
	}

	@DeleteMapping("/user/{userId}")
	public User removeUser(@PathVariable("userId") int userId) {
		

		logger.info("User validateUser()");
		
		return loginService.removeUser(userId);
	}

}
