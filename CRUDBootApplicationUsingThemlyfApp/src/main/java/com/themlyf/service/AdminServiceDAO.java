package com.themlyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.themlyf.dao.AdminDAO;
import com.themlyf.model.Admin;

@Service("adminService")
public class AdminServiceDAO {
	
	@Autowired
	private AdminDAO adminDAO;
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	
	public boolean checkAdminExist()
	{
	   List<Admin> list = adminDAO.findAll();	
	   if(list.size() > 0)
	   {
		   return true;
	   }
	   else
	   {
		   return false;
	   }
	}
	
	public Admin createAdmin(Admin admin)
	{
		return adminDAO.save(admin);
	}

	public boolean authenicateAdmin(String email, String password) {
		
		List<Admin> list = adminDAO.findAll();
		
		for (Admin admin : list) {
			
			if(admin.getEmail().equalsIgnoreCase(email) && admin.getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}
}
