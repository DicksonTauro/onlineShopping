package com.jrdsi.onlineShopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jrdsi.onlineShopping.exception.CategoryNotFoundException;
import com.jrdsi.onlineShopping.exception.ProductNotFoundException;
import com.jrdsi.onlineShoppingBackend.dao.ProductDAO;
import com.jrdsi.onlineShoppingBackend.daoimpl.CategoryDAOImpl;
import com.jrdsi.onlineShoppingBackend.dto.Category;
import com.jrdsi.onlineShoppingBackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	CategoryDAOImpl categoryDao;
	
	@Autowired
	ProductDAO productDao;
	 
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index (){
		
		logger.info("In pagecontroller index method -INFO");
		
		logger.debug("In pagecontroller index method - DEBUG");
		
		ModelAndView mv = new  ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categories", categoryDao.getCategories());
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about(){
		ModelAndView mv = new  ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact(){
		ModelAndView mv = new  ModelAndView("page");
		mv.addObject("title", "Contact us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	
	//Access denied handler mapping for spring security
	@RequestMapping("/access-denied")
	public ModelAndView accessDenied(){
		ModelAndView mv = new  ModelAndView("error");
		mv.addObject("errorTitle", "No Permission");
		mv.addObject("errorDescription", "UnAuthorised Access");
		mv.addObject("tilte","403 - Access Denied");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(required = false) String error ,@RequestParam(required = false) String logout){
		ModelAndView mv = new  ModelAndView("login");
		if(error != null){
			mv.addObject("error","Invalid User Name or password");
		}
		
		if(logout != null){
			mv.addObject("logout","User has successfully logged out");
		}
		mv.addObject("title", "Login");
		return mv;
	}
	
/*	@RequestMapping(value = "/test")
	public ModelAndView test(@RequestParam (required=false) String greet){
		if(greet == null){
			greet = "welcome";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greet);
		return mv;
	}
	
	@RequestMapping(value = "/testPath/{greet}")
	public ModelAndView testpath(@PathVariable (required = false)String greet){
		if(greet == null){
			greet = "welcome";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greet);
		return mv;
	}
*/
	
	//methods to load All the products based on the category
	@RequestMapping(value = "/show/all/products")
	public ModelAndView  showAllProducts(){
		ModelAndView mv = new  ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories", categoryDao.getCategories());
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView  showCategorisedProducts(@PathVariable Integer id) throws CategoryNotFoundException {
		ModelAndView mv = new  ModelAndView("page");
		//category dao to fetch a single category
		
		Category category = categoryDao.getCategory(Long.valueOf(id));
		
		if(category == null)
			throw new CategoryNotFoundException();
		
		mv.addObject("title", category.getName());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("categories", categoryDao.getCategories());
		return mv;
	}
//viewing single product
	@RequestMapping("/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable Integer id ) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		Product product = productDao.getProduct(id);
		
		if(product==null) throw new ProductNotFoundException();
			
		product.setViews(product.getViews()+1);
		productDao.updateProduct(product);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
	
	//For LogOUt
	
	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		//fetch the authentication object	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
			
		}
		return "redirect:/login?logout";
	}
	
	
	
}
