package com.themlyf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.themlyf.model.AdminLogin;
import com.themlyf.service.AdminServiceDAO;

@RestController
@RequestMapping(value = "/adminLogin")
public class AdminCRUDLoginController {
	
	@Autowired
	private AdminServiceDAO adminServiceDAO;
	
	@GetMapping(value = "/loginAdmin")
	public ModelAndView getAdminLoginPage()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("adminLogin", new AdminLogin());
		mav.setViewName("adminLogin");
		mav.addObject("message", "WELCOME TO ADMIN LOGIN PAGE");
		return mav;
	}
	
	@PostMapping(value = "/login")
	public ModelAndView loginAdmin(@Valid AdminLogin login,BindingResult result)
	{
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors())
		{
			mav.addObject("adminLogin", login);
			mav.setViewName("adminLogin");
			mav.addObject("message", "WELCOME TO ADMIN LOGIN PAGE");
			return mav;
		}
		else
		{
			String email = login.getEmail();
			String password = login.getPassword();
			
			if(adminServiceDAO.checkAdminExist())
			{
				if(adminServiceDAO.authenicateAdmin(email,password))
				{
					mav.setViewName("adminHome");
					mav.addObject("message", "WELCOME TO ADMIN HOME PAGE");
					return mav;
				}
				else
				{
					mav.addObject("adminLogin", login);
					mav.setViewName("adminLogin");
					mav.addObject("message", "INVALID CREDENTIAL FOUND");
					return mav;
				}
			}
			else
			{
				mav.setViewName("failure");
				mav.addObject("message", "NO ADMIN CREATED YET");
				return mav;
			}
		}
	}

}
