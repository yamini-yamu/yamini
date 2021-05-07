package com.cg.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.DAO.OrderDAO;
import com.cg.controller.OrderController;
import com.cg.entity.Order;

@Service("order")
public class OrderServiceImpl implements OrderService{
	private static final Logger Logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderDAO orderdao;
	
	OrderServiceImpl(){	
	}
	
	
	@Override
	public List<Order> addOrder(Order o) {
		Logger.info("inserting an Order");
		orderdao.saveAndFlush(o);
		return orderdao.findAll();
	}

	@Override
	public  List<Order>updateOrder(Order o) {
		Logger.info("updating and order");
		orderdao.saveAndFlush(o);
		return orderdao.findAll();
	}
	@Override
	public Order getOrderById(Integer orid) {
		Logger.info("get Order by id");
		Optional<Order> o =orderdao.findById(orid);
		return o.get();
	}
	
    public List<Order> deleteOrder(Integer orid) {
		Logger.info("delete the order by id");
		orderdao.deleteById(orid);
		return orderdao.findAll();
	}


	@Override
	public List<Order> getAllOrder() {
		Logger.info("get all Order");
		return orderdao.findAll();
	}

}
