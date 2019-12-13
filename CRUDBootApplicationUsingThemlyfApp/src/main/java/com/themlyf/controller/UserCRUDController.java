package com.themlyf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.themlyf.model.User;
import com.themlyf.service.UserServiceDAO;

@RestController
@RequestMapping(value = "/users")
public class UserCRUDController {
	
	@Autowired
	private UserServiceDAO userService;
	public void setUserService(UserServiceDAO userService) {
		this.userService = userService;
	}
	

	@GetMapping(value = "/getHome")
	public ModelAndView getHome()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userHomePage");
		return mav;
	}
	
	@GetMapping(value = "/registerPage")
	public ModelAndView getResiterPage(Model model)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new User());
		mav.addObject("designation", getDesignation());
		mav.addObject("maritalStatus", getMaritalStatus());
		mav.addObject("countries", getCountries());
		mav.setViewName("UserRegisterPage");
	
		return mav;
	}
	
	@PostMapping(value = "/createUser")
	public ModelAndView createUser(@Valid User user,BindingResult result)
	{
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors())
		{
			mav.addObject("user", user);
			mav.addObject("designation", getDesignation());
			mav.addObject("maritalStatus", getMaritalStatus());
			mav.addObject("countries", getCountries());
			mav.setViewName("UserRegisterPage");
			return mav;
		}
		else
		{
			String email = user.getEmail();
			if(userService.checkUser(email))
			{
				mav.addObject("designation", getDesignation());
				mav.addObject("maritalStatus", getMaritalStatus());
				mav.addObject("countries", getCountries());
				mav.addObject("message", "User Already Exist In the Databaase With Same Email Id");
				mav.setViewName("UserRegisterPage");
				return mav;
			}
			else
			{
			user.setApproval(0);
			userService.createUser(user);
			mav.addObject("message", "USER SAVED IN DATABASE SUCCESSFULLY");
			mav.setViewName("success");
			return mav;
			}
		}
	}
	
	@GetMapping(value = "/getAllUsers")
	public List<User> getAllUsers()
	{
		return userService.getAllUserList();
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
	
	

	public List<String> getDesignation()
	{
		List<String> list = new ArrayList<String>();
		
		list.add("TEAMLEAD");
		list.add("TRAINNE");
		list.add("MANAGER");
		list.add("CEO");
		list.add("CHAIRMAN");
		
		return list;
	}
}
