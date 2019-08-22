package com.es.eoi.rest.services;

import java.util.List;

import com.es.eoi.rest.entities.Cliente;
import com.es.eoi.rest.repositories.ClientRepositoryImpl;
import com.es.eoi.rest.repositories.MyRepository;

public class ClientServiceImpl implements MyService<Cliente>{
	
	public MyRepository<Cliente> cr = new ClientRepositoryImpl();
	
	public boolean create(Cliente c) {
		
		return this.cr.create(c);
	}

	public Cliente read(Cliente c) {
		return this.cr.read(c);
	}

	public Cliente readByID(int dni) {
		return this.cr.readByID(dni);
	}

	public List<Cliente> readAll() {
		return this.cr.readAll();
	}

	public boolean update(Cliente c) {
		return this.cr.update(c);
	}

	public boolean delete(Cliente c) {
		return this.cr.delete(c);
	}

}
