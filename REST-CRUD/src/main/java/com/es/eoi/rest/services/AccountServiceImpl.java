package com.es.eoi.rest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.eoi.rest.entities.Cuenta;
import com.es.eoi.rest.repositories.AccountRepositoryImpl;
import com.es.eoi.rest.repositories.MyRepository;

@Service
public class AccountServiceImpl implements MyService<Cuenta>{
	
	public MyRepository<Cuenta> ar = new AccountRepositoryImpl();
	
	public boolean create(Cuenta c) {
		
		return this.ar.create(c);
	}

	public Cuenta read(Cuenta c) {
		return this.ar.read(c);
	}

	public Cuenta readByID(int id) {
		return this.ar.readByID(id);
	}

	public List<Cuenta> readAll() {
		return this.ar.readAll();
	}

	public boolean update(Cuenta c) {
		return this.ar.update(c);
	}

	public boolean delete(Cuenta c) {
		return this.ar.delete(c);
	}

}
