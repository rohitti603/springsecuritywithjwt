package com.example.demo.config;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.controller.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{
	public Users findByUserName(String name);

}
