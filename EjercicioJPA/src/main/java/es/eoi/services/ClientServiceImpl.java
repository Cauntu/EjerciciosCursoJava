package es.eoi.services;

import java.util.List;

import es.eoi.entities.Cliente;
import es.eoi.repositories.ClientRepositoryImpl;
import es.eoi.repositories.MyRepository;

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
