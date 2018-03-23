package com.jrdsi.onlineShoppingBackend.dao;

import java.util.List;

import com.jrdsi.onlineShoppingBackend.dto.Product;

public interface ProductDAO {
	
	public Product getProduct(Integer id);
		
	public List<Product> getProductList();
	
	public boolean addProduct(Product product);
	
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(Product product);
	
	
	
	public List<Product> getActiveProducts();
	
	public List<Product> getActiveProductsByCategory(Integer categoryId);
	
	public List<Product> getLatestActiveProducts(Integer count);
	
	
		
}
