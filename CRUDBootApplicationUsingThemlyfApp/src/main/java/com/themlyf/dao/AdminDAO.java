package com.themlyf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themlyf.model.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {

}
