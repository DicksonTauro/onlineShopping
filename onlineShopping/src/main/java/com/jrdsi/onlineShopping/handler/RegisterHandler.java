package com.jrdsi.onlineShopping.handler;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.jrdsi.onlineShopping.model.RegisterModel;
import com.jrdsi.onlineShoppingBackend.dao.UserDAO;
import com.jrdsi.onlineShoppingBackend.dto.Address;
import com.jrdsi.onlineShoppingBackend.dto.Cart;
import com.jrdsi.onlineShoppingBackend.dto.User;

@Component
public class RegisterHandler implements Serializable {
	
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel model,User user) {
		model.setUser(user);
	}
	
	public void addUserAddress(RegisterModel model,Address billing) {
		model.setAddress(billing);
	}
	
	public String saveAll(RegisterModel model){
		
		User user = model.getUser();
		
		if(user.getRole().equals("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		userDAO.addUser(user);
		
		Address address = model.getAddress();
		address.setUser(user.getId());
		address.setBilling(true);
		
		userDAO.addAddress(address);
		return "success";
	}
	
	public String validateUser(User user, MessageContext errors){
		String transitionValue = "success";
		
		//check if password matches confirm password
		
		if(!(user.getPassword().equals(user.getConfirmPassword()))){
			errors.addMessage(new MessageBuilder()
					              .error()
					              .source("confirmPassword")
					              .defaultText("Password does not match the confirm password")
					              .build());
			
			transitionValue = "failure";
		}
		
		//check uniqueness of the email address
		
		
		if(userDAO.getByEmail(user.getEmail()) != null){
			  
			errors.addMessage(new MessageBuilder()
					          .error()
					          .source("email")
					          .defaultText("Email id Already used")
					          .build());
			transitionValue = "failure";
		}
		
		
		return transitionValue;
	}

}
