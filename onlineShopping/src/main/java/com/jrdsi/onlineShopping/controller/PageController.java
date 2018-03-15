package com.jrdsi.onlineShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index (){
		ModelAndView mv = new  ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
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
}