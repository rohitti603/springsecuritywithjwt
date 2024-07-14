package com.example.demo.config;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Users;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsersRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=repo.findByUserName(username);
		if(user==null) {
		//	throw new UserPrincipalNotFoundException("test");
			System.out.println("user not found hgggggggggggg ");
		}
		return new UserPrinciple(user);
	}

}
