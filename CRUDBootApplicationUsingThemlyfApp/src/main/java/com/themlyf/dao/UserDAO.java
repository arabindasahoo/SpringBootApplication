package com.themlyf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themlyf.model.User;


@Repository("userDAO")
public interface UserDAO extends JpaRepository<User, Integer> {

		
}
