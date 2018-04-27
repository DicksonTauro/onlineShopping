package com.jrdsi.onlineShoppingBackend.daoimpl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jrdsi.onlineShoppingBackend.dao.CartLineDAO;
import com.jrdsi.onlineShoppingBackend.dao.ProductDAO;
import com.jrdsi.onlineShoppingBackend.dao.UserDAO;
import com.jrdsi.onlineShoppingBackend.dto.Cart;
import com.jrdsi.onlineShoppingBackend.dto.CartLine;
import com.jrdsi.onlineShoppingBackend.dto.Product;
import com.jrdsi.onlineShoppingBackend.dto.User;

public class CartLineDAOImplTest {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO;
	
	private static ProductDAO productDAO;
	
	private static UserDAO userDAO;
	
	private Product product;
	
	private User user;
	
	private Cart cart;
	
	private CartLine cartLine;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.jrdsi.onlineShoppingBackend");
		context.refresh();
		
		cartLineDAO = context.getBean(CartLineDAO.class);
		
		productDAO = context.getBean(ProductDAO.class);
		
		userDAO = context.getBean(UserDAO.class);
		
		
		
	} 
	
	@Test
	public void testAddnewCartLine(){
		//1.get user
		user = userDAO.getByEmail("mani@gmail.com");
		
		//2 set the cart
		cart = user.getCart();
		
		//3. get the product
		product = productDAO.getProduct(1);
		
		//4 create the new cart line
		CartLine cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount()*cartLine.getBuyingPrice());
		
		cartLine.setActiveInd(true);

		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		assertEquals("failed to add to the cart line",true,cartLineDAO.add(cartLine));
		
		cart.setGrandTotal(cart.getCartLines()+cartLine.getTotal());
		
		cart.setCartLines(cart.getCartLines()+1);
		
		assertEquals("failed to update the cart" , true ,cartLineDAO.updateCart(cart));
	}
	


}
