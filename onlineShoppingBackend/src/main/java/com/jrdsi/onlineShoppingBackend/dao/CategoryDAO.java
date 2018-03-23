package com.jrdsi.onlineShoppingBackend.dao;

import java.util.List;

import com.jrdsi.onlineShoppingBackend.dto.Category;

public interface CategoryDAO {
	
	public Category getCategory(Long id);
	
	public List<Category> getCategories();
	
	public boolean addCategory(Category category);
	
	public boolean updateCategory(Category category);
	
	public boolean removeCategory(Category category);
	

}
