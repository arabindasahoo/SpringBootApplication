package com.themlyf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.themlyf.model.Admin;

@RestController
@RequestMapping(value = "/admin")
public class AdminCRUDController {

	@GetMapping(value = "/registerAdmin")
	public ModelAndView getAdminRegisterPage()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminRegister");
		mav.addObject("message", "WELCOME TO ADMIN REGISTER PAGE");
		mav.addObject("admin", new Admin());
		mav.addObject("country", getCountries());
		mav.addObject("status", getMaritalStatus());
		return mav;
	}
	
	
	public List<String> getCountries()
	{
		List<String> list = new ArrayList<String>();
		
		list.add("INDIA");
		list.add("BANGLADESH");
		list.add("RUSSIA");
		list.add("CHINA");
		list.add("PAKISTAN");
		
		return list;
	}

	
	public List<String> getMaritalStatus()
	{
		List<String> list = new ArrayList<String>();
		
		list.add("MARRIED");
		list.add("UNMARRIED");
		list.add("DIVORCED");
		
		return list;
	}
}
