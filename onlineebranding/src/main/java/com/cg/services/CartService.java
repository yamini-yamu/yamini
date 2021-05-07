package com.cg.services;

import org.springframework.stereotype.Service;

import com.cg.entities.Cart;

@Service
public interface CartService {
	
	
		public Cart addCart(Cart cart);
		
		public Cart removeCart(int cartId);

		public Cart viewCustomer(int customerId);

}
