package com.themlyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.themlyf.dao.UserDAO;
import com.themlyf.model.User;

@Service("userService")
public class UserServiceDAO {

	@Autowired(required = false)
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User createUser(User user) {
		return userDAO.save(user);
	}

	public boolean checkUser(String email) {
		List<User> userList = userDAO.findAll();
		for (User user2 : userList) {
			if (user2.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

	public int isExistUser(String email,String password) {
		
		List<User> userList = userDAO.findAll();
		for (User user2 : userList) {
			if (user2.getEmail().equalsIgnoreCase(email) && user2.getPassword().equals(password)) {
				return user2.getId();
			}
		}
		return 0;
	}

	public User getUser(int id) {
		return userDAO.getOne(id);
	}

	public List<User> getAllUserList() {
		return userDAO.findAll();
	}
}
