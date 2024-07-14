package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.UsersRepo;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepo repo;

	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}
	
	

}
