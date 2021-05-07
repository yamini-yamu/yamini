package com.cg.controller;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.Exceptions.OrderNotFoundException;
import com.cg.entity.Order;
import com.cg.service.OrderService;

import io.swagger.annotations.Api;
@Api(tags= {"Order-controller"})
@RestController
@RequestMapping("/Order")
@Validated
// @Autowired-It injects dependency objects automatically.(setter and constructor)
//@RestController-use to create restful Webservices
//@RequestMapping-used to map HTTP requests to handler methods
//@postMapping-inserting data to the table
public class OrderController {
	private static final Logger Logger = LoggerFactory.getLogger(OrderController.class);
   @Autowired
   
   OrderService orderser;
	 //http://localhost:9109/order/addorder
	@PostMapping("/addorder")
	public List<Order> addorder(Order o){
		Logger.info("in order controller add Order");
		return orderser.addOrder(o);
	}
			@PostMapping("/updateorder")
	public List<Order> updateorder(Order o){
		Logger.info("in order controller update Order");
		return orderser.updateOrder(o);
	}
			@GetMapping("/getOrderById/{orid}")
			public Order getOrderById(@Valid @Max(100) @PathVariable Integer orid) throws OrderNotFoundException {
				Order o = null;
				try {
					Logger.info("or id = " +orid);
					o = orderser.getOrderById(orid);
				}catch(Exception exp) {
					Logger.info("int catch block");
					throw new OrderNotFoundException("enter value btw 1 to 100..");
				}
				return o;
			}
			
		@DeleteMapping("/deleteorder/{orid}")
	public List<Order> deleteorder( @PathVariable Integer orid){
		Logger.info("in order controller delete Order");
		return orderser.deleteOrder(orid);
	}
	
	
	@GetMapping("/findAll")
	public List<Order> getAll(){
		Logger.info("in order controller get all Order");
		return orderser.getAllOrder();
	}
	
		
	
}
