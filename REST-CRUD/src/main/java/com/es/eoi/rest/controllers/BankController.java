package com.es.eoi.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es.eoi.rest.entities.Banco;
import com.es.eoi.rest.services.BankServiceImpl;

@RestController
public class BankController {

	private BankServiceImpl service;

	@PostMapping("/create/{b}")
	public boolean create(Banco b) {
		return this.service.create(b);
	}

	@GetMapping("/read/{b}")
	public Banco read(Banco b) {
		return this.service.read(b);
	}

	@GetMapping("/readByID/{id}")
	public Banco readByID(int id) {
		return this.service.readByID(id);
	}

	@GetMapping("/readAll")
	public List<Banco> readAll() {
		return this.service.readAll();
	}

	@PutMapping("/update/{b}")
	public boolean update(Banco b) {
		return this.service.update(b);
	}

	@DeleteMapping("/delete/{b}")
	public boolean delete(Banco b) {
		return this.service.delete(b);
	}

}
