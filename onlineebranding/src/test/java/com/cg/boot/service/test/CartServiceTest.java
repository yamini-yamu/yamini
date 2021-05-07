package com.cg.boot.service.test;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entities.Cart;
import com.cg.entities.Customer;
import com.cg.repo.CartRepository;
import com.cg.services.CartService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	CartService cartService;
	
	@MockBean
	CartRepository cartRepo;
	
	@Test
	public void testAddCart()
	{
		Cart cart = new Cart();
		cart.setCartId(6001);
		Customer cust = new Customer();
		cust.setCustomerId(1000);
		cart.setCustomerCart(cust);
		Mockito.when(cartRepo.save(cart)).thenReturn(cart);
		assertThat(cartService.addCart(cart)).isEqualTo(cart);
	}
	@Test
	public void testRemoveCart()
	{
		Cart cart = new Cart();
		cart.setCartId(6001);
		Customer cust = new Customer();
		cust.setCustomerId(1000);
		cart.setCustomerCart(cust);
		Mockito.when(cartRepo.findById(cart.getCartId())).thenReturn(Optional.of(cart));
	    Mockito.when(cartRepo.existsById(cart.getCartId())).thenReturn(false);
	   assertFalse(cartRepo.existsById(cart.getCartId()));
	}
	@Test
	public void testViewCart()
	{
		Cart cart = new Cart();
		cart.setCartId(6001);
		Customer cust = new Customer();
		cust.setCustomerId(1000);
		cart.setCustomerCart(cust);
		Mockito.when(cartRepo.viewCartByCustomerId(cart.getCustomerCart().getCustomerId())).thenReturn(cart);
		assertThat(cartService.viewCustomer(cart.getCustomerCart().getCustomerId())).isEqualTo(cart);
	}

}
