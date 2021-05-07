package com.cg.boot.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entities.Customer;
import com.cg.exceptions.CustomerNotFoundException;
import com.cg.repo.CustomerRepository;
import com.cg.services.CustomerService;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	CustomerService customerService;
	
	@MockBean
	CustomerRepository customerRepo;
	
	
	@Test
	public void testAddCustomer()
	{
		Customer cust = new Customer();
		cust.setFirstName("Pampari");
		cust.setLastName("Narender");
		cust.setMobileNumber("5878455448");
		cust.setAddress("Hyderabad");
		cust.setEmail("abc@g.com");
		
		Mockito.when(customerRepo.save(cust)).thenReturn(cust);
		assertThat(customerService.addCustomer(cust)).isEqualTo(cust);
	}
	
	@Test
	public void testDeleteCustomer()
	{
		Customer cust = new Customer();
		cust.setFirstName("Pampari");
		cust.setLastName("Narender");
		cust.setMobileNumber("5878455448");
		cust.setAddress("Hyderabad");
		cust.setEmail("abc@g.com");
		Mockito.when(customerRepo.findById(1)).thenReturn(Optional.of(cust));
	    Mockito.when(customerRepo.existsById(cust.getCustomerId())).thenReturn(false);
	   assertFalse(customerRepo.existsById(cust.getCustomerId()));
	}
	
	@Test
	public void testUpdateCustomer()
	{
		Customer cust = new Customer();
		cust.setFirstName("Pampari");
		cust.setLastName("Narender");
		cust.setMobileNumber("5878455448");
		cust.setAddress("Hyderabad");
		cust.setEmail("abc@g.com");
		Mockito.when(customerRepo.findById(cust.getCustomerId())).thenReturn(Optional.of(cust));
		
		cust.setEmail("martin.s2000@gmail.com");
		Mockito.when(customerRepo.save(cust)).thenReturn(cust);
		
		assertThat(customerService.updateCustomer(cust)).isEqualTo(cust);
		
	}
	
	@Test
	public void testViewAllCustomer()
	{
		List<Customer> cust = new ArrayList<>();
		Mockito.when(customerRepo.findAll()).thenReturn(cust);
		Exception ex = assertThrows(CustomerNotFoundException.class, ()-> customerService.viewAllCustomer());
		assertEquals("No Customer Found", ex.getMessage());
		
	}
	
	@Test
	public void testViewAllByLocation()
	{
		Customer cust1 = new Customer();
		cust1.setFirstName("Nilanjan");
		cust1.setLastName("Mukherjee");
		cust1.setMobileNumber("90385857");
		cust1.setAddress("Kolkata");
		cust1.setEmail("xyz@g.com");
		
		Customer cust2 = new Customer();
		cust2.setFirstName("Ramesh");
		cust2.setLastName("Babu");
		cust2.setMobileNumber("70385857");
		cust2.setAddress("Mumbai");
		cust2.setEmail("abz@g.com");
		
		List<Customer> cust = new ArrayList<>();
		cust.add(cust1); cust.add(cust2);
		Mockito.when(customerRepo.viewAllCustomer("Kolkata")).thenReturn(cust);
		assertThat(customerService.ViewAllCustomers("Kolkata")).isEqualTo(cust);
	}
	

}
