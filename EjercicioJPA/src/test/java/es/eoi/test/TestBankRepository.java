package es.eoi.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.eoi.entities.Banco;
import es.eoi.repositories.BankRepositoryImpl;
import es.eoi.repositories.MyRepository;

public class TestBankRepository {

	MyRepository<Banco> repo;

	@Before
	public void setUp() {
		repo = new BankRepositoryImpl();
	}

	@Test
	public void testCreate() {
		
		Banco b = new Banco();
		b.setNombre("Banco1");
		b.setIdBanco(123);
		
		assertEquals(true, repo.create(b));
	}

	@Test
	public void testRead() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
