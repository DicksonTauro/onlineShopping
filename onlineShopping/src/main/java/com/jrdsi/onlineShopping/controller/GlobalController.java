package com.jrdsi.onlineShopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jrdsi.onlineShopping.model.UserModel;
import com.jrdsi.onlineShoppingBackend.dao.UserDAO;
import com.jrdsi.onlineShoppingBackend.dto.Cart;
import com.jrdsi.onlineShoppingBackend.dto.User;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDao;
	
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		
		if(session.getAttribute("userModel")==null) {
			//add User Model
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDao.getByEmail(auth.getName());
			
			
			if(user != null){
				UserModel userModel = new UserModel();
				userModel.setEmail(user.getEmail());
				userModel.setFullName(user.getFirstName()+ " " +user.getLastName());
				userModel.setRole(user.getRole());
				userModel.setId(user.getId());
				
				if(userModel.getRole().equals("USER")){
					//set the cart to user only if user is buyer
					
					userModel.setCart(user.getCart());
				}
				session.setAttribute("userModel", userModel);
			}
			
			
			
		}
		
		
		return (UserModel) session.getAttribute("userModel");
		
		
	}
}
