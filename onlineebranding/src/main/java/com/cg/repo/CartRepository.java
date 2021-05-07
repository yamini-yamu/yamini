package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	@Query("select c from Cart c where c.customerCart.customerId=:customerId")
	public Cart viewCartByCustomerId(@Param("customerId")int customerId);

}
