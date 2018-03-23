/*package com.jrdsi.onlineShoppingBackend.daoimpl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jrdsi.onlineShoppingBackend.dao.ProductDAO;
import com.jrdsi.onlineShoppingBackend.dto.Product;

public class ProductDAOImplTest {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.jrdsi.onlineShoppingBackend");
		
		context.refresh();
		
		productDAO = context.getBean(ProductDAOImpl.class);
		
	}
	
	@Test
	public void testCRUD(){
		
		product = new Product();
		
		
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is description for oppo mobiles");
		product.setUnitPrice(Double.valueOf(12000));
		product.setActiveInd(Boolean.TRUE);
		product.setCategoryId(Integer.valueOf(2));
		product.setSupplierId(Integer.valueOf(2));
		
		
		//assertEquals("It should add product", true, productDAO.addProduct(product));
		
		product = productDAO.getProduct(Integer.valueOf(8));
		
		assertEquals("It should get product", Integer.valueOf(8), product.getId());
		
		product.setViews(Integer.valueOf(45));
		product.setPurchases(Integer.valueOf(12));
		product.setQuantity(Integer.valueOf(32));
		
		assertEquals("It should update product", true, productDAO.updateProduct(product));
		
		assertEquals("It should update product", true, productDAO.deleteProduct(product));
	}
	
	@Test
	public void testActiveProducts(){
		
		List<Product> products = productDAO.getActiveProducts();
		
		for(Product p : products){
			assertEquals("value active indicators Should be true",true,p.getActiveInd());
		}
		
	}
	
	@Test
	public void testActiveProductsByCategory(){
		
		List<Product> products = productDAO.getActiveProductsByCategory(Integer.valueOf(2));
		
		for(Product p : products){
			assertEquals("It should fetch only category 2",Integer.valueOf(2),p.getCategoryId());
		}
		
	}
	
	@Test
	public void testActiveLatestProductsByCategory(){
		
		List<Product> products = productDAO.getLatestActiveProducts(4);
	assertEquals("It should fetch latest 4 results",4,products.size());
		
		
	}
	
	
	
	
}
*/