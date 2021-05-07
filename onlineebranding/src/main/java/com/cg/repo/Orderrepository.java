package com.cg.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entities.Order;
@Repository

public interface Orderrepository extends JpaRepository<Order, Integer> {

	@Query("select o from Order o where o.orderDate=:orderDate")
	public List<Order> viewAllOrderByDate(@Param("orderDate")LocalDate localdate);

	@Query("select o from Order o where o.customerOrder.address=:address")
	public List<Order> viewAllCustomersByLocation(@Param("address")String address);

}
