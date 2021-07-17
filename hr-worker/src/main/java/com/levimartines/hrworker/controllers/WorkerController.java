package com.levimartines.hrworker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.levimartines.hrworker.models.Worker;
import com.levimartines.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerController {

	@Autowired
	private WorkerRepository repository;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Worker> findAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Worker findById(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}
}
