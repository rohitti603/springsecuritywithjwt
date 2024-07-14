package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UsersService service;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return service.saveUser(user);
		
	}
	
	@GetMapping("/test")
	public String test() {
		return "working without login";
		
	}
	
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		if(authenticate.isAuthenticated()) {
			//return "success";
			return jwtService.generateToken(user.getUserName());
		}else {
			return "login Failed";
		}
		
	}

}
