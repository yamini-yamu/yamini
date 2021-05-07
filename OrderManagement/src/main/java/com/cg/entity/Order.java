package com.cg.entity;
 import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//@Table specifies the name of the database table
//@Id specifies the primary key of an entity
//@Entity defines that a  class can be mapped to a table
//@NotBlank-checks  whether  the value is notnull nor empty

@Entity
@Table(name = "orders_table")

public class Order {
	@Id
	private  int orid;
	@NotBlank(message = "orderStatus name cannot be Blank")
	private  String orderStatus;
	@NotBlank(message="orderDate cannot be Blank")
	private  String orderDate;
   public Order() {
    }
   
  public Order(int orid, @NotBlank(message = "oderStatus name cannot be Blank") String orderStatus,
		@NotBlank(message = "orderDate cannot be Blank") String orderDate) {
	super();
	this.orid = orid;
	this.orderStatus = orderStatus;
	this.orderDate = orderDate;
}



public int getOrid() {
	return orid;
}
public void setOrid(int orid) {
	this.orid = orid;
}
public String getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}
public String getOrderDate() {
	return orderDate;
}
public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
}

@Override
public String toString() {
	return "Order [orid=" + orid + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + "]";
}
}
   
   