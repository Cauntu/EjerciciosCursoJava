package com.es.eoi.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.eoi.rest.entities.Cliente;
import com.es.eoi.rest.services.ClientServiceImpl;

@RestController
public class ClientController{

	private ClientServiceImpl service;
	
	@PostMapping("/create")
	public boolean create(@RequestBody Cliente c) {
		return this.service.create(c);
	}

	@GetMapping("/read/{c}")
	public Cliente read(Cliente c) {
		return this.service.read(c);
	}

	@GetMapping("/readByID/{id}")
	public Cliente readByID(int id) {
		return this.service.readByID(id);
	}

	@GetMapping("/readAll")
	public List<Cliente> readAll() {
		return this.service.readAll();
	}

	@PutMapping("/update/{c}")
	public boolean update(Cliente c) {
		return this.service.update(c);
	}

	@DeleteMapping("/delete/{c}")
	public boolean delete(Cliente c) {
		return this.service.delete(c);
	}

}
