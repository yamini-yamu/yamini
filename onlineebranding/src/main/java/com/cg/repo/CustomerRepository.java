package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entities.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select c from Customer c where c.address=:address")
	public List<Customer> viewAllCustomer(@Param("address")String address);

}
