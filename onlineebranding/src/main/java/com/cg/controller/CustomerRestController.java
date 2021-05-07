package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Customer;
import com.cg.services.CustomerService;

@RestController
@RequestMapping("/onlineshopping")

public class CustomerRestController {
	
	
	@Autowired(required = true)
	private CustomerService customerService;

	Logger logger = LoggerFactory.getLogger(CustomerRestController.class);

	@PostMapping("/customer")
	public Customer addCustomer(@Valid @RequestBody Customer cust){
		logger.info("Customer addCustomer()");
		Customer customers = customerService.addCustomer(cust);
		return customers;
	}	


	@GetMapping("/customer")
	public List<Customer> viewAllCustomer()
	{
		logger.info("Customer viewAllCustomer()");
		return customerService.viewAllCustomer();
	}

	@PutMapping("/customer")
	public Customer updateCustomer(@Valid @RequestBody Customer cust) {
		logger.info("Customer updateCustomer()");
		Customer customers = customerService.updateCustomer(cust);
		return customers;

	}


	@GetMapping("/customer/{customerId}")
	public Customer viewCustomerById(@PathVariable("customerId")int custId)
	{
		logger.info("Customer viewCustomerById()");
		return customerService.viewCustomer(custId);
	}
	/*
	@GetMapping("/customer/{customerAddress}")
    public List<Customer> viewCustomerByAddress(@PathVariable("customerAddress")String custAddress)
    {
    logger.info("Customer viewCustomerByLocation()");
        return customerService.ViewAllCustomers(custAddress);
    }
	 */
	@DeleteMapping("/customer/{custId}")
	public Customer removeCustomer(@PathVariable("custId")int custId) {

		logger.info("Customer removeCustomer()");
		return customerService.removeCustomer(custId);

	}

}
