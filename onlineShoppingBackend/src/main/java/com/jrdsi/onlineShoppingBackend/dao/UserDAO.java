package com.jrdsi.onlineShoppingBackend.dao;

import java.util.List;

import com.jrdsi.onlineShoppingBackend.dto.Address;
import com.jrdsi.onlineShoppingBackend.dto.Cart;
import com.jrdsi.onlineShoppingBackend.dto.User;

public interface UserDAO {
	
	public boolean addAddress(Address address);
	
	public boolean addUser(User user);
	
	public User getByEmail(String email);
	
	public Address getBillingAddress(User user);
	
	public List<Address> getShippingAddressList(User user);

}
