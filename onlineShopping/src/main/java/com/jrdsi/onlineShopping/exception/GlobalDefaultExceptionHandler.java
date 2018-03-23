package com.jrdsi.onlineShopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class )
	public ModelAndView handlerNohandlerFoundException(){
 		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The page is not constructed");
		mv.addObject("errorDescription", "The page you are looking for is currently not available");
		mv.addObject("tilte","404 Error page");
		return mv;
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException(){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product Not Available");
		mv.addObject("errorDescription", "The product you are looking for is not available right now");
		mv.addObject("title", "Product Unavailable");
		return mv;
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ModelAndView handlerCategoryNotFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Category Not Available");
		mv.addObject("errorDescription", "The Entered CategoryId is not Exists !!");
		mv.addObject("title", "Category Not Exists");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerGeneralException(Exception ex){
		ModelAndView mv = new ModelAndView("error");
		// only For Debugging purpose use this code
		/*StringWriter sw = new StringWriter();
		PrintWriter out = new PrintWriter(sw);
		ex.printStackTrace(out);
		mv.addObject("errorDescription", sw.toString());*/
		
		mv.addObject("errorTitle","Contact your Administrator !!");
		mv.addObject("errorDescription", ex.toString());
		mv.addObject("title", "Error");
		return mv;
	}

}
