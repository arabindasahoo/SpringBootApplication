package com.themlyf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.themlyf.model.Admin;
import com.themlyf.model.User;
import com.themlyf.service.AdminServiceDAO;

@RestController
@RequestMapping(value = "/admin")
public class AdminCRUDController {

	@Autowired
	private AdminServiceDAO adminService;
	
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
	
	@PostMapping(value = "/createAdmin")
	public ModelAndView createAdmin(@Valid Admin admin,BindingResult result)
	{
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors())
		{
			mav.setViewName("adminRegister");
			mav.addObject("message", "WELCOME TO ADMIN REGISTER PAGE");
			mav.addObject("admin", admin);
			mav.addObject("country", getCountries());
			mav.addObject("status", getMaritalStatus());
			return mav;
		}
		else
		{	
			if(adminService.checkAdminExist())
			{
				mav.setViewName("adminRegister");
				mav.addObject("message", "ADMIN ALREADY EXIST");
				mav.addObject("admin", admin);
				mav.addObject("country", getCountries());
				mav.addObject("status", getMaritalStatus());
				return mav;
			}
			else
			{
				Admin adminSaved = adminService.createAdmin(admin);
				mav.setViewName("success");
				mav.addObject("message", "ADMIN REGISTRATION SUCCESSFULL");
				mav.addObject("adminSaved", adminSaved);
				return mav;
			}
		}
	}
	
	@GetMapping(value = "/showAllUser")
	public ModelAndView getAllUser()
	{
		ModelAndView mav = new ModelAndView();
		List<User> user = adminService.getAllUser();
		mav.addObject("userList", user);
		for (User user2 : user) {
		System.out.println(user2);
		}
		mav.addObject("message", "ALL USER LIST HERE");
		mav.setViewName("AlluserList");
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
