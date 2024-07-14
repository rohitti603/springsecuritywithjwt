package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	List<Student> list = new ArrayList<>();

	List<Student> list1 = Arrays.asList(new Student(1, "Navin", "Java"), new Student(2, "kiran", "BlackChain"));

	@GetMapping("getStudent")
	public List<Student> allStudent() {
		list.addAll(list1);
		return list;
	}

	@PostMapping("addStudent")
	public String addStudent(@RequestBody Student st) {
		try {
			list.add(st);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "success";
	}

	@GetMapping("getCsrfToken")
	public CsrfToken getCsrfToken(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}
}