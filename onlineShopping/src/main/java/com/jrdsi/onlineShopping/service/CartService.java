package com.jrdsi.onlineShopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdsi.onlineShopping.model.UserModel;
import com.jrdsi.onlineShoppingBackend.dao.CartLineDAO;
import com.jrdsi.onlineShoppingBackend.dao.ProductDAO;
import com.jrdsi.onlineShoppingBackend.dto.Cart;
import com.jrdsi.onlineShoppingBackend.dto.CartLine;
import com.jrdsi.onlineShoppingBackend.dto.Product;

@Service
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;
	
	
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	public List<CartLine> getCartLines() {
		Cart cart = getCart();
		return cartLineDAO.list(cart.getId());
	}

	public String manageCartLine(int cartLineId,int count) {
		
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}
		else {
			
			Product product = cartLine.getProduct();	
			
			double oldTotal = cartLine.getTotal();
			
			if(product.getQuantity() < count) {
				return "result=unavailale";
			}
			
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice()*count);
			
			cartLineDAO.update(cartLine);
			
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal()- oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			return "result=updated";
		}
 	}

	public String deleteCartLine(int cartLineId) {
		
		//fetch the cartLine
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine==null) {
			return "result=error";
		}
		else {
			//update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal()-cartLine.getTotal());
			cart.setCartLines(cart.getCartLines()-1);
			cartLineDAO.updateCart(cart);
			
			//remove the cartLine
			cartLineDAO.delete(cartLine);
			return "result=deleted";
		}
	}

	public String addCartLine(int productId) {
		
		String response = null;
		
		Cart cart = this.getCart(); 
		
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		
		if(cartLine==null){
			 // add a new cart line
			cartLine = new CartLine();
			
			Product product = productDAO.getProduct(productId);
			
			cartLine.setBuyingPrice(product.getUnitPrice());
			
			cartLine.setCartId(cart.getId() );
			cartLine.setProduct(product);
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setActiveInd(true);
			
			cartLineDAO.add(cartLine);
			
			
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			response = "result=added";
		}
		
		else {
			
			//check if the cart Lines has reached max count ie 3
			
			if(cartLine.getProductCount() < 3) {
				//update product count for that cartLine
				response = manageCartLine(cartLine.getId(), cartLine.getProductCount()+1);
			}
			else {
				response = "result=maximum";
			}
		}
		
		return response;
	}

}
