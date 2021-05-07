package com.cg.services;

import java.util.List;

import com.cg.entities.Product;

public interface ProductService {
	
public List<Product> viewAllProducts();
	
	public Product addProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public Product viewProduct(int id);
	
	public List<Product> viewProductsByCategory(int catId); 
	
	public Product removeProduct(int productId);

}
