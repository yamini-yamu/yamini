package com.cg.DAO;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.cg.entity.*;

@Repository("orderDao")
public interface OrderDAO extends JpaRepository<Order, Integer> {
	
}
