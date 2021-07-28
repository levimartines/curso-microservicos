package com.levimartines.hrworker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.levimartines.hrworker.models.Worker;
import com.levimartines.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
@Slf4j
public class WorkerController {

	@Value("${test.config}")
	private String testConfig;

	@Autowired
	private WorkerRepository repository;

	@Autowired
	private Environment environment;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Worker> findAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Worker findById(@PathVariable Long id) {
/*		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		log.info("CONFIG = {}", testConfig);
		log.info("PORT: {}", environment.getProperty("local.server.port"));
		return repository.findById(id).orElse(null);
	}
}
