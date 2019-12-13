package com.themlyf.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.themlyf.model.User;
import com.themlyf.model.UserLogin;
import com.themlyf.service.UserServiceDAO;

@RestController
@RequestMapping(value = "/login")
public class UserCRUDLoginController {

	@Autowired
	UserServiceDAO userService;
	public void setUserService(UserServiceDAO userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/loginPage")
	public ModelAndView getLoginPage()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("userLogin", new UserLogin());
		mav.addObject("message","USER LOGIN PAGE");
		mav.setViewName("UserLoginPage");
		return mav;
	}
	
	@PostMapping(value = "/loginUser")
	public ModelAndView loginUser(@Valid UserLogin login, BindingResult result,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors())
		{
			
			mav.addObject("userLogin", login);
			mav.addObject("message","USER LOGIN PAGE");
			mav.setViewName("UserLoginPage");
			return mav;
		}
		
		String email = login.getEmail();
		String password = login.getPassword();
			if(userService.checkUser(email))
			{
				
				int id = userService.isExistUser(email,password);
				if(id == 0)
				{
					mav.addObject("userLogin", login);
					mav.addObject("errorMessage","INVALID CREDENTIAL");
					mav.setViewName("UserLoginPage");
					return mav;
				}
				User userData = userService.getUser(id);
				mav.addObject("userData", userData);
				session.setAttribute("id", id);
				session.setAttribute("email", email);
				mav.setViewName("UserHome");
				return mav;
			}
			else
			{
				mav.setViewName("failue");
				mav.addObject("message","NO USER EXIST WITH THE EMAIL ADDRESS");
				return mav;
			}
		}
	
	@GetMapping(value = "/logOut")
	public ModelAndView logoutUser(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("email");
		session.removeAttribute("password");
		session.invalidate();
		
		mav.addObject("userLogin", new UserLogin());
		mav.addObject("message","USER LOGIN PAGE");
		mav.setViewName("UserLoginPage");
		return mav;
	}
	
	}