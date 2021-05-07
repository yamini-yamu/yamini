package com.cg.services;

import java.time.LocalDate;
import java.util.List;

import com.cg.entities.Order;

public interface OrderService {
	
public Order addOrder(Order order);
	
	public Order updateOrder(Order order);
	
	public Order removeOrder(int orderId);
	
	public Order viewAllOrderById(int orderId);

}
