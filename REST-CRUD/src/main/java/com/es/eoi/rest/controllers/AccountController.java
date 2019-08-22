package com.es.eoi.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.eoi.rest.entities.Cuenta;
import com.es.eoi.rest.services.AccountServiceImpl;

@RestController("/accounts")
public class AccountController{

	private AccountServiceImpl service;
	
	@PostMapping("/create/")
	public boolean create(@RequestBody Cuenta c) {
		return this.service.create(c);
	}

	@GetMapping("/read/{c}")
	public Cuenta read(Cuenta c) {
		return this.service.read(c);
	}

	@GetMapping("/readByID/{id}")
	public Cuenta readByID(int id) {
		return this.service.readByID(id);
	}

	@GetMapping("/readAll")
	public List<Cuenta> readAll() {
		return this.service.readAll();
	}

	@PutMapping("/update/{c}")
	public boolean update(Cuenta c) {
		return this.service.update(c);
	}

	@DeleteMapping("/delete/{c}")
	public boolean delete(Cuenta c) {
		return this.service.delete(c);
	}

	
	
}
