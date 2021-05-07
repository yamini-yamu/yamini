/*package com.cg.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.DAO.OrderDAO;
import com.cg.entity.Order;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)

public class TestOrderService {
	@InjectMocks
	OrderServiceImpl service;
	@Mock
		OrderDAO dao;
	@Test
	public void getAllOrderTest()
	{
		List<Order> list = new  ArrayList<Order>();
		{
			Order orOne = new Order(2,"delivered","10/2/21");
			Order orTwo = new Order(2,"delivered","10/2/21");
			Order orThree = new Order(2,"delivered","10/2/21");
			list.add(orOne);
			list.add(orTwo);
			list.add(orThree);
			when(dao.findAll()).thenReturn(list);
			//test
			List<Order> orList =service.getAllOrder();
			assertEquals(3,orList.size());
			verify(dao,times(1)).findAll();
		}
	}
	@Test
	public void testdeleteOrder() {
		Order order = new Order();
		order.setOrid(2);
		Mockito.when(dao.existsById(order.getOrid())).thenReturn(false);
		assertFalse(dao.existsById(order.getOrid()));
	}
	@Test
	public void testOrderById() {
		Order order=new Order(6,"delivered","10/3/21");
		when(dao.findById(6)).thenReturn(Optional.of(order));
		assertEquals(order,service.getOrderById(6));
	}
	
	@Test
	public void updateOrderTest() {
		Order order=new Order(2,"delivered","10/2/21");
		order.setOrid(5);
	assertThat(dao.findById(order.getOrid())).isNotEqualTo(order);
		
	}
	
	
}*/
	
	
			
								
			
			

			
