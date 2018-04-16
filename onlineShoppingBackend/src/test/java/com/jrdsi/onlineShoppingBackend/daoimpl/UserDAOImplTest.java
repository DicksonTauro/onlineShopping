/*package com.jrdsi.onlineShoppingBackend.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jrdsi.onlineShoppingBackend.dao.UserDAO;
import com.jrdsi.onlineShoppingBackend.dto.Address;
import com.jrdsi.onlineShoppingBackend.dto.Cart;
import com.jrdsi.onlineShoppingBackend.dto.User;

public class UserDAOImplTest {

	private static AnnotationConfigApplicationContext context;

	private static UserDAO userDAO;

	private User user;

	private Cart cart;

	private Address address;
	
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jrdsi.onlineShoppingBackend");
		context.refresh();
		
		userDAO = context.getBean(UserDAO.class);
	}
	
	@Test
	public void testAddUser(){
	    user = new User();
		user.setFirstName("Mahesh");
		user.setLastName("Babu");
		user.setEmail("mahesh@babu.com");
		user.setContactNumber("5678452311");
		user.setPassword("1234");
		user.setRole("USER");
		
		
		assertEquals("Should persist the user details", true , userDAO.addUser(user));
		
		address = new Address();
		
		address.setAddressLineOne("Found street");
		address.setAddressLineTwo("Found Door");
		address.setCity("Vizak");
		address.setCountry("India");
		address.setState("KA");
		address.setPostalCode("573103");
		address.setBilling(true);
		address.setUserId(user.getId());
		
		assertEquals("Should add the address",true,userDAO.addAddress(address));
		
		
		if(user.getRole().equals("USER")){
			cart = new Cart();
			cart.setUser(user);
		    assertEquals("should add cart to user", true,userDAO.addCart(cart));
		}
	}
	
	@Test
	public void testAddUser(){
	    user = new User();
		user.setFirstName("Mahesh");
		user.setLastName("Babu");
		user.setEmail("mahesh@babu.com");
		user.setContactNumber("5678452311");
		user.setPassword("1234");
		user.setRole("USER");
		
		if(user.getRole().equals("USER")){
			cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		assertEquals("Should persist the user details", true , userDAO.addUser(user));
		}
		
	}
	
	@Test
	public void testGetUser(){
		user = userDAO.getByEmail("mahesh@babu.com");
		assertNotNull(user);
		cart = user.getCart();
		
		cart.setCartLines(12);
		cart.setGrandTotal(23.22);
		
		assertEquals("Should update the cart",true,userDAO.updateCart(cart));
	}

	@Test
	public void testAddAddress(){
		
		 user = new User();
			user.setFirstName("Mahesh");
			user.setLastName("Babu");
			user.setEmail("mahesh@babu.com");
			user.setContactNumber("5678452311");
			user.setPassword("1234");
			user.setRole("USER");
			
			assertEquals("Should persist the user details", true , userDAO.addUser(user));
		
			
			address = new Address();
			
			address.setAddressLineOne("Found Billing street");
			address.setAddressLineTwo("Found Billing Door");
			address.setCity("Vizak");
			address.setCountry("India");
			address.setState("KA");
			address.setPostalCode("573103");
			address.setBilling(true);
			address.setUser(user);
			
			assertEquals("Should persist the user Billing Address address", true , userDAO.addAddress(address));
			
            address = new Address();
			
			address.setAddressLineOne("Found setShipping street");
			address.setAddressLineTwo("Found setShipping Door");
			address.setCity("Vizak");
			address.setCountry("India");
			address.setState("KA");
			address.setPostalCode("573103");
			address.setShipping(true);
			address.setUser(user);
			assertEquals("Should persist the Shipping Address details", true , userDAO.addAddress(address));
	}
	
	
	@Test
	public void testAddAddress(){
		
		user = userDAO.getByEmail("mahesh@babu.com");
		
		address = new Address();
		 
		address.setAddressLineOne("Found setShipping street");
		address.setAddressLineTwo("Found setShipping Door");
		address.setCity("BENGALURU");
		address.setCountry("India");
		address.setState("KA");
		address.setPostalCode("573103");
		address.setShipping(true);
		address.setUser(user);
		assertEquals("Should persist the Shipping Address details", true , userDAO.addAddress(address));
	}
	
	
	@Test
	public void testAddAddress(){
		user = userDAO.getByEmail("mahesh@babu.com");
		
		assertEquals("Shipping Address Size must be 2", 2 , userDAO.getShippingAddressList(user).size());
		assertEquals("Shipping Address Size must be 2", "Vizak", userDAO.getBillingAddress(user).getCity());
	}
}
*/