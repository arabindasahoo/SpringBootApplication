package com.themlyf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
public class HomeController {
	
	@GetMapping(value = "/")
	public ModelAndView getHome()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("message", "WELCOME TO SPRING BOOT CRUD APPLICATION HOME");
		return mav;
	}
	
	@GetMapping(value = "/adminHome")
	public ModelAndView getAdminHomePage()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminHomePage");
		mav.addObject("message", "WELCOME ADMIN HOME PAGE");
		return mav;
	}
	
	@GetMapping(value = "/userHome")
	public ModelAndView getUserHomePage()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userHomePage");
		return mav;
	}
}
