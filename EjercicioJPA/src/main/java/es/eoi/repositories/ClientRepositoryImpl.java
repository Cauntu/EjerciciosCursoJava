package es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import es.eoi.entities.Cliente;

public class ClientRepositoryImpl implements MyRepository<Cliente> {

	@SuppressWarnings("unused")
	private EntityManagerFactory emf;
	private EntityManager em;

	public ClientRepositoryImpl() {

		this.emf = Persistence.createEntityManagerFactory("EJERCICIOPU");
		this.em = emf.createEntityManager();
	}

	public boolean create(Cliente c) {

		try {

			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			return false;
		}

	}

	public Cliente read(Cliente c) {

		try {

			return em.find(c.getClass(), c.getDni());

		} catch (Exception e) {
			return null;
		}

	}

	public Cliente readByDNI(int dni) {
		@SuppressWarnings("unused")
		Cliente tcliente = null;

		try {

			return (tcliente = em.find(Cliente.class, dni));

		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> readAll() {

		try {
			String hql = "from Clientes";
			Query query = em.createQuery(hql);
			List<Cliente> result = null;
			result = query.getResultList();

			return result;

		} catch (Exception e) {
			return null;
		}

	}

	public boolean update(Cliente c) {
		try {

			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			return false;
		}
	}

	public boolean delete(Cliente c) {

		Cliente cl = null;

		try {

			cl = em.find(Cliente.class, c);
			em.getTransaction().begin();
			em.remove(cl);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public Cliente readByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
