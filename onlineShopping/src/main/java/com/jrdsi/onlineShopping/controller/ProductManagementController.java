package com.jrdsi.onlineShopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jrdsi.onlineShopping.util.FileUploadUtility;
import com.jrdsi.onlineShopping.validator.ProductValidator;
import com.jrdsi.onlineShoppingBackend.dao.CategoryDAO;
import com.jrdsi.onlineShoppingBackend.dao.ProductDAO;
import com.jrdsi.onlineShoppingBackend.dto.Category;
import com.jrdsi.onlineShoppingBackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ProductManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	private static final Logger logger = LoggerFactory.getLogger(ProductManagementController.class);
	

	@RequestMapping(value = "/products",method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required = false)String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nproduct = new Product();
		
		nproduct.setActiveInd(Boolean.TRUE);
		
		nproduct.setSupplierId(1);
		
		mv.addObject("product", nproduct);
		
		if(operation!=null ){
			
			if(operation.equals("product")){
				mv.addObject("message", "Product Added Succefully");
				mv.addObject("Class", "alert-success");
			}
			
			if(operation.equals("category")){
				mv.addObject("message", "Category Added Succefully");
				mv.addObject("Class", "alert-success");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/category",method=RequestMethod.POST)
	public String handleCreateCategory(@ModelAttribute Category category){
		categoryDAO.addCategory(category);
		return "redirect:/manage/products/?operation=category";		
	}
	
	//returning categories for all request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.getCategories();
	}
	
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
	
	//handling product form submission
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product")Product updatedProduct,
			                                                               BindingResult bindingResult,
			                                                               Model model,
			                                                               HttpServletRequest req  ){
			                                                              
		logger.info(updatedProduct.toString());
		
		
		
		if(updatedProduct.getId() ==null || updatedProduct.getId().equals(0)){
			new ProductValidator().validate(updatedProduct, bindingResult);
		}
		else {
			if(!updatedProduct.getFile().getOriginalFilename().trim().equals("")){
				new ProductValidator().validate(updatedProduct, bindingResult);
			}
		}
		
		
		
		if(bindingResult.hasErrors()){
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "valiadtion failed for product sumission");
			model.addAttribute("Class", "alert-danger");
			return "page";
			
		}
		
		if(!updatedProduct.getFile().getOriginalFilename().trim().equals("")){
			FileUploadUtility.uploadFile(req, updatedProduct.getFile(), updatedProduct.getCode());
		}
		
		if(updatedProduct.getId() ==null || updatedProduct.getId().equals(0)){
			productDAO.addProduct(updatedProduct);
		}
		else {
			productDAO.updateProduct(updatedProduct);
		}
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/products/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable Integer id){
		
		Product product = productDAO.getProduct(id);
		
		boolean activeInd = product.getActiveInd();
		
		product.setActiveInd(Boolean.valueOf(!activeInd));
		
		productDAO.updateProduct(product);
		 
		return activeInd ? "You have succefully deactivated product with id "+id:
			               "You have succefully activated product with id "+id;
	}
	
	
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView getProductDetailsToView(@PathVariable Integer id) {
		
		ModelAndView mv  = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product product = productDAO.getProduct(id);
		mv.addObject("product",product);
		return mv;
	}
	
	
	
	
	
}
