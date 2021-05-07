package com.cg.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Cart;
import com.cg.repo.CartRepository;
import com.cg.services.CartService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/onlineshopping")
public class CartRestController {
	
	@Autowired(required = true)
	CartService cartService;
	
	@Autowired(required = true)
	CartRepository cartRepo;

	Logger logger = LoggerFactory.getLogger(CartRestController.class);


	@PostMapping("/cart")
	
	public Cart addCart(@RequestBody Cart cart)
	{
		logger.info("Cart addCart()");
		return cartService.addCart(cart);
	}

	@DeleteMapping("/cartId{cartId}")
	public Cart removeCart(@PathVariable("cartId") int cartId)
	{
		logger.info("Cart removeCart()");
		return cartService.removeCart(cartId);
	}

	@GetMapping("/cart/{customerId}")
	public Cart viewAllCustomer(@PathVariable("customerId")int customerId)
	{
		logger.info("Cart viewCustomer()");
		return cartService.viewCustomer(customerId);
	}

}
