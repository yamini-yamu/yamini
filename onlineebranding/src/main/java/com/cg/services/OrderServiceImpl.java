package com.cg.services;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entities.Order;
import com.cg.exceptions.OrderNotFoundException;
import com.cg.repo.CustomerRepository;
import com.cg.repo.LoginRepository;
import com.cg.repo.Orderrepository;
@Service
@Transactional

public class OrderServiceImpl implements OrderService {
	
	@Autowired(required = true)
	Orderrepository orderRepo;

	@Autowired(required = true)
	private LoginRepository loginRepo;

	@Autowired(required = true)
	private CustomerRepository custRepo;


	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public Order addOrder(Order order) {
		logger.info("Order addOrder()");
		if(order == null)
			throw new OrderNotFoundException("Order Not Found");
		else {
			orderRepo.save(order);
			return order;
		}
	}

	@Override
	public Order updateOrder(Order order) {
		logger.info("Order updateOrder()");
		if(order == null)
			throw new OrderNotFoundException("Order Not Found");
		else {
			orderRepo.save(order);
			return order;
		}
	}

	@Override
	public Order removeOrder(int orderId) {
		logger.info("Order removeOrder()");
		Optional<Order> order = orderRepo.findById(orderId);
		if(order.isPresent())
			throw new OrderNotFoundException("Order Not Found");
		else {
			orderRepo.delete(order.get());
			return order.get();
		}
	}

	
	@Override
	public Order viewAllOrderById(int orderId) {
		logger.info("Order viewAllOrderByUserId()");;
		Optional<Order> list = orderRepo.findById(orderId);

		if(!list.isPresent())
			throw new OrderNotFoundException("Order Not Found");
		else
			return list.get();
	}

}
