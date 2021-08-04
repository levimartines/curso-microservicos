package com.levimartines.hrauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.levimartines.hrauth.models.User;
import com.levimartines.hrauth.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/search")
	public User findByEmail(@RequestParam String email) {
		return (User) service.loadUserByUsername(email);
	}
}
