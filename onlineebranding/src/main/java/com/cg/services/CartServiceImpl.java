package com.cg.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entities.Cart;
import com.cg.exceptions.CartNotFoundException;
import com.cg.repo.CartRepository;
import com.cg.repo.ProductRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	@Autowired(required = true)
	CartRepository cartRepo;
	@Autowired(required = true) 
	ProductRepository productRepo;

	Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

	
	@Override
	public Cart addCart(Cart cart) {
		logger.info("Cart addCart()");

		if(cart == null)
			throw new CartNotFoundException("Cart Not Found");
		else {
			cartRepo.save(cart);
			return cart;
		}

	}

	@Override
	public Cart removeCart(int cartId)
	{
		logger.info("Cart removeCart()");
		Cart cart = cartRepo.findById(cartId).get();
		if(cart == null)
			throw new CartNotFoundException("Cart Not Found");
		else {
			cartRepo.delete(cart);
			return cart;
		}
	}

	@Override
	public Cart viewCustomer(int customerId)
	{
		logger.info("Cart viewCustomer()");
		Cart cart = cartRepo.viewCartByCustomerId(customerId);
		if(cart == null)
			throw new CartNotFoundException("Cart Not Found");
		else
			return cart;
	}


}
