package com.levimartines.hruser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.levimartines.hruser.models.User;
import com.levimartines.hruser.repositories.UserRepository;

@RestController
@RequestMapping("/users")
@RefreshScope
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User findById(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}

	@GetMapping("/search")
	@ResponseStatus(HttpStatus.OK)
	public User findById(@RequestParam String email) {
		return repository.findByEmail(email).orElse(null);
	}
}
