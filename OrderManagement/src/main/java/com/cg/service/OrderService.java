package com.cg.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.entity.Order;
    @Service
	public interface OrderService {
	   public List<Order> addOrder(Order o);
		public List<Order> updateOrder(Order o);
		public List<Order> deleteOrder(Integer orid);
		public List<Order> getAllOrder();
		public Order getOrderById(Integer orid);
		
	}


