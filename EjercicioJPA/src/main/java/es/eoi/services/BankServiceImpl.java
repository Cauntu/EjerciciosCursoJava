package es.eoi.services;

import java.util.List;

import es.eoi.entities.Banco;
import es.eoi.repositories.BankRepositoryImpl;
import es.eoi.repositories.MyRepository;

public class BankServiceImpl implements MyService<Banco>{
	
	public MyRepository<Banco> br = new BankRepositoryImpl();
	
	public boolean create(Banco c) {
		
		return this.br.create(c);
	}

	public Banco read(Banco b) {
		return this.br.read(b);
	}

	public Banco readByID(int id) {
		return this.br.readByID(id);
	}

	public List<Banco> readAll() {
		return this.br.readAll();
	}

	public boolean update(Banco b) {
		return this.br.update(b);
	}

	public boolean delete(Banco b) {
		return this.br.delete(b);
	}

}
