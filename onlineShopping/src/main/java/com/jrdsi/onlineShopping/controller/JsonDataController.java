package com.jrdsi.onlineShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jrdsi.onlineShoppingBackend.dao.ProductDAO;
import com.jrdsi.onlineShoppingBackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productDAO.getActiveProducts();
	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin(){
		return productDAO.getProductList();
	}
	
	
	@RequestMapping("/category/{categoryId}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable Integer categoryId){
		return productDAO.getActiveProductsByCategory(categoryId);
	}
}
