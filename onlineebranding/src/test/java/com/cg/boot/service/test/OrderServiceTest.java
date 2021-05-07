package com.cg.boot.service.test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entities.Address;
import com.cg.entities.Customer;
import com.cg.entities.Order;
import com.cg.repo.Orderrepository;
import com.cg.services.OrderService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class OrderServiceTest {
	
	

		@Autowired
		OrderService orderService;

		@MockBean
		Orderrepository orderRepo;
		
		@Test
		public void testAddOrder()
		{
			Order order = new Order();
			order.setOrderDate(LocalDate.of(2020, 1, 8));
			order.setOrderStatus("Pending");
			Customer cust = new Customer();
			cust.setCustomerId(1006);
			Address add = new Address();
			add.setAddressId(4003);
			order.setCustomerOrder(cust);
			order.setAddressOrder(add);
			Mockito.when(orderRepo.save(order)).thenReturn(order);
			assertThat(orderService.addOrder(order)).isEqualTo(order);
		}
		
		@Test
		public void testUpdateOrder()
		{
			Order order = new Order();
			order.setOrderDate(LocalDate.of(2020, 1, 8));
			order.setOrderStatus("Pending");
			Customer cust = new Customer();
			cust.setCustomerId(1006);
			Address add = new Address();
			add.setAddressId(4003);
			order.setCustomerOrder(cust);
			order.setAddressOrder(add);
			Mockito.when(orderRepo.save(order)).thenReturn(order);
			assertThat(orderService.addOrder(order)).isEqualTo(order);
			Mockito.when(orderRepo.findById(order.getOrderId())).thenReturn(Optional.of(order));
			order.setOrderStatus("Delivered");
			Mockito.when(orderRepo.save(order)).thenReturn(order);
			assertThat(orderService.updateOrder(order)).isEqualTo(order);
		}
		
		@Test 
		public void testRemoveOrder()
		{
			Order order = new Order();
			order.setOrderDate(LocalDate.of(2020, 1, 8));
			order.setOrderStatus("Pending");
			Customer cust = new Customer();
			cust.setCustomerId(1006);
			Address add = new Address();
			add.setAddressId(4003);
			order.setCustomerOrder(cust);
			order.setAddressOrder(add);
			Mockito.when(orderRepo.findById(order.getOrderId())).thenReturn(Optional.of(order));
		    Mockito.when(orderRepo.existsById(order.getOrderId())).thenReturn(false);
		    assertFalse(orderRepo.existsById(order.getOrderId()));
		}
		
						@Test
		public void testOrderById()
		{
			Order order = new Order();
			order.setOrderDate(LocalDate.of(2020, 1, 8));
			order.setOrderStatus("Pending");
			Customer cust = new Customer();
			cust.setCustomerId(1006);
			Address add = new Address();
			add.setAddressId(4003);
			order.setCustomerOrder(cust);
			order.setAddressOrder(add);
			Mockito.when(orderRepo.findById(order.getOrderId())).thenReturn(Optional.of(order));
			assertThat(orderService.viewAllOrderById(order.getOrderId())).isEqualTo(order);
		}
		
			
}
